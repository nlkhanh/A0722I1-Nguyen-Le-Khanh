package models.booking;

public class Contract {
    private String contractNumber;
    private String bookingCode;
    private double deposits;
    private double totalBill;
    private String customerCode;

    private Contract() {
    }

    public Contract(String contractNumber, String bookingCode, double deposits, double totalBill, String customerCode) {
        this.contractNumber = contractNumber;
        this.bookingCode = bookingCode;
        this.deposits = deposits;
        this.totalBill = totalBill;
        this.customerCode = customerCode;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    private void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposits() {
        return deposits;
    }

    public void setDeposits(double deposits) {
        this.deposits = deposits;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    private void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getInfo() {
        return String.format("%s, %s, %s, %s, %s", getContractNumber(), getBookingCode(), getDeposits(), getTotalBill(), getCustomerCode());
    }

    @Override
    public String toString() {
        return "contract{" +
                "contractNum=" + contractNumber +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposits=" + deposits +
                ", total bill=" + totalBill +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
