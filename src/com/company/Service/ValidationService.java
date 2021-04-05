package com.company.Service;

import com.company.Domain.Entity.Person;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {

    public static boolean isIdValid(int id, List<Person> people) {
        return !people.stream().anyMatch(p -> p.getId() == id);
    }

    public static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile("^[\\w]+\\s[\\w]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    public static boolean isNameDuplicate(String name, List<Person> people) {
        return people.stream().anyMatch(p -> p.getName().equals(name));
    }

    public static boolean isCoefficientValid(String coefficient, List<Person> people) {
        Pattern pattern = Pattern.compile("^[\\d]+(\\.[\\d]{1,4})?$");
        Matcher matcher = pattern.matcher(coefficient);
        if (matcher.find()) {
            var value = Double.parseDouble(coefficient);
            return value >= 1 && value <= 2.5;
        }
        return false;
    }

    public static boolean isThereUnnecessarySpaceCharacter(String string) {
        if(string.isBlank()){
            return false;
        }
        else{
            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(string);
            return matcher.find();
        }
    }
}
