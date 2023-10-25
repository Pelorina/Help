package ChoseYourHelp.Help.Extra;

import java.time.LocalDate;
import java.time.Period;

public class AgeRestriction {
    public static final int MIN_AGE = 20;
    public static final int MAX_AGE = 70;

    public static LocalDate validateAge(LocalDate birthdate) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthdate, currentDate).getYears();

        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Too young to be a help. Minimum age required: " + MIN_AGE + ".");
        }
        if (age > MAX_AGE) {
            throw new IllegalArgumentException("Too old to be a help. Maximum age allowed: " + MAX_AGE + ".");
        }
        return currentDate;
    }
}