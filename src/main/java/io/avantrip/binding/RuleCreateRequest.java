package io.avantrip.binding;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

@ApiModel(value = "RuleCreateRequest")
public class RuleCreateRequest {

    @ApiParam(value = "name", allowEmptyValue = false, required = true, defaultValue = "Test - Rule - Avantrip")
    private String name;

    @ApiParam(value = "description", allowEmptyValue = false, required = true, defaultValue = "Test - Rule - Avantrip")
    private String description;

    @ApiParam(value = "conditions", allowEmptyValue = false, required = false, defaultValue = "Test - Rule - Avantrip")
    private String conditions;

    @ApiParam(value = "actions", allowEmptyValue = false, required = true, defaultValue = "Test - Rule - Avantrip")
    private String actions;

    @ApiParam(value = "scored", allowEmptyValue = false, required = true, defaultValue = "Test - Rule - Avantrip")
    private Integer scored;

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

    public Integer getScored() {
        return this.scored;
    }

    public void setScored(Integer scored) {
        this.scored = scored;
    }

    @Override
    public String toString() {
        return String.format("Name -> %s, Description -> %s, Conditions -> %s, Actions -> %s, Scored -> %s", 
                name, description, conditions, actions, scored);
    }
}