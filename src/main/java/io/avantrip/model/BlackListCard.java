package io.avantrip.model;

import io.avantrip.domain.BlackListCardEntity;

public class BlackListCard {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public BlackListCard fromEntity(BlackListCardEntity entity) {
        this.number = entity.getNumber();
        return this;
    }
}