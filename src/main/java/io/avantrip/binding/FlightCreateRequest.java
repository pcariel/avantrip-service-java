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
    }

    public static class Person {
        private String name;
        private String lastName;
        private Integer dni;
        
        
    }
}