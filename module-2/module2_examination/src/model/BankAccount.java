package model;

import java.time.LocalDate;

public abstract class BankAccount {
    private int accountId;
    private String accountCode;
    private String accountName;
    private LocalDate creatDate;

    public BankAccount() {
    }

    public BankAccount(int accountId, String accountCode, String accountName, LocalDate creatDate) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.creatDate = creatDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDate creatDate) {
        this.creatDate = creatDate;
    }

    public String getDateStr(LocalDate date) {
        String[] dateStrArr = String.format("%s", date).split("-");
        return dateStrArr[2] + "/" + dateStrArr[1] + "/" + dateStrArr[0];
    }

    public abstract String getInfo();
}
