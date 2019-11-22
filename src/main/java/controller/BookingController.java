package controller;

import DAO.DAOpassengers;
import console.Console;
import console.SystemConsole;
import entity.Booking;
import service.BookingService;

public class BookingController {
    Console console;
    BookingService bs = new BookingService();
    Booking booking = new Booking();
    DAOpassengers daOpassengers = new DAOpassengers();

    public BookingController(Console c) {
        this.console = c;
    }

    public void searchBooking() {
        console.printLn("What is your name? (please provide the name to be able to access your bookings)");
        String userName = console.readLn();
        console.printLn("----Book a flight from next day----");
        console.printLn("from where: ");
        String srcCity = console.readLn();
        console.printLn("to where: ");
        String destCity = console.readLn();
        console.printLn("how many tickets? ");
        int tickets = console.readId();
        bs.searchBooking(srcCity, destCity);
        if (bs.isFound()) {
            console.printLn("----Type the id before '=' sign to book----");
            int menuid = console.readId();
            bs.addBooking(menuid, tickets, userName);
        }
    }

    public void showBookings() {
        bs.showBookings();
    }
}
