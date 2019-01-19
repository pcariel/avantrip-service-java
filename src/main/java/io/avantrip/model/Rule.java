package io.avantrip.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.avantrip.domain.RuleEntity;

public class Rule {
    private String name;
    private String description;
    private String conditions;
    private String actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    @JsonIgnore
    public Rule fromEntity(RuleEntity entity) {
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.conditions = entity.getConditions();
        this.actions = entity.getActions();
        return this;
    }
}