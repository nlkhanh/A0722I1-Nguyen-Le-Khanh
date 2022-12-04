package repository.facility;

import models.facility.Facility;

import java.util.LinkedHashMap;

public interface FacilityRepository {
    void add(Facility e);

    Facility find(String code);

    void displayAll();

    LinkedHashMap<Facility, Integer> read();

    LinkedHashMap<Facility, Integer> read(String path);

    void write(LinkedHashMap<Facility, Integer> facilities);

    void displayMaintenance();

    void increaseNumberOfUse(Facility facility);
}
