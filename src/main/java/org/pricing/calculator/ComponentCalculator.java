/**
 * 
 */
package org.pricing.calculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author nikhil.m
 *
 */
public class ComponentCalculator {
	
	public static double calculateComponentPrice(Entry<String, Object> component) {
		double componentPrice = 0;
		System.out.println("Thread Id -" + Thread.currentThread().getId()+" "+component.getKey() + ":" + component.getValue());
		String str = component.getKey(); 
        switch(str) 
        { 
        case "frame": 
          componentPrice = calculatePriceForFrame(component.getValue());
            break; 
        case "seat": 
        	componentPrice = calculatePriceForSeat(component.getValue());
            break; 
        case "Wheel": 
        	componentPrice = calculatePriceForWheel(component.getValue());
            break; 
        case "Handle": 
        	componentPrice = calculatePriceForHandle(component.getValue());
            break;
        case "breaks": 
        	componentPrice = calculatePriceForBreaks(component.getValue());
            break;
        default: 
            System.out.println("No Price Mentioned"); 
            break;
        }
        System.out.println("Thread Id -" + Thread.currentThread().getId()+" Component Price -"+componentPrice);
		return componentPrice;
	}

	private static double calculatePriceForBreaks(Object part) {
		double partPrice = 0;
		Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) part).entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getKey().equalsIgnoreCase("type")) {
				if(entry.getValue().equals("Hydraulic")) {
					partPrice = 30.00;
				}else {
					partPrice = 20.00;
				}
			}
			partPrice = calculatePriceByPurchaseDate(partPrice, entry);
		}
		return partPrice;
	}

	private static double calculatePriceForHandle(Object part) {
		double partPrice = 0;
		Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) part).entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getKey().equalsIgnoreCase("type")) {
				if(entry.getValue().equals("Sports")) {
					partPrice = 30.00;
				}else {
					partPrice = 20.00;
				}
			}
			partPrice = calculatePriceByPurchaseDate(partPrice, entry);
		}
		return partPrice;
	}

	private static double calculatePriceForWheel(Object part) {
		double partPrice = 0;
		Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) part).entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getKey().equalsIgnoreCase("type")) {
				if(entry.getValue().equals("Alloy")) {
					partPrice = 30.00;
				}else {
					partPrice = 20.00;
				}
			}
			partPrice = calculatePriceByPurchaseDate(partPrice, entry);
		}
		return partPrice*2; //Calculating for Two Wheels;
	}

	private static double calculatePriceForSeat(Object part) {
		double partPrice = 0;
		Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) part).entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getKey().equalsIgnoreCase("type")) {
				if(entry.getValue().equals("Sports")) {
					partPrice = 30.00;
				}else {
					partPrice = 20.00;
				}
			}
			partPrice = calculatePriceByPurchaseDate(partPrice, entry);
		}
		return partPrice;
	}

	private static double calculatePriceForFrame(Object part) {
		double partPrice = 0;
		Iterator<Entry<String, Object>> iterator = ((Map<String, Object>) part).entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Object> entry = iterator.next();
			if (entry.getKey().equalsIgnoreCase("type")) {
				if(entry.getValue().equals("alluminium")) {
					partPrice = 30.00;
				}else {
					partPrice = 20.00;
				}
			}
			partPrice = calculatePriceByPurchaseDate(partPrice, entry);
		}
		return partPrice;
	}

	private static double calculatePriceByPurchaseDate(double partPrice, Entry<String, Object> entry) {
		if (entry.getKey().equalsIgnoreCase("date")) {
			SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date priceHikeDate = sdfo.parse("2016-12-01");
				Date purchasedDate = sdfo.parse(entry.getValue().toString());
				if (purchasedDate.compareTo(priceHikeDate) > 0) {
					partPrice = partPrice + 10;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return partPrice;
	}
}
