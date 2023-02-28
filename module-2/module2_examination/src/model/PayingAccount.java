package model;

import java.time.LocalDate;

public class PayingAccount extends BankAccount {
    private String cardNumber;
    private int accountMoney;

    public PayingAccount() {
    }

    public PayingAccount(String cardNumber, int accountMoney) {
        this.cardNumber = cardNumber;
        this.accountMoney = accountMoney;
    }

    public PayingAccount(int accountId, String accountCode, String accountName, LocalDate creatDate, String cardNumber, int accountMoney) {
        super(accountId, accountCode, accountName, creatDate);
        this.cardNumber = cardNumber;
        this.accountMoney = accountMoney;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(int accountMoney) {
        this.accountMoney = accountMoney;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s", super.getAccountId(), super.getAccountCode(),
                super.getAccountName(), super.getDateStr(super.getCreatDate()), getCardNumber(), getAccountMoney());
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" +
                "account id=" + super.getAccountId() +
                ", account code=" + super.getAccountCode() +
                ", account name=" + super.getAccountName() +
                ", create date =" + super.getCreatDate() +
                ", cardNumber='" + cardNumber + '\'' +
                ", accountMoney=" + accountMoney +
                '}';
    }
}
