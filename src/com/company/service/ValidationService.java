package com.company.service;

import com.company.domain.constants.ResultsEnum;
import com.company.domain.entity.Person;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class ValidationService {

    public static void idValidation(String idString, List<Person> people) throws Exception {
        if (idString.isBlank()) {
            throw new Exception(ResultsEnum.Results.INVALID_NO_ID.toString());
        } else if (checkForAdditionalSpaceCharacters(idString)) {
            throw new Exception(ResultsEnum.Results.INVALID_SPACE.toString());
        } else {
            try {
                int id = parseInt(idString);
                if (isIdDuplicate(id, people)) {
                    throw new Exception(ResultsEnum.Results.INVALID_ID_DUPLICATE.toString());
                }
            } catch (IllegalArgumentException e) {
                throw new Exception(ResultsEnum.Results.INVALID_ID.toString());
            }
        }
    }

    public static void nameValidation(String name, List<Person> people) throws Exception {
        if (name.isBlank()) {
            throw new Exception(ResultsEnum.Results.INVALID_NO_NAME.toString());
        } else if (checkForAdditionalSpaceCharacters(name)) {
            throw new Exception(ResultsEnum.Results.INVALID_SPACE.toString());
        } else if (!isNameValid(name)) {
            throw new Exception(ResultsEnum.Results.INVALID_NAME.toString());
        } else if (isNameDuplicate(name, people)) {
            throw new Exception(ResultsEnum.Results.INVALID_NAME_DUPLICATE.toString());
        }
    }

    public static void coefficientValidation(String coefficient) throws Exception {
        if (coefficient.isBlank()) {
            throw new Exception(ResultsEnum.Results.INVALID_NO_COEFFICIENT.toString());
        } else if (checkForSpaceCharacter(coefficient)) {
            throw new Exception(ResultsEnum.Results.INVALID_SPACE.toString());
        } else if (!isCoefficientValid(coefficient)) {
            throw new Exception(ResultsEnum.Results.INVALID_COEFFICIENT.toString());
        }
    }

    private static boolean checkForSpaceCharacter(String string) {
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(string);
        return matcher.find();
    }

    private static boolean isIdDuplicate(int id, List<Person> people) {
        return people.stream().anyMatch(p -> p.getId() == id);
    }

    private static boolean checkForAdditionalSpaceCharacters(String string) {
        String[] nameSplitBySpace = string.split(" ", 3);
        return nameSplitBySpace.length > 2;
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile("^[\\w]+\\s[\\w]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    private static boolean isNameDuplicate(String name, List<Person> people) {
        return people.stream().anyMatch(p -> p.getName().equals(name));
    }

    private static boolean isCoefficientValid(String coefficient) {
        Pattern pattern = Pattern.compile("^[\\d]+(\\.[\\d]{1,4})?$");
        Matcher matcher = pattern.matcher(coefficient);
        if (matcher.find()) {
            var value = Double.parseDouble(coefficient);
            return value >= 1 && value <= 2.5;
        }
        return false;
    }
}
