
# ⚡ E-Commerce Platform: Search Algorithm Analysis

This repository contains a technical analysis and implementation of search algorithms for an e-commerce platform. It demonstrates the critical performance differences between Linear and Binary Search and provides a recommendation for building scalable systems.

---

## 📂 Table of Contents

- [🌐 Project Overview](#-project-overview)
- [💡 Core Concepts Explained](#-core-concepts-explained)
- [🏗️ Project Structure](#️-project-structure)
- [🚀 How to Compile and Run](#-how-to-compile-and-run)
- [📊 Analysis and Recommendation](#-analysis-and-recommendation)
- [✅ Expected Output](#-expected-output)

---

## 🌐 Project Overview

A fast and reliable search function is essential for a positive user experience on any e-commerce site. This project analyzes two fundamental search algorithms—**Linear Search** and **Binary Search**—to illustrate the importance of algorithmic efficiency. It serves as a practical guide to understanding why choosing the right algorithm is critical for application performance and scalability.

---

## 💡 Core Concepts Explained

### 📈 Asymptotic Notation (Big O)

Big O notation describes an algorithm's performance as the input size ($n$) grows. It provides insight into scalability by focusing on the **worst-case scenario**:

- **O(n) - Linear Time:** Time grows linearly with input size. Doubling data ≈ doubling time.
- **O(log n) - Logarithmic Time:** Time grows slowly even as data increases exponentially. A hallmark of efficient algorithms.

---

## 🏗️ Project Structure

The project uses a standard Java package-based structure:

```
.
└── src
    └── com
        └── ecommerce
            ├── model
            │   └── Product.java           # Data entity for a product
            ├── search
            │   └── SearchAlgorithm.java  # Contains the search logic
            └── Main.java                 # Main application entry point/test harness
```

---

## 🚀 How to Compile and Run

> **📌 Note:** All commands **must** be run from the `src` directory.

### 🪟 Windows (Command Prompt / PowerShell)

```powershell
# Navigate to src directory
cd \path\to\your\project\ECommerceSearchOptimization\src

# Compile the Java source files
javac com\ecommerce\model\Product.java com\ecommerce\search\SearchAlgorithm.java com\ecommerce\Main.java

# Run the application
java com.ecommerce.Main
```

### 🍎 macOS / 🐧 Linux (Bash / Zsh)

```bash
# Navigate to src directory
cd /path/to/your/project/ECommerceSearchOptimization/src

# Compile the Java source files
javac com/ecommerce/model/Product.java com/ecommerce/search/SearchAlgorithm.java com/ecommerce/Main.java

# Run the application
java com.ecommerce.Main
```

---

## 📊 Analysis and Recommendation

| Metric                | Linear Search      | Binary Search        |
|----------------------|--------------------|----------------------|
| **Time Complexity**   | O(n)               | O(log n)             |
| **Data Prerequisite** | Unsorted or Sorted | Must be Sorted       |
| **Scalability**       | Poor               | Excellent             |

### ✅ Recommendation

For production-level e-commerce platforms, **Binary Search** (or equivalent scalable mechanisms) is essential. Although Binary Search requires sorted data (with $O(n \log n)$ sorting cost), it delivers **exponentially better performance** as data scales.

In real-world systems, such search functionality is often supported via:

- **Database indexes** (e.g., B-Trees)
- **Search engines** (e.g., Elasticsearch)

These tools use principles derived from Binary Search to ensure fast, scalable performance.

---

## ✅ Expected Output

Successful execution yields:

```
### Linear Search Demonstration
Result: Product[ID=P004, Name=Book, Category=Books]
Linear Search took: 702500 ns

### Binary Search Demonstration
Array has been sorted by productId for binary search.
Result: Product[ID=P004, Name=Book, Category=Books]
Binary Search took: 16800 ns
```

> ⏱️ Note: Timing values may vary by machine and runtime.

---

> Made with 💻 and a passion for performance optimization.
