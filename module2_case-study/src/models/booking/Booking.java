package models.booking;

import java.time.LocalDate;

public class Booking {
    private String bookingCode;
    private LocalDate startDate;
    private LocalDate endDate;
    private String customerCode;
    private String serviceName;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate startDate, LocalDate endDate, String customerCode, String serviceName, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getDateStr(LocalDate date) {
        String[] dateStrArr = String.format("%s", date).split("-");
        return dateStrArr[2] + "/" + dateStrArr[1] + "/" + dateStrArr[0];
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Booking booking = (Booking) obj;
        return ((this.getBookingCode().equals(booking.getBookingCode())) ||
                (this.getStartDate().equals(booking.getStartDate()) &&
                        this.getEndDate().equals(booking.getEndDate()) &&
                        this.getServiceName().equals(booking.getServiceName()) &&
                        this.getServiceType().equals(booking.getServiceType())));
    }

    public String getInfo() {
        return String.format("%s, %s, %s, %s, %s, %s", getBookingCode(), getDateStr(getStartDate()), getDateStr(getEndDate()), getCustomerCode(), getServiceName(), getServiceType());
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", customerCode='" + customerCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
