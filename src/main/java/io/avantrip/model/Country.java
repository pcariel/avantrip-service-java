package io.avantrip.model;

import io.avantrip.domain.CountryEntity;
import io.avantrip.domain.CountryEntity.CountryType;

public class Country {
    private String name;
    private CountryType type;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.toString();
    }

    public void setType(CountryType type) {
        this.type = type;
    }

    public Country fromEntity(CountryEntity entity) {
        name = entity.getName();
        type = entity.getCountryType();
        return this;
    }
}