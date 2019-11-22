package controller;

import DAO.DAOflight;
import console.Console;
import console.SystemConsole;
import service.FlightBoardService;

public class FlightController {
    FlightBoardService fbs = new FlightBoardService();
    DAOflight daOflight = new DAOflight();
    Console console = new SystemConsole();

    public void showTable() {

        fbs.show();
    }

    public void findFlight() {
        console.printLn("Type the flight ID, that you want to see");
        int id = console.readId();
        if (id >= daOflight.getAll().size()) {
            console.printLn("Please check the flight id from FlightBoard(1)");

        } else fbs.findFlightId(id);
    }

}