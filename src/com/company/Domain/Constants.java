package com.company.Domain;

public class Constants {

    public static final String INPUT_FILE = "/Users/user/Desktop/BAS/Programos duomenys.txt";
    public static final String OUTPUT_FILE = "/Users/user/Desktop/BAS/out.txt";
    public static final String COMMA = ",";

    public enum Results {
        GOOD(" PRIIMTA"),
        BAD_SPACE(" ATMESTA - papildomas tarpas"),
        BAD_DATA(" ATMESTA - neteisingai atskirti duomenys"),
        BAD_ID(" ATMESTA - kartojasi ID"),
        BAD_NAME(" ATMESTA - kartojasi vardas"),
        BAD_COEFFICIENT(" ATMESTA - neteisingas koeficientas");

        private final String resultValues;

        Results(String s) {
            resultValues = s;
        }

        public String toString() {
            return resultValues;
        }
    }
}
