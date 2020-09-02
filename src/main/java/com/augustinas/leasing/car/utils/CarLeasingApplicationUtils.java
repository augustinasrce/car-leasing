package com.augustinas.leasing.car.utils;

import com.augustinas.leasing.car.model.CarLeasingApplication;
import com.augustinas.leasing.car.model.CarLeasingApplicationStatus;
import com.augustinas.leasing.car.model.PersonData;

import java.math.BigDecimal;
import java.util.List;

import static com.augustinas.leasing.car.model.CarLeasingApplicationStatus.ACCEPTED;
import static com.augustinas.leasing.car.model.CarLeasingApplicationStatus.REJECTED;
import static com.augustinas.leasing.car.service.CarLeasingApplicationService.MINIMUM_ACCEPTANCE_INCOME;

public final class CarLeasingApplicationUtils {
    private CarLeasingApplicationUtils() {
    }

    public static BigDecimal calculateApplicationIncome(List<PersonData> personDataList) {
        return personDataList.stream().map(PersonData::getIncome).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static CarLeasingApplicationStatus determineApplicationStatus(CarLeasingApplication application) {
        BigDecimal totalApplicationIncome = calculateApplicationIncome(application.getPersonData());
        return totalApplicationIncome.compareTo(MINIMUM_ACCEPTANCE_INCOME) > -1 ? ACCEPTED : REJECTED;
    }
}
