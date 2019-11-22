package service;


import DAO.DAObooking;
import DAO.DAOflight;
import DAO.DAOpassengers;
import console.Console;
import console.SystemConsole;
import controller.MainController;
import entity.Booking;
import entity.Flight;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookingService {
    public static int emptySeats = 30;
    String wPath = "src/main/booking.txt";
    String rPath = "src/main/mybookings.txt";
    Console console = new SystemConsole();
    DAOflight daOflight = new DAOflight();
    Map<Integer, String> myBookings = new HashMap<>();
    Map<Integer, Flight> mapFound = new HashMap<>();
    Booking booking = new Booking();
    DAOpassengers daOpassengers = new DAOpassengers();
    MainController mainController = new MainController();
    private boolean found = false;

    public Map<Integer, Flight> getMapFound() {
        return mapFound;
    }

    public void setMapFound(Map<Integer, Flight> mapFound) {
        this.mapFound = mapFound;
    }

    public boolean isFound() {
        return found;
    }

    public void searchBooking(String src, String dest) {

        int counterFound = 0;
        for (int i = 0; i < daOflight.getAll().size(); i++) {
            Flight flight = (Flight) daOflight.get(i);
            if (src.equalsIgnoreCase(flight.getSrc().toString())
                    && dest.equalsIgnoreCase(flight.getDst().toString())) {
                mapFound.put(counterFound++, (Flight) daOflight.get(i));
            }
        }
        if (mapFound.size() == 0) {
            found = false;
            console.printLn("Not found! Please check the FlightBoard[1] and try again");
        } else {
            found = true;
        }

        for (Map.Entry entry : mapFound.entrySet()) {
            console.printLn(String.valueOf(entry));
        }
    }

    public void addBooking(int bookedId, int tickets) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wPath))) {
            Set<Integer> keys = mapFound.keySet();
            for (int i : keys) {
                if (i == bookedId) {
                    Flight c = mapFound.get(i);
                    bufferedWriter.write(String.valueOf(c));
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                    console.printLn("Success!");
                }
            }
            mapFound.clear();
            DAObooking.load();
            DAObooking.create();

            emptySeats = booking.getPassengers().size() - tickets;

        } catch (IOException e) {
            console.printLn("Couldn't add the booking");
            e.printStackTrace();
        }
    }

    public void showBookings() {
        boolean existance = false;
        if (DAObooking.isExisted == existance) {
            console.printLn("No booking has been created --- THIS PART OF APP IS UNDER DEVELOPMENT," +
                    " FOR NOW RERUN TO GO BACK MAIN MENU!!  COME BACK LATER PLEASE");
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rPath));
            String readMyBookings = bufferedReader.readLine();
            int cMyBooking = 0;
            while (readMyBookings != null) {
                myBookings.put(cMyBooking, readMyBookings);
                cMyBooking++;
            }
            bufferedReader.close();


        } catch (IOException ex) {
            console.printLn("Couldn't read from cities");
        }

    }
}
