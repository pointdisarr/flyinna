package controller;

import DAO.DAOpassengers;
import console.Console;
import console.SystemConsole;
import entity.Booking;
import service.BookingService;

public class BookingController {
    Console console = new SystemConsole();
    BookingService bs = new BookingService();
    Booking booking = new Booking();
    DAOpassengers daOpassengers = new DAOpassengers();

    public void searchBooking() {
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
            bs.addBooking(menuid, tickets);
        }
    }

    public void showBookings() {
        bs.showBookings();
    }
}
