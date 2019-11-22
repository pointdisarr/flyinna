package DAO;

import entity.Booking;
import entity.Passenger;
import service.BookingService;

import java.util.List;

public class DAOpassengers implements DAO {
    Passenger passenger = new Passenger();
    Booking booking = new Booking();

    @Override
    public Object get(int id) {
        return booking.getPassengers().get(id);
    }

    @Override
    public List getAll() {
        return booking.getPassengers();
    }

    @Override
    public void put(Object o) {
        booking.getPassengers().add((Passenger) o);
    }

    @Override
    public void delete(int id) {
        booking.getPassengers().remove(id);
    }
}
