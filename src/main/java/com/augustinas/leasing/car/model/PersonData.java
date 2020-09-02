package com.augustinas.leasing.car.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(hidden = true)
    private Long applicationId;

    @NotNull
    private String personalCode;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private BigDecimal income;

    public PersonData() {
    }

    public PersonData(String personalCode, String firstName, String lastName, BigDecimal income) {
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    private Long getApplicationId() {
        return applicationId;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getIncome() {
        return income;
    }
}
