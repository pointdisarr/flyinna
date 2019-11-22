package io;

import console.SystemConsole;

public class Parser {
    private SystemConsole console;

    public Command parse(String origin) {
        if ("1".equals(origin)) return Command.TIMETABLE_SHOW;
        else if ("2".equals(origin)) return Command.FIND_FLIGHT;
        else if ("3".equals(origin)) return Command.BOOKING_SEARCH_ADD;
        else if ("4".equals(origin)) return Command.MY_BOOKINGS;
        else if ("5".equals(origin)) return Command.CANCEL_BOOK;
        else if ("EXIT".equalsIgnoreCase(origin)) return Command.EXIT;
        else return Command.HELP;
    }

}
