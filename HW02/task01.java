package HW02;

import java.util.Scanner;

public class task01 {
     public static void main(String[] args) {
        System.out.println(convertFloatNumber());
    }

    public static float convertFloatNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число с дробной частью (разделитель - точка)");
        String number = null;
        while (number == null) {
            number = sc.next();
            try {
                Float.parseFloat(number);
            } catch (NumberFormatException e) {
                System.out.println("Повторите ввод (число с дробной частью, разделитель точка)");
                number = null;
            }
        }
        sc.close();
        return Float.parseFloat(number);
        
    }
}