package services.booking;

import models.booking.Booking;
import models.facility.Facility;
import models.person.Customer;
import repository.booking.BookingRepository;
import repository.booking.BookingRepositoryImpl;
import services.facility.FacilityService;
import services.facility.FacilityServiceImpl;
import services.person.customer.CustomerService;
import services.person.customer.CustomerServiceImpl;
import utils.Validate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class BookingServiceImpl implements BookingService {
    private static final BookingRepository BOOKING_REPOSITORY;

    static {
        BOOKING_REPOSITORY = new BookingRepositoryImpl();
    }

    public BookingServiceImpl() {
    }

    @Override
    public void displayAll() {
        BOOKING_REPOSITORY.displayAll();
    }

    @Override
    public void add() {
        Customer customer = getCustomer();
        if (customer == null) {
            System.out.println("There is not customer in repository to made booking!");
            return;
        }
        Facility facility = getFacility();
        if (facility == null) {
            System.out.println("There is not facility in repository to made booking!");
            return;
        }
        String bookingCode = getBookingCode();
        LocalDate startDate = getDate("start");
        LocalDate endDate = getDate("end");
        BOOKING_REPOSITORY.add(new Booking(bookingCode, startDate, endDate, customer.getPersonCode(), facility.getName(), facility.getServicesType()));
        FacilityService facilityService = new FacilityServiceImpl();
        facilityService.increaseNumberOfUse(facility);
    }

    @Override
    public String getBookingCode() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter booking code: ");
            String bookingCode = input.nextLine();
            Booking booking = find(bookingCode);
            if (booking != null) {
                return bookingCode;
            }
            System.out.println("Your booking code is exist!");
        }
    }

    @Override
    public Customer getCustomer() {
        Scanner input = new Scanner(System.in);
        Customer customer;
        while (true) {
            System.out.println("Choose a customer: ");
            CustomerService customerService = new CustomerServiceImpl();
            if (customerService.findAll().size() == 0) {
                customerService.displayAll();
                return null;
            }
            customerService.displayAll();
            System.out.println("Enter your customer code: ");
            String customerCode = input.nextLine();
            customer = customerService.find(customerCode);
            if (customer != null) {
                return customer;
            }
            System.out.println("Customer is not exist!");
        }
    }

    @Override
    public Facility getFacility() {
        Scanner input = new Scanner(System.in);
        Facility facility;
        while (true) {
            System.out.println("Choose a service: ");
            FacilityService facilityService = new FacilityServiceImpl();
            if ((facilityService.findAll().size() == 0)) {
                facilityService.displayAll();
                return null;
            }
            System.out.println("Enter your service code: ");
            String facilityCode = input.nextLine();
            facility = facilityService.find(facilityCode);
            if (facilityCode != null) {
                return facility;
            }
            System.out.println("Service is not exist!");
        }
    }

    @Override
    public LocalDate getDate(String dateType) {
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateStr;
        while (true) {
            System.out.println("Enter " + dateType + " date: ");
            dateStr = input.nextLine();
            if (Validate.isRightDateFormat(dateStr)) {
                break;
            }
            System.out.println("Your date input is wrong format!");
        }
        return LocalDate.parse(dateStr, formatter);
    }

    @Override
    public Queue<Booking> findAllVillaHouse() {
        return BOOKING_REPOSITORY.findAllVillaHouse();
    }

    @Override
    public Booking find(String code) {
        return BOOKING_REPOSITORY.find(code);
    }

    @Override
    public Set<Booking> findAll() {
        return BOOKING_REPOSITORY.read();
    }

    @Override
    public void set() {
        BOOKING_REPOSITORY.set(null);
    }
}
