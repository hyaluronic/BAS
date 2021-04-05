package com.company;

import com.company.Domain.Entity.Person;
import com.company.Infrastructure.FileReader;
import com.company.Infrastructure.FileWriter;
import com.company.Service.ValidationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("/Users/user/Desktop/BAS/Programos duomenys.txt");
        FileWriter writer = new FileWriter("/Users/user/Desktop/BAS/out.txt");
        List<Person> people = new ArrayList<Person>();
        List<String> allLines = reader.readAllLinesFromFile();
        for (String line : allLines) {
            Person person = new Person();
            String[] arrOfStr = line.split(",", 3);
            try {
                person.setId(parseInt(arrOfStr[0]));
            } catch (Exception e) {
                writer.writeLineToFile(line + " ATMESTA - neteisingai  atskirti duomenys");
                System.out.println(line + " ATMESTA - neteisingai atskirti duomenys");
                continue;
            }
            person.setName(arrOfStr[1]);
            person.setCoefficient(arrOfStr[2]);

            if(!ValidationService.isIdValid(person.getId(), people)){
                writer.writeLineToFile(line + " ATMESTA - Kartojasi ID");
                System.out.println(line + " ATMESTA - Kartojasi ID");
            }
            else if (!ValidationService.isNameValid(person.getName(), people)) {
                writer.writeLineToFile(line + " ATMESTA - neteisingas vardas");
                System.out.println(person.toString() + " ATMESTA - neteisingas vardas");
            }
            else if (!ValidationService.isCoefficientValid(person.getCoefficient(), people)) {
                writer.writeLineToFile(line + " ATMESTA - neteisingas koeficientas");
                System.out.println(person.toString() + " ATMESTA - neteisingas koeficientas\"");
            }
            else{
                people.add(person);
                writer.writeLineToFile(line + " PRIIMTA");
                System.out.println(line + " PRIIMTA");
            }
        }
        writer.closeFile();
    }
}
