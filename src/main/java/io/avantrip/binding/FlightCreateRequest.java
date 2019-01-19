package io.avantrip.binding;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FlightCreateRequest {

    private Person personBuy;
    private Date dateBuy;
    private List<Person> passengers;
    private BigDecimal amount;
    private Person personaBilling;
    private Credicard Payement;

    public static class Credicard {
        private String name;
        private String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        } 

        public String getNumber() {
            return this.number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }

    public static class Person {
        private String name;
        private String lastName;
        private String dni;
        
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }
    }
}