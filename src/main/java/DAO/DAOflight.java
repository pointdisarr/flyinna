package DAO;

import console.Console;
import console.SystemConsole;
import entity.City;
import entity.Flight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;


public class DAOflight implements DAO {

    private final String rPath = "src/main/destCities.txt";
    private final String pRath = "src/main/srcCities.txt";
    private final String wPath = "src/main/flightboard.txt";
    Random rnd = new Random();
    int flightDstId = 0;
    int flightSrcId = 0;
    Console console = new SystemConsole();
    ArrayList<Flight> flights = new ArrayList<>();
    private String readDestination;
    private String readSource;
    private int flightId = 0;

    public DAOflight() {
        if (flights.size() == 0) {
            load();
        }
    }

    public void load() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rPath));
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(pRath));
            readDestination = bufferedReader.readLine();
            readSource = bufferedReader2.readLine();
            while (readDestination != null || readSource != null) {
                LocalDateTime flightDate = LocalDateTime.of(LocalDate.now(),
                        LocalTime.of(rnd.nextInt(24), rnd.nextInt(60)));
                readDestination = bufferedReader.readLine();
                flightDstId++;
                readSource = bufferedReader2.readLine();
                flightSrcId++;
                City cityDest = new City(flightDstId, readDestination);
                City citySrc = new City(flightSrcId, readSource);
                flightId++;
                Flight flight = new Flight(flightId, citySrc, cityDest, flightDate);
                flights.add(flight);
            }
            bufferedReader.close();
            bufferedReader2.close();
            create();
        } catch (IOException ex) {
            console.printLn("Couldn't read from cities");
        }
    }

    public void create() {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(wPath))) {
            for (Flight c : flights) {
                try {
                    bufferedWriter.write(String.valueOf(c));
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    console.printLn("Couldn't update the board");
                }
            }
        } catch (IOException e) {
            System.out.println("Couldn't to write to the board file");
        }
    }


    @Override
    public Object get(int id) {
        return flights.get(id);
    }

    @Override
    public ArrayList getAll() {
        return flights;
    }

    @Override
    public void put(Object o) {
        flights.add((Flight) o);
    }

    @Override
    public void delete(int id) {
        flights.remove(id);
    }
}
