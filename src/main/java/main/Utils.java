package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utils {
    private static final Random RANDOM = new Random();
    private static final String cyrillicCharacters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфцчшщъыьэюя";

    public static String generateRandomCharacter(int len){
        StringBuilder result = new StringBuilder(len);
        for(int i = 0; i < len; i++) {
            int randomCharIndex = RANDOM.nextInt(cyrillicCharacters.length());
            result.append(cyrillicCharacters.charAt(randomCharIndex));
        }
        return result.toString();
    }

    public static String generateCurrentDate(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

}
