package com.hardiansyah.car_rental.entitiy.cars;

public abstract class Car {
	protected int yearBuilt;
	protected double rentPrice;
	
	public double getPrice() {
		return (rentPrice - (getDiscount() * rentPrice));
	}
	
	private double getDiscount() {
		return yearBuilt < 2010 ? 0.07 : 0;
	}
}
