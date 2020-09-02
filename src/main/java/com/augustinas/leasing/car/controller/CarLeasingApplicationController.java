package com.augustinas.leasing.car.controller;

import com.augustinas.leasing.car.model.CarLeasingApplication;
import com.augustinas.leasing.car.service.CarLeasingApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/car-leasing-application")
public class CarLeasingApplicationController {

    @Autowired
    private CarLeasingApplicationService carLeasingApplicationService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarLeasingApplication> test(@RequestBody CarLeasingApplication application) {
        CarLeasingApplication savedApplication = carLeasingApplicationService.save(application);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/status")
    public CarLeasingApplication getAll(@PathVariable long id) {
        return carLeasingApplicationService.findById(id);
    }
}
