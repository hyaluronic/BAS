package com.company;

import com.company.Domain.Constants;
import com.company.Domain.Entity.Person;
import com.company.Infrastructure.FileReader;
import com.company.Infrastructure.FileWriter;
import com.company.Service.ValidationService;

import java.io.IOException;
import java.lang.constant.Constable;
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
            Person person = new Person();
            String[] arrOfStr = line.split(Constants.COMMA, 3);
            try {
                person.setId(parseInt(arrOfStr[0]));
            } catch (Exception e) {
                writer.writeLineToFile(line + Constants.Results.BAD_DATA.toString());
                System.out.println(line + Constants.Results.BAD_DATA.toString());
                continue;
            }
            person.setName(arrOfStr[1]);
            person.setCoefficient(arrOfStr[2]);

            if (!ValidationService.isIdValid(person.getId(), people)) {
                writer.writeLineToFile(line + Constants.Results.BAD_ID.toString());
                System.out.println(line + Constants.Results.BAD_ID.toString());
            } else if (!ValidationService.isNameValid(person.getName(), people)) {
                writer.writeLineToFile(line + Constants.Results.BAD_NAME.toString());
                System.out.println(person.toString() + Constants.Results.BAD_NAME.toString());
            } else if (!ValidationService.isCoefficientValid(person.getCoefficient(), people)) {
                writer.writeLineToFile(line + Constants.Results.BAD_COEFFICIENT.toString());
                System.out.println(person.toString() + Constants.Results.BAD_COEFFICIENT.toString());
            } else {
                people.add(person);
                writer.writeLineToFile(line + Constants.Results.GOOD.toString());
                System.out.println(line + Constants.Results.GOOD.toString());
            }
        }
        writer.closeFile();
    }
}
