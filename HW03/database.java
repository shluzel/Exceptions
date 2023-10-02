package HW03;

import java.util.Scanner;

import static HW03.createstring.*;
import static HW03.WriteData.*;
import static HW03.checkinput.*;

public class database {
    public static void main(String[] args) {

        String pathDB = "HW03\\DataBase\\";

        System.out.println("введите данные (в любом порядке через пробел): \n "
                + " \"Фамилия Имя Отчество, дату рождения (dd.mm.yyyy), номер телефона(только цифры), пол(f/m)\"");
        Scanner sc = new Scanner(System.in);
        recordPersonalData(sc.nextLine(), pathDB);
        sc.close();
    }

    public static void recordPersonalData(String dataPeople, String pathDB) {
        checkInputData(dataPeople);
        String currentData = createStringRecord(dataPeople);
        writeLineFile(currentData, pathDB); 
    }

    public static void checkInputData(String dataPeople) {
        emptyStringException(dataPeople) ; 
        countInputException(dataPeople);
    }
    
}
