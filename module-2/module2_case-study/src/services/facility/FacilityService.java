package services.facility;

import models.facility.Facility;
import services.Service;

import java.util.Map;

public interface FacilityService extends Service<Facility, Map<Facility, Integer>> {
    void displayMaintenance();

    void increaseNumberOfUse(Facility facility);
}
