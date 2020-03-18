package com.hardiansyah.car_rental.util;

import com.hardiansyah.car_rental.entitiy.cars.Car;
import com.hardiansyah.car_rental.entitiy.transaction.RentTransaction;

public class PriceCalculator {

	public static double calculateRentPrice(RentTransaction rentTransaction) {
		double totalPrice = 0;
		if(rentTransaction.getRentDuration()>0 && rentTransaction.getRentedCars().size()>0) {
			double price = getCarsPrice(rentTransaction);
			price -= (price*getFirstDiscRule(rentTransaction));
			price -= (price*getSecondDicRule(rentTransaction));
			
			totalPrice = price;
			
		}
		return totalPrice;
	}
	
	private static double getFirstDiscRule(RentTransaction rentTransaction) {
		return rentTransaction.getRentDuration() == 3 ? 0.05 : 0;
	}
	
	private static double getSecondDicRule(RentTransaction rentTransaction) {
		return rentTransaction.getRentedCars().size() >= 2 ? 0.1 : 0;
	}
	
	private static double getCarsPrice(RentTransaction rentTransaction) {
		double price = 0;
		
		for(Car car : rentTransaction.getRentedCars()) {
			price += car.getPrice();
		}
		
		return price * rentTransaction.getRentDuration();
	}
}
