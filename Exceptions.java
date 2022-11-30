package arabian;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions {
    public static void Calc(String[] args)
            throws IOException {
        Scanner scanner = new Scanner(System.in);
        int x= Integer.parseInt(scanner.nextLine());
        if (x != 0) {
            throw new IOException();
        }
    }

}
