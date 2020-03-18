package com.hardiansyah.car_rental.entitiy.transaction;

import java.util.ArrayList;
import java.util.List;

import com.hardiansyah.car_rental.entitiy.cars.Car;
import com.hardiansyah.car_rental.util.PriceCalculator;

public class RentTransaction {
	private List<Car> rentedCars;
	private int rentDuration;
	
	public RentTransaction(int rentDuration) {
		this.rentedCars = new ArrayList<Car>();
		this.rentDuration = rentDuration;
	}
	
	public void addCar(Car car) {
		this.rentedCars.add(car);
	}

	public int getRentDuration() {
		return rentDuration;
	}

	public void setRentDuration(int rentDuration) {
		this.rentDuration = rentDuration;
	}

	public List<Car> getRentedCars() {
		return rentedCars;
	}
	
	public double getTotalPrice() {
		return PriceCalculator.calculateRentPrice(this);
	}
	
}
