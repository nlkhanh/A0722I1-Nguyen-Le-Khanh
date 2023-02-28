package services.facility;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import repository.facility.FacilityRepositoryImpl;
import utils.Validate;

import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static final FacilityRepositoryImpl FACILITY_REPOSITORY;

    static {
        FACILITY_REPOSITORY = new FacilityRepositoryImpl();
    }

    public FacilityServiceImpl() {
    }

    @Override
    public void displayAll() {
        FACILITY_REPOSITORY.displayAll();
    }

    @Override
    public void add() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Choose your service: ");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to menu");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    FACILITY_REPOSITORY.add(addNew(1));
                    break;
                case 2:
                    FACILITY_REPOSITORY.add(addNew(2));
                    break;
                case 3:
                    FACILITY_REPOSITORY.add(addNew(3));
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }

    @Override
    public void displayMaintenance() {
        FACILITY_REPOSITORY.displayMaintenance();
    }

    @Override
    public void increaseNumberOfUse(Facility facility) {
        FACILITY_REPOSITORY.increaseNumberOfUse(facility);
    }

    @Override //No implement
    public void set() {
    }

    @Override
    public Facility find(String code) {
        return FACILITY_REPOSITORY.find(code);
    }

    @Override
    public Map<Facility, Integer> findAll() {
        return FACILITY_REPOSITORY.read();
    }

    private Facility addNew(int serviceTypeCode) {
        String code = getCode(serviceTypeCode);
        String name = getName();
        double serviceArea = getArea();
        double cost = getCost();
        int maxNumOfPeople = getMaxNumOfPeople();
        String rentType = getRentType();
        int numOfFloor;
        double poolArea;
        String servicesType, roomType, freeServices;
        switch (serviceTypeCode) {
            case 1:
                servicesType = "Villa";
                roomType = getRoomType();
                numOfFloor = getNumOfFloor();
                poolArea = getArea();
                return new Villa(name, serviceArea, cost, maxNumOfPeople, rentType, servicesType, code, roomType, numOfFloor, poolArea);
            case 2:
                servicesType = "House";
                roomType = getRoomType();
                numOfFloor = getNumOfFloor();
                return new House(name, serviceArea, cost, maxNumOfPeople, rentType, servicesType, code, roomType, numOfFloor);
            case 3:
                Scanner input = new Scanner(System.in);
                servicesType = "Room";
                System.out.println("Enter free service: ");
                freeServices = input.nextLine();
                return new Room(name, serviceArea, cost, maxNumOfPeople, rentType, servicesType, code, freeServices);
        }
        return null;
    }

    private String getCode(int serviceTypeCode) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your code: ");
            String code = input.nextLine();
            if (Validate.isRightServiceCode(code, serviceTypeCode)) {
                return code;
            }
            System.out.println("Code is not valid!");
        }
    }

    private String getName() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter service's name: ");
            String name = input.nextLine();
            if (Validate.isRightNameOrType(name)) {
                return name;
            }
            System.out.println("Invalid name!");
        }
    }

    private double getArea() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter area: ");
            try {
                double area = Double.parseDouble(input.nextLine());
                if (Validate.isRightArea(area)) {
                    return area;
                }
                System.out.println("Area must be more than 30!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private double getCost() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter cost: ");
            try {
                double cost = Double.parseDouble(input.nextLine());
                if (Validate.isRightCost(cost)) {
                    return cost;
                }
                System.out.println("Cost must be more than 0!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private int getMaxNumOfPeople() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter maximum number of people: ");
            try {
                int numberOfPeople = Integer.parseInt(input.nextLine());
                if (Validate.isRightNumberOfPeople(numberOfPeople)) {
                    return numberOfPeople;
                }
                System.out.println("Maximum number of people must be between 1 and 19!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private int getNumOfFloor() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter number of floor: ");
            try {
                int numberOfFloor = Integer.parseInt(input.nextLine());
                if (Validate.isRightNumberOfFloor(numberOfFloor)) {
                    return numberOfFloor;
                }
                System.out.println("Number of floor must be more than 0!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    private String getRentType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter service's rentType: ");
            String rentType = input.nextLine();
            if (Validate.isRightNameOrType(rentType)) {
                return rentType;
            }
            System.out.println("Invalid type of rent!");
        }
    }

    private String getRoomType() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter service's roomType: ");
            String roomType = input.nextLine();
            if (Validate.isRightNameOrType(roomType)) {
                return roomType;
            }
            System.out.println("Invalid roomType!");
        }
    }
}
