
## 📈 Recursive Financial Forecasting Tool (INR)

This project provides a Java-based implementation of a financial forecasting tool using **recursion**. It demonstrates how to model future value calculations and explains the importance of optimization techniques like **memoization**. This version is localized to use the Indian Rupee (₹) as the currency symbol.

---

## 📂 Table of Contents

- [🌐 Project Overview](#-project-overview)
- [🧠 Core Concept: Recursion](#-core-concept-recursion)
- [🏗️ Project Structure](#️-project-structure)
- [🚀 How to Compile and Run](#-how-to-compile-and-run)
- [📊 Analysis and Optimization](#-analysis-and-optimization)
- [✅ Expected Output](#-expected-output)

---

## 🌐 Project Overview

This tool is designed to predict the future value of an initial investment given a constant annual growth rate. The primary goal of this exercise is to showcase the elegance and power of recursion for problems that can be defined in terms of themselves. The project includes both a straightforward recursive implementation and an optimized version to illustrate best practices.

## 🧠 Core Concept: Recursion

> **Recursion** is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem. A function that calls itself is said to be recursive.

A recursive algorithm must have two key parts:
1. **Base Case:** A condition that terminates the recursion, preventing infinite loops. In this project, the base case is `years == 0`.
2. **Recursive Step:** The logic that breaks the problem down and calls the function again with a modified input, moving it closer to the base case. Here, it's `calculateFutureValue(..., years - 1)`.

---

## 🏗️ Project Structure

The project uses a minimal and clean structure, containing a single source file.

```

.
└── src
└── FinancialForecasting.java  # Contains all logic and the main method

````

---

## 🚀 How to Compile and Run

> **📌 Note:** Since no packages are used, you can compile and run directly from the `src` directory where the `.java` file is located.

<details>
<summary><strong>Windows, macOS, & Linux Instructions</strong></summary>

1. **Open your terminal** and navigate to this project's `src` directory.

```bash
cd /path/to/your/project/RecursiveFinancialForecasting/src
````

2. **Compile the `.java` source file.** This creates the `FinancialForecasting.class` file.

```bash
javac FinancialForecasting.java
```

3. **Run the application.** Use the `java` command followed by the class name.

```bash
java FinancialForecasting
```

</details>

---

## 📊 Analysis and Optimization

### Time Complexity

The simple recursive method `calculateFutureValue` has a time complexity of **O(n)**, where `n` is the number of years. This is because it makes one recursive call for each year, resulting in a linear number of operations. This is generally considered efficient.

### Optimization with Memoization

In more complex financial models, a recursive function might calculate the same year's value multiple times (an issue known as "overlapping subproblems"). To prevent this, we use **memoization** to cache results and ensure that each year's value is calculated only once. The `calculateFutureValueOptimized` method demonstrates this, guaranteeing an efficient **O(n)** time complexity.

---

## ✅ Expected Output

Running the `main` method will produce the following output, formatted with the Indian Rupee symbol.

```plaintext
### Financial Forecasting Tool (INR) ###
Initial Investment: Rs.100000.00
Annual Growth Rate: 8.00%
Forecasting Period: 15 years
----------------------------------------

1. Simple Recursive Calculation:
Predicted Future Value: Rs.317216.91

2. Optimized Recursive Calculation (with Memoization):
Predicted Future Value: Rs.317216.91
```

---

> Made with 💡 recursion and a passion.


