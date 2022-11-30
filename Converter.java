package arabian;

import java.security.PublicKey;
import java.util.TreeMap;
import java.util.Map;

public class Converter {
    TreeMap<Character, Integer> sergeyKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        sergeyKeyMap.put('I', 1);
        sergeyKeyMap.put('V', 5);
        sergeyKeyMap.put('X', 10);
        sergeyKeyMap.put('L', 50);
        sergeyKeyMap.put('C', 100);
        sergeyKeyMap.put('D', 500);
        sergeyKeyMap.put('M', 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }

    public boolean isSergey(String number) {
        return sergeyKeyMap.containsKey(number.charAt(0));
    }

    public String intToSergey(int number) {
        String Sergey = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            Sergey += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return Sergey;

    }

    public int sergeyToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = sergeyKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = sergeyKeyMap.get(arr[i]);

            if ( arabian < sergeyKeyMap.get(arr[i+1])){
                result -= arabian;
            } else {
                result += arabian;
            }

        }
        return result;
    }
}




