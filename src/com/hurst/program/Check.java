package com.hurst.program;

import java.io.IOException;

public class Check {

	public static boolean allowedYards(int yards) {
	    
		int validYards[] = {5, 10, 20, 40, 60};
		
		boolean validResult = false;
		for (int x = 0; x < 5; x++) {
			if(yards == validYards[x]) validResult = true;
		}
	    
		if(!validResult) {
			System.out.println("Incorrect data entered. Yards must be 5, 10, 20, 40 or 60.");
		}
		
		return validResult;
	}
	
	public static boolean isInteger(String s) {
	    
		if(s.isEmpty()) { return false; }
		
		try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    
	    return true;
	}	
	
	public static void oneHorseRace(String[] horseName) throws IOException {
		
		if (horseName.length == 1) { throw new IOException("Cannot have one horse race."); }
	}
	
	public static void maxHorses(String[] horseName) throws IOException {
		
		if (horseName.length > 7) { throw new IOException("Too many horses. Max of 7 allowed."); }
	}
	
	public static boolean dataCount(String[] raceData) {
		
		boolean status = true;
		
		if(raceData.length != 2) {
			System.out.println("Incorrect data entered. Please enter correct Lane and Yards data.");
			status = false;
		}
		
		return status;
	}
	
	public static int getIntegerValue(String s) {
		
		if(s == null) s = "0";
		
		int racedata = 0;
		
		if(Check.isInteger(s.trim())) {
			racedata = Integer.parseInt(s.trim());
		} else {
			System.out.println("Incorrect data entered. Data must be integers.");
		}
		
		return racedata;
	}
}
