package utils;

import models.booking.Booking;

import java.time.Period;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        int compareStartDate = Period.between(o1.getStartDate(), o2.getStartDate()).getDays();
        int compareEndDate = Period.between(o1.getEndDate(), o2.getEndDate()).getDays();
        if (compareStartDate < 0) {
            return 1;
        } else if (compareStartDate > 0) {
            return -1;
        }
        if (compareEndDate < 0) {
            return 1;
        } else if (compareEndDate > 0) {
            return -1;
        }
        return 0;
    }
}
