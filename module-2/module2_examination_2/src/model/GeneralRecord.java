package model;

import java.time.LocalDate;

public class GeneralRecord extends MedicalRecord {
    private int fee;

    public GeneralRecord() {
    }

    public GeneralRecord(int fee) {
        this.fee = fee;
    }

    public GeneralRecord(int serial, String medicalCode, String patientCode, String name, LocalDate inDate, LocalDate outDate, String reason, int fee) {
        super(serial, medicalCode, patientCode, name, inDate, outDate, reason);
        this.fee = fee;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", getSerial(), getMedicalCode(), getPatientCode(), getName(), getDateStr(getInDate()), getDateStr(getOutDate()), getReason(), getFee());
    }

    @Override
    public String toString() {
        return super.toString() +
                ", GeneralAccount{" +
                "fee=" + fee +
                '}';
    }
}
