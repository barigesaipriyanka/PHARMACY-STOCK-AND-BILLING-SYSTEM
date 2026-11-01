import java.util.ArrayList;
import java.util.Scanner;

public class MediStock {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Medicine> medicines = new ArrayList<>();
    static double dailySales = 0;
    static final double GST = 12.0;

    // Find medicine using ID
    static Medicine findMedicine(int id) {
        for (Medicine m : medicines) {
            if (m.getMedicineId() == id) {
                return m;
            }
        }
        return null;
    }

    // Add medicine
    static void addMedicine() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findMedicine(id) != null) {
            System.out.println("Medicine ID already exists.");
            return;
        }

        System.out.print("Enter Medicine Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = sc.nextInt();

        System.out.print("Enter Months Left for Expiry: ");
        int months = sc.nextInt();

        if (price <= 0 || quantity < 0 || months < 0) {
            System.out.println("Invalid input values.");
            return;
        }

        Medicine m = new Medicine(id, name, price, quantity, months);
        medicines.add(m);
        System.out.println("Medicine added successfully.");
    }

    // Display all medicines
    static void displayMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("No medicines available.");
            return;
        }
        for (Medicine m : medicines) {
            m.displayMedicine();
        }
    }

    // Search by medicine name
    static void searchByName() {
        sc.nextLine();
        System.out.print("Enter Medicine Name: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Medicine m : medicines) {
            if (m.getMedicineName().equalsIgnoreCase(name)) {
                m.displayMedicine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Medicine not found.");
        }
    }

    // Search by medicine ID
    static void searchById() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();
        Medicine m = findMedicine(id);
        if (m != null) {
            m.displayMedicine();
        } else {
            System.out.println("Medicine not found.");
        }
    }

    // Delete medicine
    static void deleteMedicine() {
        System.out.print("Enter Medicine ID to delete: ");
        int id = sc.nextInt();
        Medicine m = findMedicine(id);
        if (m != null) {
            medicines.remove(m);
            System.out.println("Medicine deleted successfully.");
        } else {
            System.out.println("Medicine not found.");
        }
    }

    // Restock medicine
    static void restockMedicine() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();
        Medicine m = findMedicine(id);
        if (m != null) {
            System.out.print("Enter quantity to add: ");
            int qty = sc.nextInt();
            if (qty <= 0) {
                System.out.println("Enter a valid quantity.");
                return;
            }
            m.setQuantity(m.getQuantity() + qty);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Medicine not found.");
        }
    }

    // Sell medicine and generate bill
    static void sellMedicine() {
        System.out.print("Enter Medicine ID: ");
        int id = sc.nextInt();
        Medicine m = findMedicine(id);

        if (m == null) {
            System.out.println("Medicine not found.");
            return;
        }
        if (m.isExpired()) {
            System.out.println("Medicine is expired. Sale not allowed.");
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("Invalid quantity.");
            return;
        }
        if (qty > m.getQuantity()) {
            System.out.println("Insufficient stock.");
            return;
        }

        double amount = m.calculateBill(qty);
        double gstAmount = amount * GST / 100;
        double total = amount + gstAmount;

        m.setQuantity(m.getQuantity() - qty);
        dailySales += total;

        System.out.println("\n========== CUSTOMER BILL ==========");
        System.out.println("Medicine Name : " + m.getMedicineName());
        System.out.println("Quantity      : " + qty);
        System.out.println("Price         : Rs." + m.getPrice());
        System.out.println("Amount        : Rs." + amount);
        System.out.println("GST (12%)     : Rs." + gstAmount);
        System.out.println("-----------------------------------");
        System.out.println("Total Bill    : Rs." + total);
        System.out.println("===================================");
    }

    // Display low stock medicines
    static void lowStock() {
        boolean found = false;
        System.out.println("\nLow Stock Medicines:");
        for (Medicine m : medicines) {
            if (m.getQuantity() <= 5) {
                m.displayMedicine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No low stock medicines.");
        }
    }

    // Display near expiry medicines
    static void nearExpiry() {
        boolean found = false;
        System.out.println("\nNear Expiry Medicines:");
        for (Medicine m : medicines) {
            if (m.getMonthsLeft() <= 3) {
                m.displayMedicine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No near expiry medicines.");
        }
    }

    // Calculate total stock value
    static void totalStockValue() {
        double total = 0;
        for (Medicine m : medicines) {
            total += m.getPrice() * m.getQuantity();
        }
        System.out.println("Total Stock Value: Rs." + total);
    }

    // Display daily sales
    static void displaySales() {
        System.out.println("Total Sales: Rs." + dailySales);
    }

    // Main method
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== PHARMACY STOCK AND BILLING SYSTEM =====");
            System.out.println("1. Add Medicine");
            System.out.println("2. Display Medicines");
            System.out.println("3. Search Medicine by Name");
            System.out.println("4. Search Medicine by ID");
            System.out.println("5. Delete Medicine");
            System.out.println("6. Restock Medicine");
            System.out.println("7. Sell Medicine / Generate Bill");
            System.out.println("8. Low Stock Medicines");
            System.out.println("9. Near Expiry Medicines");
            System.out.println("10. Total Stock Value");
            System.out.println("11. Daily Sales");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:  addMedicine();        break;
                case 2:  displayMedicines();   break;
                case 3:  searchByName();       break;
                case 4:  searchById();         break;
                case 5:  deleteMedicine();     break;
                case 6:  restockMedicine();    break;
                case 7:  sellMedicine();       break;
                case 8:  lowStock();           break;
                case 9:  nearExpiry();         break;
                case 10: totalStockValue();    break;
                case 11: displaySales();       break;
                case 12:
                    System.out.println("Thank you for using MediStock.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 12);

        sc.close();
    }
}
