package io.avantrip.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.binding.CountryCreateRequest;
import io.avantrip.model.Country;

@Service
public interface CountryService {
    Page<Country> getAll(Pageable pageable);
    Country addBlackList(final CountryCreateRequest request);
    Boolean isBlackList(final String countryName);
} 