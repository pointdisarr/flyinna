package entity;


import service.BookingService;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    public static int availableSeats = BookingService.emptySeats;
    private int id;
    private City src;
    private City dst;
    private LocalDateTime date;

    public Flight() {

    }

    public Flight(int flightId, City src, City cityDest, LocalDateTime flightDate) {
        this.id = flightId;
        this.src = src;
        this.dst = cityDest;
        this.date = flightDate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }


    @Override
    public String toString() {

        return id +
                " from " + src +
                " to " + dst +
                " at " + date +
                ", available seats " + availableSeats +
                "/30 ";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getSrc() {
        return src;
    }

    public City getDst() {
        return dst;
    }

    public void setDst(City dst) {
        this.dst = dst;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return getId() == flight.getId() &&
                Objects.equals(getSrc(), flight.getSrc()) &&
                Objects.equals(getDst(), flight.getDst()) &&
                Objects.equals(getDate(), flight.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getSrc(), getDst(), getDate());
    }
}