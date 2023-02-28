package repository.facility;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;

import java.io.*;
import java.util.LinkedHashMap;

public class FacilityRepositoryImpl implements FacilityRepository {
    private static final String VILLA_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\villa.csv";
    private static final String HOUSE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\house.csv";
    private static final String ROOM_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\room.csv";

    @Override
    public void add(Facility facility) {
        LinkedHashMap<Facility, Integer> facilities = read();
        facilities.put(facility, 0);
        write(facilities);
    }

    @Override
    public Facility find(String code) {
        LinkedHashMap<Facility, Integer> facilities = read();
        for (Facility facility : facilities.keySet()) {
            if (facility.getCode().equals(code)) {
                return facility;
            }
        }
        return null;
    }

    @Override
    public void displayAll() {
        LinkedHashMap<Facility, Integer> facilities = read();
        for (Facility facility : facilities.keySet()) {
            System.out.println(facility + ", uses: " + facilities.get(facility));
        }
    }

    @Override
    public LinkedHashMap<Facility, Integer> read() {
        LinkedHashMap<Facility, Integer> villas = read(VILLA_PATH);
        LinkedHashMap<Facility, Integer> houses = read(HOUSE_PATH);
        LinkedHashMap<Facility, Integer> rooms = read(ROOM_PATH);
        LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
        for (Facility villa : villas.keySet()) {
            facilities.put(villa, villas.get(villa));
        }
        for (Facility house : houses.keySet()) {
            facilities.put(house, houses.get(house));
        }
        for (Facility room : rooms.keySet()) {
            facilities.put(room, rooms.get(room));
        }
        return facilities;
    }

    @Override
    public LinkedHashMap<Facility, Integer> read(String SOURCE_PATH) {
        LinkedHashMap<Facility, Integer> facilities = new LinkedHashMap<>();
        try {
            FileReader fileReader = new FileReader(SOURCE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArr = line.split(",");
                if (SOURCE_PATH.contains("villa")) {
                    facilities.put(new Villa(tempArr[0], Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]),
                            Integer.parseInt(tempArr[3]), tempArr[4], tempArr[5], tempArr[6], tempArr[7],
                            Integer.parseInt(tempArr[8]), Double.parseDouble(tempArr[9])), Integer.parseInt(tempArr[10]));
                } else if (SOURCE_PATH.contains("house")) {
                    facilities.put(new House(tempArr[0], Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]),
                            Integer.parseInt(tempArr[3]), tempArr[4], tempArr[5], tempArr[6], tempArr[7],
                            Integer.parseInt(tempArr[8])), Integer.parseInt(tempArr[9]));
                } else {
                    facilities.put(new Room(tempArr[0], Double.parseDouble(tempArr[1]), Double.parseDouble(tempArr[2]),
                            Integer.parseInt(tempArr[3]), tempArr[4], tempArr[5], tempArr[6], tempArr[7]), Integer.parseInt(tempArr[8]));
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot read your data.");
        }
        return facilities;
    }

    @Override
    public void write(LinkedHashMap<Facility, Integer> facilities) {
        try {
            FileWriter fileWriter = new FileWriter(VILLA_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Facility facility : facilities.keySet()) {
                if (facility.getServicesType().equals("Villa")) {
                    Villa villa = (Villa) facility;
                    bufferedWriter.write(villa.getInfo() + "\n");
                } else if (facility.getServicesType().equals("House")) {
                    fileWriter = new FileWriter(HOUSE_PATH);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    House house = (House) facility;
                    bufferedWriter.write(house.getInfo() + "\n");
                } else {
                    fileWriter = new FileWriter(ROOM_PATH);
                    bufferedWriter = new BufferedWriter(fileWriter);
                    Room room = (Room) facility;
                    bufferedWriter.write(room.getInfo() + "\n");
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot write your data.");
        }
    }

    @Override
    public void displayMaintenance() {
        LinkedHashMap<Facility, Integer> facilities = read();
        for (Facility facility : facilities.keySet()) {
            if (facilities.get(facility) == 5) {
                System.out.println(facility + ", number of use: " + facilities.get(facility));
            }
        }
    }

    @Override
    public void increaseNumberOfUse(Facility facility) {
        LinkedHashMap<Facility, Integer> facilities = read();
        if (find(facility.getCode()) != null) {
            if (facilities.get(facility) == 5) {
                facilities.put(facility, 1);
            } else {
                facilities.put(facility, facilities.get(facility) + 1);
            }
        } else {
            System.out.println("Your facility is not exist");
        }
    }
}
