package model;

import java.time.LocalDate;

public class SaveAccount extends BankAccount {
    private int saveMoney;
    private LocalDate sendDate;
    private double interest;
    private int duration;

    public SaveAccount() {
    }

    public SaveAccount(int saveMoney, LocalDate sendDate, double interest, int duration) {
        this.saveMoney = saveMoney;
        this.sendDate = sendDate;
        this.interest = interest;
        this.duration = duration;
    }

    public SaveAccount(int accountId, String accountCode, String accountName, LocalDate creatDate, int saveMoney, LocalDate sendDate, double interest, int duration) {
        super(accountId, accountCode, accountName, creatDate);
        this.saveMoney = saveMoney;
        this.sendDate = sendDate;
        this.interest = interest;
        this.duration = duration;
    }

    public int getSaveMoney() {
        return saveMoney;
    }

    public void setSaveMoney(int saveMoney) {
        this.saveMoney = saveMoney;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", super.getAccountId(), super.getAccountCode(),
                super.getAccountName(), super.getDateStr(super.getCreatDate()), getSaveMoney(), super.getDateStr(getSendDate()),
                getInterest(), getDuration());
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" +
                "account id=" + super.getAccountId() +
                ", account code=" + super.getAccountCode() +
                ", account name=" + super.getAccountName() +
                ", create date =" + super.getCreatDate() +
                ", save money=" + saveMoney +
                ", sendDate=" + sendDate +
                ", interest=" + interest +
                ", duration=" + duration +
                '}';
    }
}
