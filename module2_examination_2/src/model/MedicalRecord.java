package model;

import java.time.LocalDate;

public abstract class MedicalRecord {
    private int serial;
    private String medicalCode;
    private String patientCode;
    private String name;
    private LocalDate inDate;
    private LocalDate outDate;
    private String reason;

    public MedicalRecord() {
    }

    public MedicalRecord(int serial, String medicalCode, String patientCode, String name, LocalDate inDate, LocalDate outDate, String reason) {
        this.serial = serial;
        this.medicalCode = medicalCode;
        this.patientCode = patientCode;
        this.name = name;
        this.inDate = inDate;
        this.outDate = outDate;
        this.reason = reason;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getInDate() {
        return inDate;
    }

    public void setInDate(LocalDate inDate) {
        this.inDate = inDate;
    }

    public LocalDate getOutDate() {
        return outDate;
    }

    public void setOutDate(LocalDate outDate) {
        this.outDate = outDate;
    }

    public String getReason() {
        return reason;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDateStr(LocalDate date) {
        String[] dateArr = String.format("%s", date).split("-");
        return dateArr[2] + "/" + dateArr[1] + "/" + dateArr[0];
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "serial=" + serial +
                ", medicalCode='" + medicalCode + '\'' +
                ", patientCode='" + patientCode + '\'' +
                ", name='" + name + '\'' +
                ", inDate=" + inDate +
                ", outDate=" + outDate +
                ", reason='" + reason + '\'' +
                '}';
    }
}
