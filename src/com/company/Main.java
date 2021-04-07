package com.company;

import com.company.domain.constants.Constants;
import com.company.domain.constants.ResultsEnum;
import com.company.domain.entity.Person;
import com.company.infrastructure.FileReader;
import com.company.infrastructure.FileWriter;
import com.company.service.ValidationService;

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
            String[] lineSplitByComma = line.split(Constants.COMMA, 3);
            String result;
            String message;
            try {
                if (lineSplitByComma.length < 3) {
                    throw new Exception(ResultsEnum.Results.INVALID_DATA.toString());
                } else {
                    ValidationService.idValidation(lineSplitByComma[0], people);
                    ValidationService.nameValidation(lineSplitByComma[1], people);
                    ValidationService.coefficientValidation(lineSplitByComma[2]);

                    Person person = new Person();
                    person.setId(parseInt(lineSplitByComma[0]));
                    person.setName(lineSplitByComma[1]);
                    person.setCoefficient(Double.parseDouble(lineSplitByComma[2]));
                    people.add(person);

                    message = ResultsEnum.Results.VALID.toString();
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
            result = line + message;
            writer.writeLineToFile(result);
        }
        writer.closeFile();
    }
}
