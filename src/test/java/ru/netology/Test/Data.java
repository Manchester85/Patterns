package ru.netology.Test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Data {
    private Data() {
    }

    private static Faker faker = new Faker(new Locale("ru"));;

    public static String when(boolean reschedule) {
        if (reschedule)
        return LocalDate.now().plusDays(6).format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        else return LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
    }

    public static String getCity(){
        return faker.address().cityName().replace("Магнитогорск", "Тольятти").replace("Сочи", "Тула");
    }

    public static String getName() {
        return faker.name().fullName();
    }

    public static String getPhone(String locale) {
        return faker.phoneNumber().phoneNumber().replace("+", "+").replace("(", "").replace(")", "").replace("-", "");
    }


}


