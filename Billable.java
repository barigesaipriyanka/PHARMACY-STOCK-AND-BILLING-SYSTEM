public interface Billable {
    double calculateBill(int qty);
    boolean isExpired();
}
