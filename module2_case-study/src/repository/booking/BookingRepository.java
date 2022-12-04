package repository.booking;

import models.booking.Booking;
import repository.Repository;

import java.util.Queue;
import java.util.TreeSet;

public interface BookingRepository extends Repository<Booking, TreeSet<Booking>> {
    Queue<Booking> findAllVillaHouse();
}
