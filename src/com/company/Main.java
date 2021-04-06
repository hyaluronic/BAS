package com.company;

import com.company.domain.ResultsEnum;
import com.company.domain.entity.Person;
import com.company.infrastructure.FileReader;
import com.company.infrastructure.FileWriter;
import com.company.service.ValidationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;


public class Main {

    public static final String COMMA = ",";
    private static final String INPUT_FILE = "/Users/user/Desktop/BAS/Programos duomenys.txt";
    private static final String OUTPUT_FILE = "/Users/user/Desktop/BAS/out.txt";

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(INPUT_FILE);
        FileWriter writer = new FileWriter(OUTPUT_FILE);
        List<Person> people = new ArrayList<>();
        List<String> allLines = reader.readAllLinesFromFile();

        for (String line : allLines) {
            String[] lineSplitByComma = line.split(COMMA, 3);
            String result = line;
            try {
                if (lineSplitByComma.length < 3) {
                    result += ResultsEnum.Results.INVALID_DATA.toString();
                } else if (lineSplitByComma[0].isBlank()) {
                    result += ResultsEnum.Results.INVALID_NO_ID.toString();
                } else if (lineSplitByComma[1].isBlank()) {
                    result += ResultsEnum.Results.INVALID_NO_NAME.toString();
                } else if (lineSplitByComma[2].isBlank()) {
                    result += ResultsEnum.Results.INVALID_NO_COEFFICIENT.toString();
                } else {
                    int id = parseInt(lineSplitByComma[0]);
                    if (ValidationService.checkForSpaceCharacter(lineSplitByComma[0])
                            || ValidationService.checkForAdditionalSpaceCharacters(lineSplitByComma[1])
                            || ValidationService.checkForSpaceCharacter(lineSplitByComma[2])) {
                        result += ResultsEnum.Results.INVALID_SPACE.toString();
                    } else if (!ValidationService.isIdValid(id, people)) {
                        result += ResultsEnum.Results.INVALID_ID_DUPLICATE.toString();
                    } else if (!ValidationService.isNameValid(lineSplitByComma[1])) {
                        result += ResultsEnum.Results.INVALID_NAME.toString();
                    } else if (ValidationService.isNameDuplicate(lineSplitByComma[1], people)) {
                        result += ResultsEnum.Results.INVALID_NAME_DUPLICATE.toString();
                    } else if (!ValidationService.isCoefficientValid(lineSplitByComma[2])) {
                        result += ResultsEnum.Results.INVALID_COEFFICIENT.toString();
                    } else {
                        Person person = new Person();
                        person.setId(id);
                        person.setName(lineSplitByComma[1]);
                        person.setCoefficient(lineSplitByComma[2]);
                        people.add(person);
                        result += ResultsEnum.Results.VALID.toString();
                    }
                }
            } catch (Exception e) {
                result += ResultsEnum.Results.INVALID_ID.toString();
            }
            writer.writeLineToFile(result);
            System.out.println(result);
        }
        writer.closeFile();
    }
}
