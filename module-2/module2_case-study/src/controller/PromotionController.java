package controller;

import services.promotion.PromotionService;
import services.promotion.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {

    public PromotionController() {
    }

    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        PromotionService promotionService = new PromotionServiceImpl();
        while (true) {
            try {
                System.out.println("---- Promotion Management ----");
                System.out.println("1. Display list customers use services");
                System.out.println("2. Display list customers get voucher");
                System.out.println("3. Return main menu");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        promotionService.displayCustomersUseService();
                        break;
                    case 2:
                        promotionService.displayCustomersGetVoucher();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Your choice must be from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
