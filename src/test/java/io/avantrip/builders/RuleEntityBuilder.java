package io.avantrip.builders;

import java.util.Date;

import io.avantrip.domain.RuleEntity;

public class RuleEntityBuilder {
    
    private String name;
    private String description;
    private String conditions;
    private String actions;

    public RuleEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RuleEntityBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public RuleEntityBuilder withConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    public RuleEntityBuilder withActions(String actions) {
        this.actions = actions;
        return this;
    }

    public RuleEntity build() {
        return new RuleEntity(
            name,
            description,
            conditions,
            actions
        );
    }
}