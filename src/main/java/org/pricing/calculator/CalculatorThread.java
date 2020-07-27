/**
 * 
 */
package org.pricing.calculator;

/**
 * @author nikhil.m
 *
 */
public class CalculatorThread extends Thread{
	
	public void run() 
    { 
        try
        { 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
            
        } 
        catch (Exception e) 
        { 
            // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 

}
