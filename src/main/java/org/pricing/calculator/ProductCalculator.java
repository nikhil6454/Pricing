/**
 * 
 */
package org.pricing.calculator;

import java.io.File;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author nikhil.m
 *
 */
@SuppressWarnings("unchecked")
public class ProductCalculator extends CalculatorThread{
	Map<String,Object> product = null;
	public ProductCalculator(Map<String,Object> product) {
		this.product = product;
	}
	
	public static double calculateProductPrice(Map<String, Object> product) {
		double productPrice = 0;
		Map<String,Object> components = (Map<String, Object>) product.get("components");
		Iterator<Entry<String, Object>> iterator = components.entrySet().iterator();
	    while (iterator.hasNext()) {
	       Entry<String, Object> component = iterator.next();
	       productPrice = productPrice + ComponentCalculator.calculateComponentPrice(component);
	    }
		return productPrice;
	}
	
	public void run() {
		try
        { 
			double productPrice = 0;
			System.out.println("Thread Id -" + Thread.currentThread().getId()+" Product Name - "+ product.get("product"));
			productPrice = calculateProductPrice(product);
            System.out.println("Thread Id -" + Thread.currentThread().getId()+" Consolidated Product Price - "+productPrice);
        } 
        catch (Exception e) 
        { 
            System.out.println ("Exception is caught"); 
        } 
	}
}
