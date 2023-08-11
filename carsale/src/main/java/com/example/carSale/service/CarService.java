package com.example.carSale.service;

import com.example.carSale.entity.Car;

import java.util.List;

public interface CarService {

    Car getCar(Integer id);
    Car saveCar(Car car);
    void deleteCar(Integer id);


    List<Car> getCars();

}
