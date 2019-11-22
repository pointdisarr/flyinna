package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Booking {
    private int bookId;
    private City bookedCity;
    private LocalDateTime date;
    private ArrayList<Passenger> passengers = new ArrayList<>(30);
    private Flight flight = new Flight();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return getBookId() == booking.getBookId() &&
                Objects.equals(getBookedCity(), booking.getBookedCity()) &&
                Objects.equals(getDate(), booking.getDate()) &&
                Objects.equals(getPassengers(), booking.getPassengers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookedCity(), getDate(), getPassengers());
    }

    @Override
    public String toString() {
        return bookId +
                " to: " + bookedCity +
                " at: " + date +
                " with: " + flight.getAvailableSeats();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public City getBookedCity() {
        return bookedCity;
    }

    public void setBookedCity(City bookedCity) {
        this.bookedCity = bookedCity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ArrayList<Passenger> getPassengers() {

        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }
}
