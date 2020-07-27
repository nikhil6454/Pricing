/**
 * 
 */
package org.pricing.calculator;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author nikhil.m
 *
 */
public class PriceCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		File inputFile = new File("input.json");
		try {
			Map<String,Object> map = new HashMap<>();
		    map = mapper.readValue(inputFile, new TypeReference<HashMap>(){});
		    List<Map<String,Object>>  products = (List<Map<String, Object>>) map.get("products");
		    System.out.println("No of Products - "+products.size());
		    for(Map<String,Object> product:products) {
		    	int n = 10; 
		        for (int i=0; i<n; i++) 
		        { 
		        	ProductCalculator object = new ProductCalculator(product); 
		            object.start(); 
		        } 
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
