package entity;

public class Passenger {
    private int id;
    private String passengerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }


    @Override
    public String toString() {
        return id +
                " name " + passengerName + '\'';
    }
}
