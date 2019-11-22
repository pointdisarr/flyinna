package menu;

public class Menu {
    public String show() {
        StringBuilder sb = new StringBuilder();
        sb.append("========================");
        sb.append("|    Booking App       |");
        sb.append("========================\n");
        sb.append("| 1. Flight Board      |\n");
        sb.append("| 2. Find the flight   |\n");
        sb.append("| 3. Search and book   |\n");
        sb.append("| 4. My Bookings       |\n");
        sb.append("| 5. Cancel Booking    |\n");
        sb.append("| 6. Exit              |\n");
        sb.append("========================\n");
        return sb.toString();
    }
}