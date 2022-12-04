package services.contract;

import models.booking.Booking;
import models.booking.Contract;
import repository.contract.ContractRepository;
import repository.contract.ContractRepositoryImpl;
import services.booking.BookingService;
import services.booking.BookingServiceImpl;

import java.util.Queue;
import java.util.Scanner;

public class ContractServiceImpl implements ContractService {
    private static final ContractRepository CONTRACT_REPOSITORY;

    static {
        CONTRACT_REPOSITORY = new ContractRepositoryImpl();
    }

    public ContractServiceImpl() {
    }


    @Override
    public void displayAll() {
        CONTRACT_REPOSITORY.displayAll();
    }

    @Override
    public void add() {
        BookingService bookingService = new BookingServiceImpl();
        Queue<Booking> villaHouseBookings = bookingService.findAllVillaHouse();
        Booking nearestBooking;
        while ((nearestBooking = villaHouseBookings.poll()) != null) {
            System.out.println("Create contract for: " + nearestBooking);
            String contractNumber = getContractNumber();
            double deposits = getMoney("deposits");
            double totalBill = getMoney("total bill");
            CONTRACT_REPOSITORY.add(new Contract(contractNumber, nearestBooking.getBookingCode(), deposits, totalBill, nearestBooking.getCustomerCode()));
        }
    }

    @Override
    public String getContractNumber() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter contract number: ");
            String contractNumber = input.nextLine();
            Contract contract = find(contractNumber);
            if (contract != null) {
                return contractNumber;
            }
            System.out.println("Your contract number is exist!");
        }
    }

    @Override
    public double getMoney(String moneyType) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter a " + moneyType  + ": ");
                double money = Double.parseDouble(input.nextLine());
                if (money > 0) {
                    return money;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    @Override
    public void set() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose contract number to edit: ");
        displayAll();
        System.out.println("Enter your choice: ");
        String contractNumber = input.nextLine();
        Contract contract = find(contractNumber);
        if (contract != null) {
            System.out.println("Contract before edit: " + contract);
            contract.setContractNumber(getContractNumber());
            contract.setDeposits(getMoney("new deposits"));
            contract.setTotalBill(getMoney("new total bill"));
            System.out.println("Contract after edit: " + contract);
            CONTRACT_REPOSITORY.set(contract);
        } else {
            System.out.println("Contract number is not exist!");
        }
    }

    @Override
    public Contract find(String code) {
        return CONTRACT_REPOSITORY.find(code);
    }
}
