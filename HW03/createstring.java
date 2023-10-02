package HW03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

import static HW03.checkinput.emptyInputData;
import static HW03.checkinput.fullInputFIO;

public class createstring {
    public static String createStringRecord(String dataPeople) throws LocalException { 
        ArrayList<String> currentPeople = new ArrayList<>(Arrays.asList(dataPeople.split(" ")));
        while (currentPeople.contains("")) {
            currentPeople.remove("");
        }

        String[] fio = new String[3];
        int counter = 0;
        DateFormat pattern = new SimpleDateFormat("dd.MM.yyyy");
        String dataB = null;
        String numberPhone = null;
        String gender = null;

        for (String item : currentPeople) {

            if ((item.equals("f") || item.equals("m"))) { 
                if (gender != null) {
                    throw new LocalException("Вы укащали пол дважды");
                }
                gender = item;

            } else if (item.matches("([+]*)\\d+")) { 
                if (numberPhone != null) {
                    throw new LocalException("Вы указали телефон дважды");
                }
                numberPhone = item;
            } else if (item.matches("[a-zA-Zа-яА-Я]+")  
                    || (item.matches("([a-zA-Zа-яА-Я]+)(-)([a-zA-Zа-яА-Я]+)"))) {
                if (counter < 3) {
                    fio[counter] = item;
                    counter++;
                }
            } else {
                try {
                    pattern.parse(item);
                    LocalDate.parse(item, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    dataB = item;
                } catch (DateTimeParseException e) {
                    throw new LocalException("Некорректная дата: " + item);
                } catch (ParseException e) {
                    throw new LocalException("Неизвестный формат данных: " + item);
                }

            }
        }

        emptyInputData(dataB, "День рождения в формате (dd.mm.yyyy)"); //
        emptyInputData(numberPhone, "Телефон (целое беззнаковое число)");
        emptyInputData(gender, "Пол (f/m)");
        fullInputFIO(fio, counter); 

        return String.join(" ", fio[0], fio[1], fio[2], dataB, numberPhone, gender);
    }

}
