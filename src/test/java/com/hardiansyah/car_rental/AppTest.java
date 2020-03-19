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
    	 * built in 2005, has disc 7%, disc price: 139.500
    	 * rent duration 3 (plus disc 5%)
    	 * 
    	 * (139.500*3) = 418.500
    	 * 418.500 - (418.500*5%) = 397.575
    	 */
    	RentTransaction trx = new RentTransaction(3);
        trx.addCar(car3);
        
    	assertEquals(397575, trx.getTotalPrice(), 0);
    }
    
    @Test
    public void testCase2() {
    	/**
    	 * Xenia, 250.000
    	 * Avanza, 300.000
    	 * Corola, 150.000, built below 2010, has disc 7%, disc price: 139.500
    	 * Rent Duration, 2 days
    	 * 
    	 * Disc applied, 10% for 3 cars
    	 * 
    	 * (250.000+300.000+139.500) * 2 = 1.379.000
    	 * 1.379.000 - (1.379.000 * 10%) = 1.241.100
    	 */
    	RentTransaction trx = new RentTransaction(2);
    	trx.addCar(car1);
    	trx.addCar(car2);
    	trx.addCar(car3);
    	
    	assertEquals(1241100, trx.getTotalPrice(),0);
    }
    
    @Test
    public void testCase3() {
    	/**
    	 * Xenia, 250.000
    	 * Avanza, 300.000
    	 * Corola, 150.000, built below 2010, has disc 7%, disc price: 139.500
    	 * Rent Duration, 3 days
    	 * 
    	 * Disc applied, 10% for 3 cars. rent for 3 days, disc 5%
    	 * 
    	 * (250.000+300.000+139.500) * 3 = 2.068.500
    	 * 2.068.500 - (2.068.500 * 10%) = ‭1.861.650‬
    	 * ‭1.861.650‬ - (‭1.861.650‬ * 5%) = ‭1.768.567,5‬
    	 */
    	RentTransaction trx = new RentTransaction(3);
    	trx.addCar(car1);
    	trx.addCar(car2);
    	trx.addCar(car3);
    	
    	assertEquals(1768567.5, trx.getTotalPrice(),0);
    }
}
