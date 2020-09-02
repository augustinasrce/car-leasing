package com.augustinas.leasing.car.repository;

import com.augustinas.leasing.car.model.CarLeasingApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarLeasingApplicationRepository extends JpaRepository<CarLeasingApplication, Long> {

    Optional<CarLeasingApplication> findById(Long id);

    CarLeasingApplication save(CarLeasingApplication entity);


}
