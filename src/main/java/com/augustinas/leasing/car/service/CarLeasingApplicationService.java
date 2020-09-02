package com.augustinas.leasing.car.service;

import com.augustinas.leasing.car.model.CarLeasingApplication;

import java.math.BigDecimal;

public interface CarLeasingApplicationService {

    BigDecimal MINIMUM_ACCEPTANCE_INCOME = new BigDecimal("600");

    CarLeasingApplication save(CarLeasingApplication application);

    CarLeasingApplication findById(long id);
}
