package io.avantrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.binding.CountryCreateRequest;
import io.avantrip.domain.CountryEntity;
import io.avantrip.model.Country;
import io.avantrip.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Page<Country> getAll(Pageable pageable) {
        Page<CountryEntity> blackLists = countryRepository.findAll(pageable);

        Page<Country> pageBlackList = blackLists.map(new Converter<CountryEntity, Country>() {
            @Override
            public Country convert(CountryEntity source) {
                return new Country().fromEntity(source);
            }

        });
        return pageBlackList;
    }

    @Override
    public Country addBlackList(CountryCreateRequest request) {
        CountryEntity entity = countryRepository.save(new CountryEntity(request.getName(), request.getType()));
        return new Country().fromEntity(entity);
    }

    @Override
    public Boolean isBlackList(String countryName) {
        return countryRepository.existsByName(countryName);
    }

}