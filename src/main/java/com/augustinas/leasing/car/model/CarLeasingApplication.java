package com.augustinas.leasing.car.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "application")
public class CarLeasingApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "applicationId")
    private final List<PersonData> personData = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "applicationId")
    private VehicleData vehicleData;

    private CarLeasingApplicationStatus status;

    public CarLeasingApplication() {
    }

    public long getId() {
        return id;
    }

    public List<PersonData> getPersonData() {
        return personData;
    }

    public VehicleData getVehicleData() {
        return vehicleData;
    }

    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }

    public CarLeasingApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(CarLeasingApplicationStatus status) {
        this.status = status;
    }
}
