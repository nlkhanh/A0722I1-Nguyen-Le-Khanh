package repository.booking;

import models.booking.Booking;
import utils.BookingComparator;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class BookingRepositoryImpl implements BookingRepository {
    private static final String SOURCE_PATH = "E:\\codegym\\exercises\\A0722I1-Nguyen-Le-Khanh\\module2_case-study\\src\\data\\booking.csv";

    @Override
    public void add(Booking e) {
        Set<Booking> bookings = read();
        bookings.add(e);
        write(bookings);
    }

    @Override
    public void set(Booking e) {
    }

    @Override
    public Booking find(String code) {
        Set<Booking> bookings = read();
        for (Booking booking : bookings) {
            if (booking.getBookingCode().equals(code)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public Queue<Booking> findAllVillaHouse() {
        Set<Booking> bookings = read();
        Queue<Booking> bookingQueue = new LinkedList<>();
        for (Booking booking : bookings) {
            if (booking.getServiceType().equals("Villa") || booking.getServiceType().equals("House")) {
                bookingQueue.offer(booking);
            }
        }
        return bookingQueue;
    }

    @Override
    public void displayAll() {
        Set<Booking> bookings = read();
        if (bookings.size() == 0) {
            System.out.println("There are not booking in repository");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public Set<Booking> read() {
        Set<Booking> bookings = new TreeSet<>(new BookingComparator());
        try {
            FileReader fileReader = new FileReader(SOURCE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tempArr = line.split(",");
                String bookingCode = tempArr[0];
                LocalDate startDate = LocalDate.parse(tempArr[1], formatter);
                LocalDate endDate = LocalDate.parse(tempArr[2], formatter);
                String customerCode = tempArr[3];
                String serviceName = tempArr[4];
                String serviceType = tempArr[5];
                bookings.add(new Booking(bookingCode, startDate, endDate, customerCode, serviceName, serviceType));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot read your data.");
        }
        return bookings;
    }

    @Override
    public void write(Set<Booking> bookings) {
        try {
            FileWriter fileWriter = new FileWriter(SOURCE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookings) {
                bufferedWriter.write(booking.getInfo() + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An exception have occur! Cannot write your data.");
        }
    }
}
