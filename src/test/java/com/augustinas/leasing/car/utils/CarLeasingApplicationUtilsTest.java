package com.augustinas.leasing.car.utils;

import com.augustinas.leasing.car.model.CarLeasingApplication;
import com.augustinas.leasing.car.model.PersonData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static com.augustinas.leasing.car.model.CarLeasingApplicationStatus.ACCEPTED;
import static com.augustinas.leasing.car.model.CarLeasingApplicationStatus.REJECTED;
import static com.augustinas.leasing.car.utils.CarLeasingApplicationUtils.calculateApplicationIncome;
import static com.augustinas.leasing.car.utils.CarLeasingApplicationUtils.determineApplicationStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarLeasingApplicationUtilsTest {

    private PersonData personDataWithIncome0;
    private PersonData personDataWithIncome300;
    private PersonData personDataWithIncome600;
    private PersonData personDataWithIncome900;

    @BeforeEach
    public void setup() {
        personDataWithIncome0 = new PersonData("39308102040", "Test", "Test", new BigDecimal(0));
        personDataWithIncome300 = new PersonData("39308102040", "Test", "Test", new BigDecimal(300));
        personDataWithIncome600 = new PersonData("39308102050", "Test", "Test", new BigDecimal(600));
        personDataWithIncome900 = new PersonData("39308102060", "Test", "Test", new BigDecimal(300));
    }

    @Test
    public void calculateIncomeTest() {
        assertEquals(new BigDecimal(900), calculateApplicationIncome(List.of(personDataWithIncome300, personDataWithIncome600)));
        assertEquals(new BigDecimal(300), calculateApplicationIncome(List.of(personDataWithIncome300, personDataWithIncome0)));
        assertEquals(new BigDecimal(600), calculateApplicationIncome(List.of(personDataWithIncome600)));
        assertEquals(BigDecimal.ZERO, calculateApplicationIncome(List.of(personDataWithIncome0)));
    }

    @Test
    public void determineApplicationStatusTest() {
        CarLeasingApplication applicationWithIncome600 = new CarLeasingApplication();
        applicationWithIncome600.getPersonData().add(personDataWithIncome600);
        CarLeasingApplication applicationWithIncome300 = new CarLeasingApplication();
        applicationWithIncome300.getPersonData().add(personDataWithIncome300);
        CarLeasingApplication applicationWithIncome900 = new CarLeasingApplication();
        applicationWithIncome900.getPersonData().add(personDataWithIncome300);
        applicationWithIncome900.getPersonData().add(personDataWithIncome600);
        assertEquals(ACCEPTED, determineApplicationStatus(applicationWithIncome600));
        assertEquals(REJECTED, determineApplicationStatus(applicationWithIncome300));
        assertEquals(ACCEPTED, determineApplicationStatus(applicationWithIncome900));
    }
}