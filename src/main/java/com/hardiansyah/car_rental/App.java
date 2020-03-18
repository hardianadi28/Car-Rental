package com.hardiansyah.car_rental;

import com.hardiansyah.car_rental.entitiy.cars.Avanza;
import com.hardiansyah.car_rental.entitiy.cars.Car;
import com.hardiansyah.car_rental.entitiy.cars.Corola;
import com.hardiansyah.car_rental.entitiy.cars.Xenia;
import com.hardiansyah.car_rental.entitiy.transaction.RentTransaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        Car carA = new Avanza(); // 300.000
        Car carB = new Xenia(); // 250.000
        Car carC = new Corola(); // 150.000
        
        RentTransaction trx1 = new RentTransaction(3);
//        trx1.addCar(carA);
//        trx1.addCar(carB);
        trx1.addCar(carC);
        
        // 2068500
        // 1965075
        
        System.out.print(trx1.getTotalPrice());
    }
}
