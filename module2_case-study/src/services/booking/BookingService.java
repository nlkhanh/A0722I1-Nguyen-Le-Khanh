package services.booking;

import models.booking.Booking;
import models.facility.Facility;
import models.person.Customer;
import services.Service;

import java.time.LocalDate;
import java.util.Queue;
import java.util.Set;

public interface BookingService extends Service<Booking, Set<Booking>> {
    String getBookingCode();
    Customer getCustomer();
    Facility getFacility();
    LocalDate getDate(String dateType);
    Queue<Booking> findAllVillaHouse();
}
