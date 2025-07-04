-- #############################################################################
-- #  PL/SQL EXERCISE: STORED PROCEDURES                                       #
-- #  This script creates tables, populates them, creates three stored        #
-- #  procedures, and then executes each one with verification steps.         #
-- #############################################################################

-- Enable server output and set formatting for clear, readable results
SET SERVEROUTPUT ON;
SET LINESIZE 150;
SET PAGESIZE 100;

COLUMN account_id FORMAT 99999 HEADING 'Acct ID';
COLUMN account_type FORMAT A10 HEADING 'Type';
COLUMN balance FORMAT 999,999.99 HEADING 'Balance';
COLUMN employee_id FORMAT 99999 HEADING 'Emp ID';
COLUMN department_id FORMAT 9999 HEADING 'Dept ID';
COLUMN salary FORMAT 9,999,999.99 HEADING 'Salary';

-- =============================================================================
-- I. SETUP: Clean up old objects, create new tables, and insert data
-- =============================================================================
PROMPT **Starting setup: Dropping old objects and creating tables...**
BEGIN
   -- Drop procedures, ignoring errors if they don't exist
   BEGIN EXECUTE IMMEDIATE 'DROP PROCEDURE ProcessMonthlyInterest'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DROP PROCEDURE UpdateEmployeeBonus'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DROP PROCEDURE TransferFunds'; EXCEPTION WHEN OTHERS THEN NULL; END;

   -- Drop tables, ignoring errors if they don't exist
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE employees'; EXCEPTION WHEN OTHERS THEN NULL; END;
   BEGIN EXECUTE IMMEDIATE 'DROP TABLE accounts'; EXCEPTION WHEN OTHERS THEN NULL; END;
END;
/

CREATE TABLE accounts (
    account_id   NUMBER PRIMARY KEY,
    balance      NUMBER(10, 2),
    account_type VARCHAR2(10)
);

CREATE TABLE employees (
    employee_id   NUMBER PRIMARY KEY,
    department_id NUMBER,
    salary        NUMBER(10, 2)
);

PROMPT **Populating tables with initial data...**
BEGIN
    -- Accounts data
    INSERT INTO accounts (account_id, account_type, balance) VALUES (101, 'Savings', 5000.00);
    INSERT INTO accounts (account_id, account_type, balance) VALUES (102, 'Checking', 2500.00);
    INSERT INTO accounts (account_id, account_type, balance) VALUES (103, 'Savings', 12000.00);
    INSERT INTO accounts (account_id, account_type, balance) VALUES (202, 'Savings', 800.00);

    -- Employees data
    INSERT INTO employees (employee_id, department_id, salary) VALUES (7001, 10, 60000.00);
    INSERT INTO employees (employee_id, department_id, salary) VALUES (7002, 20, 75000.00);
    INSERT INTO employees (employee_id, department_id, salary) VALUES (7003, 10, 65000.00);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('SETUP COMPLETE: Tables created and populated.' || CHR(10));
END;
/

-- =============================================================================
-- II. SCENARIO 1: Process Monthly Interest
-- =============================================================================
PROMPT **CREATING PROCEDURE: ProcessMonthlyInterest**
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
  INTEREST_RATE CONSTANT NUMBER := 0.01; -- 1%
  v_rows_updated NUMBER;
BEGIN
  UPDATE accounts
  SET balance = balance + (balance * INTEREST_RATE)
  WHERE account_type = 'Savings';
  
  v_rows_updated := SQL%ROWCOUNT;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for ' || v_rows_updated || ' savings accounts.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END ProcessMonthlyInterest;
/

PROMPT
PROMPT **--- VERIFYING SCENARIO 1: ProcessMonthlyInterest ---**
PROMPT **Accounts Balance BEFORE running procedure:**
SELECT * FROM accounts ORDER BY account_id;

PROMPT **Executing ProcessMonthlyInterest...**
BEGIN
  ProcessMonthlyInterest;
END;
/

PROMPT **Accounts Balance AFTER running procedure (Note the 1% increase for 'Savings' accounts):**
SELECT * FROM accounts ORDER BY account_id;
PROMPT **--- End of Scenario 1 ---**
PROMPT


-- =============================================================================
-- III. SCENARIO 2: Update Employee Bonus
-- =============================================================================
PROMPT **CREATING PROCEDURE: UpdateEmployeeBonus**
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id   IN  employees.department_id%TYPE,
    p_bonus_percent   IN  NUMBER
)
IS
  v_rows_updated NUMBER;
BEGIN
  IF p_bonus_percent IS NULL OR p_bonus_percent <= 0 THEN
    RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage must be a positive number.');
  END IF;

  UPDATE employees
  SET salary = salary + (salary * p_bonus_percent / 100)
  WHERE department_id = p_department_id;
  
  v_rows_updated := SQL%ROWCOUNT;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE(v_rows_updated || ' employees in department ' || p_department_id || ' received a ' || p_bonus_percent || '% bonus.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    RAISE;
END UpdateEmployeeBonus;
/

PROMPT
PROMPT **--- VERIFYING SCENARIO 2: UpdateEmployeeBonus ---**
PROMPT **Employee Salaries BEFORE running procedure:**
SELECT * FROM employees ORDER BY employee_id;

PROMPT **Executing UpdateEmployeeBonus for Dept 10 with a 5% bonus...**
BEGIN
  UpdateEmployeeBonus(p_department_id => 10, p_bonus_percent => 5);
END;
/

PROMPT **Employee Salaries AFTER running procedure (Note increased salary for Dept 10):**
SELECT * FROM employees ORDER BY employee_id;

PROMPT **Testing validation: Executing with an invalid bonus percentage...**
BEGIN
  UpdateEmployeeBonus(p_department_id => 20, p_bonus_percent => -2);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('CAUGHT EXPECTED ERROR: ' || SQLERRM);
END;
/
PROMPT **--- End of Scenario 2 ---**
PROMPT

-- =============================================================================
-- IV. SCENARIO 3: Transfer Funds Between Accounts
-- =============================================================================
PROMPT **CREATING PROCEDURE: TransferFunds**
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id   IN  accounts.account_id%TYPE,
    p_dest_account_id     IN  accounts.account_id%TYPE,
    p_transfer_amount     IN  accounts.balance%TYPE
)
IS
  v_source_balance  accounts.balance%TYPE;
BEGIN
  IF p_transfer_amount <= 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be positive.');
  END IF;
  IF p_source_account_id = p_dest_account_id THEN
    RAISE_APPLICATION_ERROR(-20003, 'Source and destination accounts cannot be the same.');
  END IF;
  
  SAVEPOINT before_transfer;

  SELECT balance INTO v_source_balance FROM accounts
  WHERE account_id = p_source_account_id FOR UPDATE NOWAIT;
  
  IF v_source_balance >= p_transfer_amount THEN
    UPDATE accounts SET balance = balance - p_transfer_amount
    WHERE account_id = p_source_account_id;
    UPDATE accounts SET balance = balance + p_transfer_amount
    WHERE account_id = p_dest_account_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
  ELSE
    RAISE_APPLICATION_ERROR(-20004, 'Insufficient funds in source account ' || p_source_account_id);
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    RAISE_APPLICATION_ERROR(-20005, 'Source account ' || p_source_account_id || ' does not exist.');
  WHEN OTHERS THEN
    ROLLBACK TO before_transfer;
    RAISE;
END TransferFunds;
/

PROMPT
PROMPT **--- VERIFYING SCENARIO 3: TransferFunds ---**
PROMPT **Account Balances BEFORE any transfer:**
SELECT * FROM accounts ORDER BY account_id;

PROMPT **Executing a SUCCEESSFUL transfer of 500 from Acct 101 to 202...**
BEGIN
  TransferFunds(p_source_account_id => 101, p_dest_account_id => 202, p_transfer_amount => 500);
END;
/

PROMPT **Account Balances AFTER successful transfer:**
SELECT * FROM accounts ORDER BY account_id;

PROMPT **Executing a FAILED transfer (insufficient funds) from Acct 202...**
BEGIN
  TransferFunds(p_source_account_id => 202, p_dest_account_id => 101, p_transfer_amount => 9999);
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('CAUGHT EXPECTED ERROR: ' || SQLERRM);
END;
/

PROMPT **Account Balances AFTER failed transfer (Note: Balances are unchanged due to rollback):**
SELECT * FROM accounts ORDER BY account_id;
PROMPT **--- End of Scenario 3 ---**
PROMPT

