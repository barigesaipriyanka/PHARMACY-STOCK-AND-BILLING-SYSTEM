public class Medicine implements Billable {

    private int medicineId;
    private String medicineName;
    private double price;
    private int quantity;
    private int monthsLeft;

    // Constructor
    public Medicine(int medicineId, String medicineName, double price,
                    int quantity, int monthsLeft) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.price = price;
        this.quantity = quantity;
        this.monthsLeft = monthsLeft;
    }

    // Getters
    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMonthsLeft() {
        return monthsLeft;
    }

    // Setter
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Check expiry
    @Override
    public boolean isExpired() {
        return monthsLeft <= 0;
    }

    // Calculate bill
    @Override
    public double calculateBill(int qty) {
        return price * qty;
    }

    // Method overloading
    public double calculateBill(int qty, double discount) {
        double amount = price * qty;
        return amount - (amount * discount / 100);
    }

    // Display medicine
    public void displayMedicine() {
        System.out.println("--------------------------------");
        System.out.println("Medicine ID   : " + medicineId);
        System.out.println("Medicine Name : " + medicineName);
        System.out.println("Price         : Rs." + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Months Left   : " + monthsLeft);
        System.out.println("--------------------------------");
    }
}
