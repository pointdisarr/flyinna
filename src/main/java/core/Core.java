package core;

import console.Console;
import controller.BookingController;
import controller.FlightController;
import controller.MainController;
import io.Command;
import io.Parser;
import menu.Menu;

import java.io.IOException;

public class Core {
    private final Console console;
    private final Database database;
    private final Menu menu;
    private final Parser parser;
    private final FlightController flightController;
    private final BookingController bookingController;
    private final MainController mainController;

    public Core(Console console, Database database) throws IOException {
        this.console = console;
        this.database = database;
        this.menu = new Menu();
        this.parser = new Parser();
        this.flightController = new FlightController();
        this.bookingController = new BookingController();
        this.mainController = new MainController();
    }

    public void run() throws IOException {
        if (!database.isExisted()) {
            database.createInitialData();
        }

        boolean cont = true;
        console.printLn(menu.show());
        while (cont) {

            String line = console.readLn();
            Command user_input = parser.parse(line);

            switch (user_input) {
                case TIMETABLE_SHOW:
                    flightController.showTable();
                    break;

                case FIND_FLIGHT:
                    flightController.findFlight();
                    break;

                case BOOKING_SEARCH_ADD:
                    bookingController.searchBooking();
                    break;

                case MY_BOOKINGS:
                    bookingController.showBookings();



                case EXIT:
                    cont = false;

                default:
                    console.printLn(mainController.help());
            }
        }


    }
}
