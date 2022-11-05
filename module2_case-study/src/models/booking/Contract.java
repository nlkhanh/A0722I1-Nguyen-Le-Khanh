package models.booking;

public class Contract {
    private int contractNum;
    private String bookingCode;
    private double deposits;
    private double payments;
    private String customerCode;

    private Contract() {
    }

    public Contract(int contractNum, String bookingCode, double deposits, double payments, String customerCode) {
        this.contractNum = contractNum;
        this.bookingCode = bookingCode;
        this.deposits = deposits;
        this.payments = payments;
        this.customerCode = customerCode;
    }

    public int getContractNum() {
        return contractNum;
    }

    public void setContractNum(int contractNum) {
        this.contractNum = contractNum;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposits() {
        return deposits;
    }

    public void setDeposits(double deposits) {
        this.deposits = deposits;
    }

    public double getPayments() {
        return payments;
    }

    public void setPayments(double payments) {
        this.payments = payments;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "contract{" +
                "contractNum=" + contractNum +
                ", bookingCode='" + bookingCode + '\'' +
                ", deposits=" + deposits +
                ", payments=" + payments +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
