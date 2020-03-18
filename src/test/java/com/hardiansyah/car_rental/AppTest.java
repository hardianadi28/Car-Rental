package com.hardiansyah.car_rental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.hardiansyah.car_rental.entitiy.cars.Avanza;
import com.hardiansyah.car_rental.entitiy.cars.Car;
import com.hardiansyah.car_rental.entitiy.cars.Corola;
import com.hardiansyah.car_rental.entitiy.cars.Xenia;
import com.hardiansyah.car_rental.entitiy.transaction.RentTransaction;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	static Car car1;
	static Car car2;
	static Car car3;

    
    @BeforeClass
    public static void onceExecutedBeforeAll() {
    	/*
    	 * Xenia, Year Built: 2010, Rent Price per day: 250.000
    	 */
    	car1  = new Xenia();
    	
    	/*
    	 * Avanza, Year Built: 2015, Rent Price per day: 300.000
    	 */
    	car2  = new Avanza();
    	
    	/*
    	 * Corola, Year Built: 2005, Rent Price per day: 150.000
    	 */
    	car3  = new Corola();
    }
    
    @Test
    public void testCase1() {
    	/**
    	 * Corola, price per day: 150.000
    	 * built in 2005, disc 7%
    	 * rent duration 3
    	 * 
    	 * (150.000*3) = 450.000
    	 * 450.000 - (450.000*7%) = 418.500
    	 * 418.500 - (418.500*5%) = 397.575
    	 */
    	RentTransaction trx1 = new RentTransaction(3);
        trx1.addCar(car3);
        
    	assertEquals(397575, trx1.getTotalPrice(), 0);
    }
}
