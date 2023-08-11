package com.example.carSale.Web;

import com.example.carSale.entity.Car;
import com.example.carSale.repository.CarRepository;
import com.example.carSale.service.CarService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/car")
public class CarController {
    CarService carService;
    CarRepository carRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Integer id){
        return new  ResponseEntity<> (carService.getCar(id),HttpStatus.OK );

    }
    @PostMapping
        public ResponseEntity<Car> saveCar(@Valid @RequestBody Car car){

        return new ResponseEntity<>(carService.saveCar(car),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}/car")
    public ResponseEntity<Car> deleteCar(@PathVariable Integer id){
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Car>> getCars(){
        return  new ResponseEntity<> (carService.getCars(),HttpStatus.OK);
    }
}
