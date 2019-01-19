package io.avantrip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.avantrip.domain.CountryEntity;;

public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    Boolean existsByName(String name);
}