package com.company;

import com.company.Domain.Constants;
import com.company.Domain.Entity.Person;
import com.company.Infrastructure.FileReader;
import com.company.Infrastructure.FileWriter;
import com.company.Service.ValidationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader(Constants.INPUT_FILE);
        FileWriter writer = new FileWriter(Constants.OUTPUT_FILE);
        List<Person> people = new ArrayList<>();
        List<String> allLines = reader.readAllLinesFromFile();

        for (String line : allLines) {
            String[] arrOfStr = line.split(Constants.COMMA, 3);
            String result;
            try {
                int id = parseInt(arrOfStr[0]);
                if (ValidationService.isThereUnnecessarySpaceCharacter(arrOfStr[0])
                        || !ValidationService.isNameValid(arrOfStr[1])
                        || ValidationService.isThereUnnecessarySpaceCharacter(arrOfStr[2])) {
                    result = line + Constants.Results.BAD_SPACE.toString();
                } else if (!ValidationService.isIdValid(id, people)) {
                    result = line + Constants.Results.BAD_ID.toString();
                } else if (ValidationService.isNameDuplicate(arrOfStr[1], people)) {
                    result = line + Constants.Results.BAD_NAME.toString();
                } else if (!ValidationService.isCoefficientValid(arrOfStr[2], people)) {
                    result = line + Constants.Results.BAD_COEFFICIENT.toString();
                } else {
                    Person person = new Person();
                    person.setId(id);
                    person.setName(arrOfStr[1]);
                    person.setCoefficient(arrOfStr[2]);
                    people.add(person);
                    result = line + Constants.Results.GOOD.toString();
                }
            } catch (Exception e) {
                result = line + Constants.Results.BAD_DATA.toString();
            }
            writer.writeLineToFile(result);
            System.out.println(result);
        }
        writer.closeFile();
    }
}
