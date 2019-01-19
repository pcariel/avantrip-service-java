package io.avantrip.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.model.BlackListCard;;

@Service
public interface CardService {
    Page<BlackListCard> getAll(Pageable pageable);
    BlackListCard addBlackList(final String number);
    Boolean isBlackList(final String number);
}