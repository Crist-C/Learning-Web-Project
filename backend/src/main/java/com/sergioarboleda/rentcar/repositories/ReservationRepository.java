package com.sergioarboleda.rentcar.repositories;

import com.sergioarboleda.rentcar.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    /**
     *
     * @return a list of all cars in the table
     */
    public List<Car> getAll(){
        return (List<Car>) carCrudRepository.findAll();
    }

    /**
     *
     * @param year the year that you need find cars
     * @return a list of car by year
     */
    public List<Car> getAllByYear(Integer year){
        return carCrudRepository.findByYear(year);
    }

    /**
     *
     * @param id : the car id that you need
     * @return a car with the id given
     */
    public Optional<Car> getById(Integer id){
        return carCrudRepository.findById(id);
    }

    /**
     *
     * @param plate : the car plate that you need
     * @return a car with the plate given
     */
    public Optional<Car> getByPlate(String plate){
        return carCrudRepository.findByPlate(plate);
    }

    /**
     *
     * @param car : Car object that you need to save on the table
     * @return the car given to save
     */
    public Car save(Car car){
        return carCrudRepository.save(car);
    }

    /**
     *
     * @param car : the Car object that you need to delete from the table
     */
    public void delete(Car car){
        carCrudRepository.delete(car);
    }

}
