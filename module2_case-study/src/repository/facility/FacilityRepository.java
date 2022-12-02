package repository.facility;

import models.facility.Facility;
import repository.Repository;

import java.util.LinkedHashMap;

public interface FacilityRepository extends Repository {
    void add(Facility facility);

    Facility find(String code);

    void displayMaintenance();

    void increaseNumberOfUse(Facility facility);

    LinkedHashMap<Facility, Integer> readCSV();

    void writeCSV(LinkedHashMap<Facility, Integer> facilities);
}
