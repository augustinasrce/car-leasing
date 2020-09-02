package com.augustinas.leasing.car.repository;

import com.augustinas.leasing.car.model.PersonData;
import com.augustinas.leasing.car.model.VehicleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleDataRepository extends JpaRepository<VehicleData, String> {
    <S extends PersonData> S save(S entity);

    @Override
    List<VehicleData> findAll();
}
