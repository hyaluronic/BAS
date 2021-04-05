package com.company.Domain;

public class Constants {

    public enum Results {
        GOOD(" PRIIMTA"),
        BAD_DATA(" ATMESTA - neteisingai  atskirti duomenys"),
        BAD_ID(" ATMESTA - Kartojasi ID"),
        BAD_NAME(" ATMESTA - neteisingas vardas"),
        BAD_COEFFICIENT(" ATMESTA - neteisingas koeficientas");

        private String resultValues;

        Results(String s) {
            resultValues = s;
        }

        public String toString() {
            return resultValues;
        }
    }


}
