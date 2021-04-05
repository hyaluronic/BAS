package com.company.Service;

import com.company.Domain.Entity.Person;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {

    public static boolean isIdValid(int id, List<Person> people) {
        return !people.stream().anyMatch(p -> p.getId() == id);
    }

    public static boolean isNameValid(String name, List<Person> people) {
        if(!people.stream().anyMatch(p -> p.getName() == name)){
            Pattern pattern = Pattern.compile("^[\\w]+\\s[\\w]+$");
            Matcher matcher = pattern.matcher(name);
            return matcher.find();
        }
        return false;
    }

    public static boolean isCoefficientValid(String coefficient, List<Person> people) {
            Pattern pattern = Pattern.compile("^[\\d]+(\\.[\\d]{1,4})?$");
            Matcher matcher = pattern.matcher(coefficient);
            if(matcher.find()){
                var value = Double.parseDouble(coefficient);
                return value>=1&&value<=2.5;
            }
            return false;
    }

//    public static boolean isThereSpaceCharacter(String string){
//        Pattern pattern = Pattern.compile("\\s");
//        Matcher matcher = pattern.matcher(string);
//        return matcher.find();
//    }
}
