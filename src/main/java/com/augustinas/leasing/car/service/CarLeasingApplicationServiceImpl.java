package com.augustinas.leasing.car.service;

import com.augustinas.leasing.car.model.CarLeasingApplication;
import com.augustinas.leasing.car.repository.CarLeasingApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static com.augustinas.leasing.car.utils.CarLeasingApplicationUtils.determineApplicationStatus;

@Service
public class CarLeasingApplicationServiceImpl implements CarLeasingApplicationService {

    private CarLeasingApplicationRepository carLeasingApplicationRepository;

    @Autowired
    public CarLeasingApplicationServiceImpl(CarLeasingApplicationRepository carLeasingApplicationRepository) {
        this.carLeasingApplicationRepository = carLeasingApplicationRepository;
    }

    @Override
    @Transactional
    public CarLeasingApplication save(CarLeasingApplication application) {
        application.setStatus(determineApplicationStatus(application));
        return carLeasingApplicationRepository.save(application);
    }

    @Override
    public CarLeasingApplication findById(long id) {
        return carLeasingApplicationRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
