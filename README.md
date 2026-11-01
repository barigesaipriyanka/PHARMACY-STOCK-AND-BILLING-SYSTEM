# MediStock – Pharmacy Stock and Billing System

A console-based Java application for managing pharmacy medicine stock and generating customer bills.

## Features
- Add and display medicines
- Search medicines by name or ID
- Delete and restock medicines
- Sell medicines and generate bills
- Apply discounts and calculate 12% GST
- View low-stock and near-expiry medicines
- Calculate total stock value and daily sales

## Requirements
- Java JDK 8 or later
- Eclipse IDE (or any Java IDE)

## Run in Eclipse
1. Extract or clone this repository.
2. Open Eclipse.
3. Select **File → Import → Existing Projects into Workspace**.
4. Choose the extracted `MediStock-GitHub` folder.
5. Open `src/Medistock/MediStock.java`.
6. Right-click the file and select **Run As → Java Application**.

## Run from a terminal
From the project folder:

```bash
javac -d bin src/Medistock/MediStock.java
java -cp bin Medistock.MediStock
```

## Notes
- Medicine and sales data are stored in memory while the program is running.
- Data is reset when the application is closed.
- The package name is `Medistock` and the main class is `MediStock`.
