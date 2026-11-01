public class PrescriptionMedicine extends Medicine {

    private String prescriptionNumber;

    public PrescriptionMedicine(int medicineId, String medicineName,
                                double price, int quantity,
                                int monthsLeft, String prescriptionNumber) {
        super(medicineId, medicineName, price, quantity, monthsLeft);
        this.prescriptionNumber = prescriptionNumber;
    }

    public String getPrescriptionNumber() {
        return prescriptionNumber;
    }

    // Method overriding
    @Override
    public double calculateBill(int qty) {
        return super.calculateBill(qty);
    }
}
