package arabian;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};

        Scanner scn = new Scanner(System.in);
        while (true){
        System.out.print("Введие выражение: ");
        String exp = scn.nextLine();
        int actionIndex = -1;
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }

        if (actionIndex == -1) {
            System.out.println("Некорректное выражение");
            return;

            //
        }

        String[] data = exp.split(regexActions[actionIndex]);
        int b;
        int result = 0;
        if (converter.isSergey(data[0]) == converter.isSergey(data[1])) {
            int a;
            boolean isSergey = converter.isSergey(data[0]);

            if (isSergey) {
                a = converter.sergeyToInt(data[0]);
                b = converter.sergeyToInt(data[1]);

            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);

            }
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    try {
                        result = a / b;
                    } catch (ArithmeticException | InputMismatchException e) {
                        System.out.println("Exception : " + e);
                        System.out.println("На ноль делить нельзя");
                        break;
                    }
                    break;
            }
            if (isSergey) {
                System.out.println(converter.intToSergey(result));
            } else
                System.out.println(result);

        } else {
            System.out.println("Числа должны быть в одном формате");

        }
    }
}
}



