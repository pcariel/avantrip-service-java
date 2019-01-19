package io.avantrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.avantrip.domain.BlackListCardEntity;
import io.avantrip.model.BlackListCard;
import io.avantrip.repository.BlackListCardRepository;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private BlackListCardRepository blackListCardRepository;

    @Override
    public Page<BlackListCard> getAll(Pageable pageable) {
        Page<BlackListCardEntity> blackLists = blackListCardRepository.findAll(pageable);

        Page<BlackListCard> pageBlackList = blackLists
                .map(new Converter<BlackListCardEntity, BlackListCard>() {
                    @Override
                    public BlackListCard convert(BlackListCardEntity source) {
                        return new BlackListCard().fromEntity(source);
                    }

                });
        return pageBlackList;
    }

    @Override
    public BlackListCard addBlackList(final String number) {
        BlackListCardEntity entity = blackListCardRepository.save(new BlackListCardEntity(number));
        return new BlackListCard().fromEntity(entity);
    }

    @Override
    public Boolean isBlackList(String number) {
        List<BlackListCardEntity> credicards = blackListCardRepository.findAll();
        return credicards.parallelStream().allMatch(credicard -> credicard.getNumber().equals(number));
    }

}