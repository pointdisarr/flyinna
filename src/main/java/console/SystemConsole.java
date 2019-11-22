package console;

import java.util.Scanner;

public class SystemConsole implements Console {


    private Scanner in = new Scanner(System.in);

    @Override
    public void printLn(String s) {
        System.out.println(s);
    }

    @Override
    public String readLn() {

        return in.nextLine();
    }

    @Override
    public int readId() {
        try {
            return Integer.parseInt(in.nextLine());
        } catch (NumberFormatException nx) {
            return in.nextInt();
        }
    }


}
