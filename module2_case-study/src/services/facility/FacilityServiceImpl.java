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

    private Facility addNew(int serviceType) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter service name: ");
        String name = input.nextLine();
        System.out.println("Enter service area: ");
        double area = Double.parseDouble(input.nextLine());
        System.out.println("Enter service cost: ");
        double cost = Double.parseDouble(input.nextLine());
        System.out.println("Enter maximum number of people: ");
        int maxNumOfPeople = Integer.parseInt(input.nextLine());
        System.out.println("Enter rent's type: ");
        String rentType = input.nextLine();
        String servicesType;
        String roomType;
        byte numberOfFloor;
        double poolArea;
        String freeServices;
        switch (serviceType) {
            case 1:
                servicesType = "Villa";
                System.out.println("Enter room's type: ");
                roomType = input.nextLine();
                System.out.println("Enter number of floor: ");
                numberOfFloor = Byte.parseByte(input.nextLine());
                System.out.println("Enter area of pool: ");
                poolArea = Double.parseDouble(input.nextLine());
                return new Villa(name, area, cost, maxNumOfPeople, rentType, servicesType, roomType, numberOfFloor, poolArea);
            case 2:
                servicesType = "House";
                System.out.println("Enter room's type: ");
                roomType = input.nextLine();
                System.out.println("Enter number of floor: ");
                numberOfFloor = Byte.parseByte(input.nextLine());
                return new House(name, area, cost, maxNumOfPeople, rentType, servicesType, roomType, numberOfFloor);
            case 3:
                servicesType = "Room";
                System.out.println("Enter free service: ");
                freeServices = input.nextLine();
                return new Room(name, area, cost, maxNumOfPeople, rentType, servicesType, freeServices);
        }
        return null;
    }
}
