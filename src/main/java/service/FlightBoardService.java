package service;


import DAO.DAOflight;
import console.Console;
import console.SystemConsole;
import entity.Flight;


public class FlightBoardService {
    DAOflight daOflight = new DAOflight();
    Console console = new SystemConsole();

    public void show(){

        daOflight.getAll().forEach(o -> console.printLn(o.toString()));
        console.printLn("Press ENTER to get back to the menu");

    }

    public void findFlightId(int id) {
        for (int i = 0; i < daOflight.getAll().size(); i++) {
            Flight flight = (Flight) daOflight.get(i);
            if (flight.getId() == id) {
                console.printLn("Here's your flight");
                console.printLn(String.valueOf(flight));
            }
        }
    }
}
