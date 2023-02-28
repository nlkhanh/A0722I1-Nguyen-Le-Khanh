package repository.booking;

import models.booking.Booking;
import repository.Repository;

import java.util.Queue;
import java.util.Set;

public interface BookingRepository extends Repository<Booking, Set<Booking>> {
    Queue<Booking> findAllVillaHouse();
}
