
# 🏭 Factory Method Pattern: Document Management System

## 🧠 About the Factory Method Pattern

The Factory Method is a creational design pattern that solves the problem of creating product objects without specifying their concrete classes.

> The Factory Method defines an interface for creating an object, but lets subclasses decide which class to instantiate. This lets a class defer instantiation to its subclasses.

### Key Benefits Demonstrated:
- **Loose Coupling**: The client code (in `Main.java`) is decoupled from the concrete product implementations (`WordDocument`, `PdfDocument`, etc.).
- **Extensibility (Open/Closed Principle)**: The system can be easily extended to support new document types (e.g., `CsvDocument`) by adding a new product class and a corresponding factory, all without modifying existing client code.

---

## 🏗️ Project Structure

The project follows a standard Java package structure to maintain a clean separation of concerns between the product, the creator, and the client.

```
Week1_Design Patterns and  Priciples_Solutions/
├── 02_Implementing_the_Factory_Method_Pattern/
│
├── Code/
│   └── src/
│       └── com/
│           └── example/
│               ├── document/
│               │   ├── Document.java
│               │   ├── ExcelDocument.java
│               │   ├── PdfDocument.java
│               │   └── WordDocument.java
│               │
│               ├── factory/
│               │   ├── DocumentFactory.java
│               │   ├── ExcelDocumentFactory.java
│               │   ├── PdfDocumentFactory.java
│               │   └── WordDocumentFactory.java
│               │
│               └── Main.java
│
└── Output/
    └── factory_method_output.png 
```

---

## ⚙️ Prerequisites

To build and run this project from the command line, you need:

- Java Development Kit (JDK) - Version 8 or higher.
- A terminal or command-line interface (CLI).

---

## 🚀 How to Compile and Run

> **📌 Note:** All commands **must** be executed from the `src` directory. This is the root of the package structure (`com/example/...`) and is crucial for the Java compiler (`javac`) to locate the files correctly.

### 🪟 Windows (Command Prompt / PowerShell)

```powershell
# Replace the path with the actual path to your project
cd "E:\path\to\your\project\FactoryMethodPatternExample\code\src"

# Compile the Java source files
javac com\example\document\*.java com\example\factory\*.java com\example\Main.java

# Run the application
java com.example.Main
```

### 🍎 macOS / 🐧 Linux (Bash / Zsh)

```bash
# Replace the path with the actual path to your project
cd /path/to/your/project/FactoryMethodPatternExample/code/src

# Compile the Java source files
javac com/example/document/*.java com/example/factory/*.java com/example/Main.java

# Run the application
java com.example.Main
```

---

## ✅ Expected Output

A successful run will produce the following output in your terminal:

```
--- Document Management System ---

Using Word Document Factory:
Opening Word document...
Saving Word document...
Closing Word document...

Using PDF Document Factory:
Opening PDF document...
Saving PDF document...
Closing PDF document...

Using Excel Document Factory:
Opening Excel document...
Saving Excel document...
Closing Excel document...

--- System Shutdown ---
```

---

## 📄 License

This project is distributed under the MIT License. See the `LICENSE` file for more information.
