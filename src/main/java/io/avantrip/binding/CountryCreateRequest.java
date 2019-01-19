package io.avantrip.binding;

import io.avantrip.domain.CountryEntity.CountryType;

public class CountryCreateRequest {
    
    private String name;
    private CountryType type;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryType getType() {
        return type;
    }

    public void setType(CountryType type) {
        this.type = type;
    }
}