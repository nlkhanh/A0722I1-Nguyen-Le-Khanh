package controller;

import service.BankAccountServiceImpl;
import service.BankAccountServicie;

import java.util.Scanner;

public class BankController {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void displayMainMenu() {
        BankAccountServicie bankAccountServicie = new BankAccountServiceImpl();
        while (true) {
            try {
                System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG--");
                System.out.println("Chọn chức năng theo số (để tiếp tục): ");
                System.out.println("1. Thêm mới");
                System.out.println("2. Xóa");
                System.out.println("3. Xem danh sách các tài khoản ngân hàng");
                System.out.println("4. Tìm kiếm");
                System.out.println("5. Thoát");
                System.out.println("Chọn chức năng: ");
                int choice = Integer.parseInt(SCANNER.nextLine());
                switch (choice) {
                    case 1:
                        bankAccountServicie.add();
                        break;
                    case 2:
                        bankAccountServicie.remove();
                        break;
                    case 3:
                        bankAccountServicie.displayAll();
                        break;
                    case 4:
                        bankAccountServicie.search();
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Bạn phải chọn  từ 1 đến 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }

    }
}
