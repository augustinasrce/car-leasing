package com.augustinas.leasing.car.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class VehicleData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    private Long id;

    @ApiModelProperty(hidden = true)
    private Long applicationId;

    @NotNull
    private String vin;

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    private BigDecimal price;

    public VehicleData() {
    }

    public VehicleData(String make, String model, String vin, BigDecimal price) {
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    private Long getApplicationId() {
        return applicationId;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
