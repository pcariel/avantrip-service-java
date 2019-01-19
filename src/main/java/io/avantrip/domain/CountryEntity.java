package io.avantrip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class CountryEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_type")
    private CountryType countryType;

    public CountryEntity() {

    }

    public CountryEntity(String name, CountryType countryType) {
        this.name = name;
        this.countryType = countryType;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum CountryType {
        BORDERING, DANGER;
    }

    public CountryType getCountryType() {
        return countryType;
    }

    public void setCountryType(CountryType countryType) {
        this.countryType = countryType;
    }
    
}