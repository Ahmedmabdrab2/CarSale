package com.example.carSale.service;

import com.example.carSale.entity.Car;
import com.example.carSale.exception.EntityNotFoundException;
import com.example.carSale.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
    public class CarServiceImpl implements CarService {
    CarRepository carRepository;
    @Override
    public Car getCar(Integer id) {
     Optional<Car> car = carRepository.findById(id);
         return unwrapCar(car,id);
    }

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Integer id) {
    carRepository.deleteById(id);
    }


    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }

    static Car unwrapCar(Optional<Car> entity, Integer id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, Car.class);
    }

}
