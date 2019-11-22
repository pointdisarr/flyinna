package DAO;

import console.Console;
import console.SystemConsole;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DAObooking implements DAO {
    public static boolean isExisted = false;
    static String wPath = "src/main/mybookings.txt";
    static String rPath = "src/main/booking.txt";
    static ArrayList<String> myBookings = new ArrayList<>();
    Console console = new SystemConsole();
    ArrayList<String> bookings = new ArrayList<>();


    public static void load() {
        try (Scanner sc = new Scanner(new File(rPath))) {
            String readBooking;
            if (sc.hasNextLine()) {
                readBooking = sc.nextLine();
                myBookings.add(readBooking);
            } else {
                System.out.println("Couldn't get the booking");
            }
        } catch (IOException ex) {
            System.out.println("Couldn't read the booked flight");
        }

    }

    public static void create() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wPath))) {
            if (myBookings.size() != 0) {
                myBookings.forEach(c -> {
                    try {
                        bufferedWriter.write(c.toString());
                        bufferedWriter.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                System.out.println("Please rerun the program again");
            }
        } catch (IOException ex) {
            System.out.println("Couldn't save the booking");
        }
    }

    @Override
    public Object get(int id) {
        return myBookings.get(id);
    }

    @Override
    public ArrayList getAll() {
        return myBookings;
    }

    @Override
    public void put(Object o) {
        myBookings.add(o.toString());

    }

    @Override
    public void delete(int id) {
        myBookings.remove(id);
    }
}

