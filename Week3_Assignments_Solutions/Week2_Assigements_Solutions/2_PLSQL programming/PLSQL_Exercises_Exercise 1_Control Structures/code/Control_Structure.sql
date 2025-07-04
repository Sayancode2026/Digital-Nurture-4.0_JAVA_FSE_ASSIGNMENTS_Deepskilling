-- #############################################################################
-- #  PL/SQL EXERCISE: CONTROL STRUCTURES                                      #
-- #  This script creates tables, populates them with sample data,            #
-- #  and runs PL/SQL blocks to solve three different banking scenarios.       #
-- #############################################################################

-- Enable server output to see the results printed by the scripts.
SET SERVEROUTPUT ON;
SET LINESIZE 120;
SET PAGESIZE 50;

-- Formatting for verification query columns
COLUMN customer_name FORMAT A20;
COLUMN age FORMAT 999;
COLUMN interest_rate FORMAT 99.99;
COLUMN balance FORMAT 99999.99;
COLUMN is_vip FORMAT A4;


-- Suppress "table or view does not exist" errors for the DROP statements
WHENEVER SQLERROR CONTINUE NONE;

-- =============================================================================
-- I. SETUP: Clean up old tables and create new ones
-- =============================================================================

BEGIN
   EXECUTE IMMEDIATE 'DROP TABLE loans';
   EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
   WHEN OTHERS THEN
      IF SQLCODE != -942 THEN
         RAISE;
      END IF;
END;
/

CREATE TABLE customers (
    customer_id   NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100),
    date_of_birth DATE,
    balance       NUMBER(10, 2),
    is_vip        CHAR(1) DEFAULT 'N' CHECK (is_vip IN ('Y', 'N'))
);

-- MODIFIED: Added loan_amount column
CREATE TABLE loans (
    loan_id       NUMBER PRIMARY KEY,
    customer_id   NUMBER REFERENCES customers(customer_id),
    loan_amount   NUMBER(12, 2),
    interest_rate NUMBER(4, 2),
    due_date      DATE
);

-- =============================================================================
-- II. DATA INSERTION: Populate tables with sample data
-- =============================================================================
BEGIN
    -- Customers
    INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES
    (101, 'Rohan Sharma', DATE '1985-05-20', 8500.00);

    INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES
    (102, 'Priya Patel', DATE '1958-11-12', 12500.50); -- Over 60, balance > 10k

    INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES
    (103, 'Vikram Singh', DATE '1992-02-29', 9800.00);

    INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES
    (104, 'Anjali Gupta', DATE '1961-07-01', 15000.00); -- Over 60, balance > 10k

    INSERT INTO customers (customer_id, customer_name, date_of_birth, balance) VALUES
    (105, 'Suresh Kumar', DATE '1975-09-15', 25000.00); -- Balance > 10k

    -- Loans (MODIFIED: Added loan amounts)
    INSERT INTO loans (loan_id, customer_id, loan_amount, interest_rate, due_date) VALUES
    (5001, 101, 50000.00, 5.50, SYSDATE + 45);

    INSERT INTO loans (loan_id, customer_id, loan_amount, interest_rate, due_date) VALUES
    (5002, 102, 15000.00, 4.75, SYSDATE + 25); -- Due in next 30 days

    INSERT INTO loans (loan_id, customer_id, loan_amount, interest_rate, due_date) VALUES
    (5003, 103, 75000.00, 6.00, SYSDATE + 100);

    INSERT INTO loans (loan_id, customer_id, loan_amount, interest_rate, due_date) VALUES
    (5004, 104, 20000.00, 5.00, SYSDATE + 15); -- Due in next 30 days

    INSERT INTO loans (loan_id, customer_id, loan_amount, interest_rate, due_date) VALUES
    (5005, 105, 120000.00, 4.25, SYSDATE + 60);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Tables created and populated with initial data.');
    DBMS_OUTPUT.PUT_LINE('-------------------------------------------------------------');
END;
/

-- =============================================================================
-- SCENARIO 1: Apply 1% interest rate discount for customers over 60
-- =============================================================================
DECLARE
    v_age NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || 'SCENARIO 1: Applying interest rate discount for customers over 60...');

    FOR cust IN (SELECT customer_id, date_of_birth FROM customers)
    LOOP
        -- Calculate age
        v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, cust.date_of_birth) / 12);

        -- Check if age is over 60
        IF v_age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1.00
            WHERE customer_id = cust.customer_id;

            DBMS_OUTPUT.PUT_LINE('  - Discount applied for Customer ID: ' || cust.customer_id || ' (Age: ' || v_age || ').');
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 1 Complete.');
END;
/

-- Verification for Scenario 1
PROMPT **VERIFICATION 1: Loan interest rates after discount**
PROMPT **(Note the lower rates for customers 102 and 104)**
SELECT
    l.customer_id,
    c.customer_name,
    TRUNC(MONTHS_BETWEEN(SYSDATE, c.date_of_birth) / 12) AS age,
    l.interest_rate
FROM loans l
JOIN customers c ON l.customer_id = c.customer_id
ORDER BY l.customer_id;


-- =============================================================================
-- SCENARIO 2: Promote customers with balance over $10,000 to VIP
-- =============================================================================
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || 'SCENARIO 2: Promoting customers to VIP status...');

    FOR cust IN (SELECT customer_id, balance FROM customers)
    LOOP
        IF cust.balance > 10000 THEN
            UPDATE customers
            SET is_vip = 'Y'
            WHERE customer_id = cust.customer_id;

            DBMS_OUTPUT.PUT_LINE('  - Customer ID: ' || cust.customer_id || ' promoted to VIP.');
        END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Scenario 2 Complete.');
END;
/

-- Verification for Scenario 2
PROMPT **VERIFICATION 2: Customer VIP status after promotion**
PROMPT **(Note IsVIP is 'Y' for customers 102, 104, and 105)**
SELECT
    customer_id,
    customer_name,
    balance,
    is_vip
FROM customers
ORDER BY customer_id;


-- =============================================================================
-- SCENARIO 3: Send reminders for loans due in the next 30 days
-- =============================================================================
DECLARE
    -- MODIFIED: Added loan_amount to cursor
    CURSOR due_loans_cur IS
        SELECT c.customer_name, l.loan_amount, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    DBMS_OUTPUT.PUT_LINE(CHR(10) || 'SCENARIO 3: Sending reminders for loans due soon...');

    FOR loan_rec IN due_loans_cur
    LOOP
        -- MODIFIED: Added loan amount to the reminder message
        DBMS_OUTPUT.PUT_LINE('  - Reminder: Hello ' || loan_rec.customer_name ||
                             ', your loan of ' || TO_CHAR(loan_rec.loan_amount, 'FM999G999D00') ||
                             ' is due on ' || TO_CHAR(loan_rec.due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('Scenario 3 Complete.');
END;
/



