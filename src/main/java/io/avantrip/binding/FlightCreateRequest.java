package io.avantrip.binding;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class FlightCreateRequest {

    private Integer scoring;
    private Person personBuy;
    private List<Person> passengers;
    private Person personaBilling;
    private Payment payment;
    private Trip trip;

    public static class Trip {

        private Boolean isOneWay;
        private String origin;
        private String destiny;
        private Date departureDate;
        private Date returnDate;

        public Boolean isOneWay() {
            return isOneWay;
        }

        public void setOneWay(Boolean isOneWay) {
            this.isOneWay = isOneWay;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestiny() {
            return destiny;
        }

        public void setDestiny(String destiny) {
            this.destiny = destiny;
        }

        public Date getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(Date departureDate) {
            this.departureDate = departureDate;
        }

        public Date getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(Date returnDate) {
            this.returnDate = returnDate;
        }
    }

    public static class Payment {
        private String name;
        private String number;
        private BigDecimal amount;
        private Date datePurchase;

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

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public Date getDatePurchase() {
            return datePurchase;
        }
    
        public void setDatePurchase(Date datePurchase) {
            this.datePurchase = datePurchase;
        }
    }

    public static class Person {
        private String name;
        private String lastName;
        private String dni;

        public Person() {
            
        }
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

    public Integer getScoring() {
        return this.scoring;
    }

    public void setScoring(Integer scoring) {
        this.scoring = scoring;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Person getPersonBuy() {
        return personBuy;
    }

    public void setPersonBuy(Person personBuy) {
        this.personBuy = personBuy;
    }

    public Person getPersonaBilling() {
        return personaBilling;
    }

    public void setPersonaBilling(Person personaBilling) {
        this.personaBilling = personaBilling;
    }

    public List<Person> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Person> passengers) {
        this.passengers = passengers;
    }
}