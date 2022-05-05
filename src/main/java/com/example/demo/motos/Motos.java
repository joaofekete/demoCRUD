package com.example.demo.motos;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Motos {
    @Id
    @SequenceGenerator(
            name = "moto_sequence",
            sequenceName = "moto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "moto_sequence"
    )
    private long id;
    private String model;
    private String brand;
    private LocalDate dor; //date of release
    private Integer cc;
    @Transient
    private LocalDate tim;

    public Motos() {
    }

    public Motos(long id,
                 String model,
                 String brand,
                 LocalDate dor,
                 Integer cc
                 ) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.dor = dor;
        this.cc = cc;
    }

    public Motos(String model,
                 String brand,
                 LocalDate dor,
                 Integer cc) {
        this.model = model;
        this.brand = brand;
        this.dor = dor;
        this.cc = cc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getDor() {
        return dor;
    }

    public void setDor(LocalDate dor) {
        this.dor = dor;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Integer getTIM() {
        return Period.between(this.dor, LocalDate.now()).getYears();
    }

    public void setTIM(LocalDate tim) {
        this.tim = tim;
    }

    @Override
    public String toString() {
        return "Motos{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", dor=" + dor +
                ", cc=" + cc +
                ", tim=" + tim +
                '}';
    }
}
