package services.booking;

import models.booking.Booking;
import models.facility.Facility;
import models.person.Customer;
import services.Service;

import java.time.LocalDate;
import java.util.Queue;

public interface BookingService extends Service<Booking> {
    String getBookingCode();
    Customer getCustomer();
    Facility getFacility();
    LocalDate getDate(String dateType);
    Queue<Booking> findAllVillaHouse();
}
