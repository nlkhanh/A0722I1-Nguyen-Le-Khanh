package services.facility;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static final Map<Facility, Integer> FACILITIES;

    static {
        FACILITIES = new LinkedHashMap<>();
    }

    public FacilityServiceImpl() {
    }

    @Override
    public void displayAll() {
        for (Facility facility : FACILITIES.keySet()) {
            System.out.println(facility + ", number of use: " + FACILITIES.get(facility));
        }
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
                    Facility villaTemp = addNew(1);
                    FACILITIES.put(villaTemp, 0);
                    break;
                case 2:
                    Facility houseTemp = addNew(2);
                    FACILITIES.put(houseTemp, 0);
                    break;
                case 3:
                    Facility roomTemp = addNew(3);
                    FACILITIES.put(roomTemp, 0);
                    break;
                case 4:
                    break;
            }
        } while (choice != 4);
    }

    @Override
    public void displayMaintenance() {
        for (Facility facility : FACILITIES.keySet()) {
            if (FACILITIES.get(facility) == 5) {
                System.out.println(facility + ", number of use: " + FACILITIES.get(facility));
            }
        }
    }

    @Override
    public void increaseNumberOfUse(Facility facility) {
        if (FACILITIES.get(facility) == 5) {
            FACILITIES.put(facility, 1);
        } else {
            FACILITIES.put(facility, FACILITIES.get(facility) + 1);
        }
    }

    @Override //No implement
    public void set() {
    }

    private Facility addNew(int serviceTypeNum) {
        int numOfFloor;
        double poolArea;
        String servicesType, roomType, freeServices;

        String code = getCode(serviceTypeNum);
        String name = getName();
        double serviceArea = getArea();
        double cost = getCost();
        int maxNumOfPeople = getMaxNumOfPeople();
        String rentType = getRentType();

        switch (serviceTypeNum) {
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

    private String getCode(int serviceType) {
        Scanner input = new Scanner(System.in);
        String code = null;
        int choice;
        do {
            System.out.println("Do you want to get random code or write code by yourself?");
            System.out.println("1: Random code");
            System.out.println("2: Write code");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(input.nextLine());
            if (choice == 1) {
                code = getRandomCode(serviceType);
            } else if (choice == 2) {
                code = writeCode(serviceType);
            } else {
                System.out.println("Invalid input!");
            }
        } while (choice != 1 && choice != 2);
        return code;
    }

    private String getRandomCode(int serviceType) {
        int randomNum = (int) (Math.random() * (9999 - 1000 + 1) + 1000);
        if (serviceType == 1) {
            return "SVVL-" + randomNum;
        } else if (serviceType == 2) {
            return "SVHO-" + randomNum;
        } else {
            return "SVRO-" + randomNum;
        }
    }

    private String writeCode(int serviceType) {
        String serviceAbbreviation, code;
        Scanner input = new Scanner(System.in);
        boolean isRightCode;
        if (serviceType == 1) {
            serviceAbbreviation = "VL";
        } else if (serviceType == 2) {
            serviceAbbreviation = "HO";
        } else {
            serviceAbbreviation = "RO";
        }
        do {
            System.out.println("Enter your code: ");
            code = input.nextLine();
            isRightCode = code.matches("SV" + serviceAbbreviation + "-\\d{4}");
            if (!isRightCode) {
                System.out.println("Invalid code!");
            }
        } while (!isRightCode);
        return code;
    }

    private String getName() {
        Scanner input = new Scanner(System.in);
        String name;
        boolean isRightName = false;
        do {
            System.out.println("Enter service's name: ");
            name = input.nextLine();
            isRightName = name.matches("[A-Z][a-z]+");
            if (!isRightName) {
                System.out.println("Invalid name!");
            }
        } while (!isRightName);
        return name;
    }

    private double getArea() {
        Scanner input = new Scanner(System.in);
        boolean isAreaRight = false;
        double area = 0;
        do {
            System.out.println("Enter area: ");
            try {
                area = Double.parseDouble(input.nextLine());
                isAreaRight = area > 30;
                if (!isAreaRight) {
                    System.out.println("Area must be more than 30!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (!isAreaRight);
        return area;
    }

    private double getCost() {
        Scanner input = new Scanner(System.in);
        boolean isCostRight = false;
        double cost = 0;
        do {
            System.out.println("Enter cost: ");
            try {
                cost = Double.parseDouble(input.nextLine());
                isCostRight = cost > 0;
                if (!isCostRight) {
                    System.out.println("Cost must be more than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (!isCostRight);
        return cost;
    }

    private int getMaxNumOfPeople() {
        Scanner input = new Scanner(System.in);
        boolean isNumRight = false;
        int num = 0;
        do {
            System.out.println("Enter maximum number of people: ");
            try {
                num = Integer.parseInt(input.nextLine());
                isNumRight = num > 0 && num < 20;
                if (!isNumRight) {
                    System.out.println("Maximum number of people must be between 1 and 19!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (!isNumRight);
        return num;
    }

    private int getNumOfFloor() {
        Scanner input = new Scanner(System.in);
        boolean isNumRight = false;
        int num = 0;
        do {
            System.out.println("Enter number of floor: ");
            try {
                num = Integer.parseInt(input.nextLine());
                isNumRight = num > 0;
                if (!isNumRight) {
                    System.out.println("Number of floor must be more than 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        } while (!isNumRight);
        return num;
    }

    private String getRentType() {
        Scanner input = new Scanner(System.in);
        String rentType;
        boolean isRightRentType;
        do {
            System.out.println("Enter service's rentType: ");
            rentType = input.nextLine();
            isRightRentType = rentType.matches("[A-Z][a-z]+");
            if (!isRightRentType) {
                System.out.println("Invalid rentType!");
            }
        } while (!isRightRentType);
        return rentType;
    }

    private String getRoomType() {
        Scanner input = new Scanner(System.in);
        String roomType;
        boolean isRightRoomType;
        do {
            System.out.println("Enter service's roomType: ");
            roomType = input.nextLine();
            isRightRoomType = roomType.matches("[A-Z][a-z]+");
            if (!isRightRoomType) {
                System.out.println("Invalid roomType!");
            }
        } while (!isRightRoomType);
        return roomType;
    }
}
