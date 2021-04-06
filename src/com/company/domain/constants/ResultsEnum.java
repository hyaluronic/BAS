package com.company.domain.constants;

public class ResultsEnum {

    public enum Results {
        VALID(" PRIIMTA"),
        INVALID_DATA(" ATMESTA - truksta duomenu"),
        INVALID_NO_ID(" ATMESTA - nera ID"),
        INVALID_NO_NAME(" ATMESTA - nera vardo ir pavardes"),
        INVALID_NO_COEFFICIENT(" ATMESTA - nera koeficiento"),
        INVALID_SPACE(" ATMESTA - papildomas tarpas"),
        INVALID_ID(" ATMESTA - blogas ID"),
        INVALID_ID_DUPLICATE(" ATMESTA - kartojasi ID"),
        INVALID_NAME(" ATMESTA - blogas vardas ir pavarde"),
        INVALID_NAME_DUPLICATE(" ATMESTA - kartojasi vardas ir pavarde"),
        INVALID_COEFFICIENT(" ATMESTA - neteisingas koeficientas");

        private final String resultValues;

        Results(String s) {
            resultValues = s;
        }

        public String toString() {
            return resultValues;
        }
    }
}
