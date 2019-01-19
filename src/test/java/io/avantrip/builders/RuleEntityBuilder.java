package io.avantrip.builders;

import java.util.Date;

import io.avantrip.domain.RuleEntity;

public class RuleEntityBuilder {
    
    private String name;
    private String description;
    private String conditions;
    private String actions;
    private Integer scored;
    private Boolean active;

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

    public RuleEntityBuilder withScored(Integer scored) {
        this.scored = scored;
        return this;
    }

    public RuleEntityBuilder withActive(Boolean active) {
        this.active = active;
        return this;
    }

    public RuleEntity build() {
        return new RuleEntity(
            name,
            description,
            conditions,
            actions,
            scored,
            active
        );
    }
}