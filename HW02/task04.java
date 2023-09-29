package HW02;
import java.util.Scanner;

public class task04 {
    public static void main(String[] args) {
        System.out.println("Введите данные:");
        Scanner sc = new Scanner(System.in);
        EmptyStringException(sc.nextLine());
        sc.close();
    }

    public static void EmptyStringException(String stringValue) {
        if (stringValue.isEmpty()) {
            throw new RuntimeException("Вы ничего не ввели :с");
        }
    }
}
