package app;

import console.Console;
import console.SystemConsole;
import core.Core;
import core.Database;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Console con = new SystemConsole();
        Database db = new Database();
        Core app = new Core(con, db);
        app.run();
    }
}
