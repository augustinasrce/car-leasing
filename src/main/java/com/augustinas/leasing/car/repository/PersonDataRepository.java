package com.augustinas.leasing.car.repository;

import com.augustinas.leasing.car.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDataRepository extends JpaRepository<PersonData, String> {
    <S extends PersonData> S save(S entity);

    @Override
    List<PersonData> findAll();
}
