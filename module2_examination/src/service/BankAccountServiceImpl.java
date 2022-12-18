package service;

import model.BankAccount;
import model.PayingAccount;
import model.SaveAccount;
import sun.security.ec.point.AffinePoint;
import util.ReadAndWriteCSV;
import util.Validate;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountServiceImpl implements BankAccountServicie {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        int accountId = getId();
        String accountCode = getCode();
        String accountName = getName();
        LocalDate createDate = getDate(0);
        while (true) {
            try {
                System.out.println("Chọn loại tài khoản: ");
                System.out.println("1. Tài khoản tiết kiệm");
                System.out.println("2. Tài khoản thanh toán");
                System.out.println("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                if (choice == 1) {
                    int saveMoney = getMoney(0);
                    LocalDate sendDate = getDate(1);
                    double interest = getInterest();
                    int duration = getDuration();
                    List<BankAccount> bankAccounts = ReadAndWriteCSV.read();
                    bankAccounts.add(new SaveAccount(accountId, accountCode, accountName, createDate, saveMoney, sendDate, interest, duration));
                    ReadAndWriteCSV.write(bankAccounts);
                    return;
                } else if (choice == 2) {
                    String cardNumber = getCardNumber();
                    int accountMoney = getMoney(1);
                    List<BankAccount> bankAccounts = ReadAndWriteCSV.read();
                    bankAccounts.add(new PayingAccount(accountId, accountCode, accountName, createDate, cardNumber, accountMoney));
                    ReadAndWriteCSV.write(bankAccounts);
                    return;
                } else {
                    System.out.println("Bạn phải nhập 1 hoặc 2!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập 1 hoặc 2!");
            } catch (FileNotFoundException e) {
                System.out.println("Không tìm được file!");
            } catch (IOException e) {
                System.out.println("Có lỗi IO xảy ra!");
            }

        }

    }

    @Override
    public boolean remove() {
        System.out.println("Nhập mã tài khoản muốn xóa");
        String accountCode = SCANNER.nextLine();
        List<BankAccount> bankAccounts = new ArrayList<>();
        try {
            bankAccounts = ReadAndWriteCSV.read();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm được file!");

        } catch (IOException e) {
            System.out.println("Có lỗi IO xảy ra!");
        }
        boolean check = false;
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountCode().equals(accountCode)) {
                System.out.println("Bạn có muốn xóa tài khoản: " + bankAccount);
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("Nhập lựa chọn: ");
                try {
                    int choice = Integer.parseInt(SCANNER.nextLine());
                    if (choice == 1) {
                        bankAccounts.remove(bankAccount);
                        ReadAndWriteCSV.write(bankAccounts);
                        check = true;
                    } else if (choice == 2) {
                        check = false;
                    } else {
                        System.out.println("Phải nhập 1 hoặc 2");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Phải nhập 1 hoặc 2");
                } catch (FileNotFoundException e) {
                    System.out.println("Không tìm được file!");
                } catch (IOException e) {
                    System.out.println("Có lỗi IO xảy ra!");
                }
            }
        }
        if (check) {
            System.out.println("Danh sách tài khoản sau khi xóa: ");
            for (BankAccount bankAccount : bankAccounts) {
                System.out.println(bankAccount);
            }
            return check;
        }
        return false;
    }

    @Override
    public void displayAll() {
        try {
            List<BankAccount> bankAccounts = ReadAndWriteCSV.read();
            if (bankAccounts.size() == 0) {
                System.out.println("Không có tài khoản nào cả!");
                return;
            }
            for (BankAccount bankAccount : bankAccounts) {
                System.out.println(bankAccount);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm được file!");

        } catch (IOException e) {
            System.out.println("Có lỗi IO xảy ra!");
        }
    }

    @Override
    public void search() {

    }

    private int getId() {
        try {
            List<BankAccount> bankAccounts = ReadAndWriteCSV.read();
            if (bankAccounts.size() == 0) {
                return 1;
            }
            return bankAccounts.size() + 1;
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm được file!");

        } catch (IOException e) {
            System.out.println("Có lỗi IO xảy ra!");
        }
        return -1;
    }

    private String getCode() {
        while (true) {
            System.out.println("Nhập mã tài khoản: ");
            String code = SCANNER.nextLine();
            if (Validate.isCardNumberRight(code)) {
                return code;
            }
            System.out.println("Mã phải là 9 chữ số");
        }
    }

    private String getName() {
        System.out.println("Nhập tên chủ tài khoản: ");
        return SCANNER.nextLine();
    }

    private LocalDate getDate(int type) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String typeStr = "tạo tài khoản";
        if (type == 1) {
            typeStr = "gửi tiết kiệm";
        }
        while (true) {
            System.out.println("Nhập ngày " + typeStr + ": ");
            String dateStr = SCANNER.nextLine();
            if (Validate.isDateFormatRight(dateStr)) {
                return LocalDate.parse(dateStr, formatter);
            }
            System.out.println("Ngày tháng không đúng định dạng dd/mm/yyyy hoặc ngày sai.");
        }
    }

    private int getMoney(int type) {
        String typeStr = "tiết kiệm";
        if (type == 1) {
            typeStr = "trong tài khoản";
        }
        while (true) {
            try {
                System.out.println("Nhập số tiền " + typeStr + ": ");
                int saveMoney = Integer.parseInt(SCANNER.nextLine());
                if (saveMoney > 0) {
                    return saveMoney;
                }
                System.out.println("Bạn phải nhập số nguyên lớn hơn không");
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập số nguyên lớn hơn không");
            }

        }
    }

    private double getInterest() {
        while (true) {
            try {
                System.out.println("Nhập số lãi suất: ");
                double interest = Double.parseDouble(SCANNER.nextLine());
                if (interest > 0) {
                    return interest;
                }
                System.out.println("Bạn phải nhập số lớn hơn không");
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập số lớn hơn không");
            }
        }
    }

    private int getDuration() {
        while (true) {
            try {
                System.out.println("Nhập kỳ hạn tiết kiệm: ");
                int duration = Integer.parseInt(SCANNER.nextLine());
                if (duration > 0) {
                    return duration;
                }
                System.out.println("Bạn phải nhập số nguyên lớn hơn không");
            } catch (NumberFormatException e) {
                System.out.println("Bạn phải nhập số nguyên lớn hơn không");
            }
        }
    }

    private String getCardNumber() {
        while (true) {
            System.out.println("Nhập số thẻ: ");
            String cardNumber = SCANNER.nextLine();
            if (Validate.isCardNumberRight(cardNumber)) {
                return cardNumber;
            }
            System.out.println("Số thẻ phải là các chữ số dạng số");
        }
    }
}
