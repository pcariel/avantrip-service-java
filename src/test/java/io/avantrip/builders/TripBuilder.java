package io.avantrip.builders;

import java.util.Date;

public class TripBuilder {
    private Boolean isOneWay;
    private String origin;
    private String destiny;
    private Date date;
    private Date returnDate;

    public TripBuilder withIsOneWay(Boolean isOneWay) {
        this.isOneWay = isOneWay;
        return this;
    }

    public TripBuilder withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

    public TripBuilder withDestiny(String destiny) {
        this.destiny = destiny;
        return this;
    }

    public TripBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public TripBuilder withReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }
}