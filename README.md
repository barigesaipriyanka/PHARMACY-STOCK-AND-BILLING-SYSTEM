# MediStock - Pharmacy Stock and Billing System

A console-based Java application to manage pharmacy stock and generate customer bills.
Uses only `java.util.Scanner` and `java.util.ArrayList` (no file storage; data lives in memory).

## Features
- Add, display, search (by name / ID), delete medicines
- Restock medicines
- Sell medicine and generate bill with 12% GST (expired medicines are blocked)
- Low stock (quantity <= 5) and near expiry (<= 3 months) reports
- Total stock value and daily sales

## OOP concepts used
- Interface (`Billable`)
- Inheritance (`PrescriptionMedicine` extends `Medicine`)
- Method overloading (`calculateBill(qty)` / `calculateBill(qty, discount)`)
- Method overriding (`PrescriptionMedicine.calculateBill`)
- Encapsulation (private fields with getters/setters)

## Project structure
```
MediStock/
├── .gitignore
├── README.md
└── src/
    ├── Billable.java
    ├── Medicine.java
    ├── PrescriptionMedicine.java
    └── MediStock.java
```

## How to run
```bash
javac -d out src/*.java
java -cp out MediStock
```
Requires JDK 8 or higher.
