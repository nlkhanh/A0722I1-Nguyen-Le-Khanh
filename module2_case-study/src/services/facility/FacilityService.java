package services.facility;

import models.facility.Facility;
import services.Service;

public interface FacilityService extends Service<Facility> {
    void displayMaintenance();

    void increaseNumberOfUse(Facility facility);
}
