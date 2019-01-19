package io.avantrip.builders;

import io.avantrip.binding.FlightCreateRequest.Person;

public class PersonBuilder {
    private String name;
    private String lastName;
    private String dni;

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder withDni(String dni) {
        this.dni = dni;
        return this;
    }

    public Person build() {
        Person persona = new Person();
        persona.setName(name);
        persona.setLastName(lastName);
        persona.setDni(dni);
        return persona;
    };
}