package com.hurst.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class HorseRace {

	public static void main(String[] args) {
		
		// Create horse classes and list
        List<Horse> horses = getHorses();
                
        System.out.println("Race Starts!");
        
        runRace(horses);
        
		System.out.println("Race Ends");
				
		// Sort horses into race finish order
		sortRaceFinishOrder(horses);
		
		// Output Race Summary
		outputRaceSummary(horses);
		
	}
	
	private static List<Horse> getHorses() {
		// Enter horses in order, comma separated names
		System.out.println("Enter horse names in comma seperated order, maximum of 7 (e.g. Big Bob, Another Horse, Red Rum)");
		               
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String[] horseName = parseHorseNames(br);
        
        // Create horse classes and list
        List<Horse> horseList = new ArrayList<Horse>();
        for(int x = 0; x < horseName.length; x++) { 
        	// Debug Check: System.out.println(horseName[x]);
        	
        	Horse horse = new Horse();
        	horse.setLaneNumber(x + 1);
        	horse.setName(horseName[x]);
        	
        	horseList.add(horse);
        }
        
        return horseList;
	}
	
	public static void runRace(List<Horse> horses) {
		// Race ends after 1 furlong, or 220 yards
		int finishLineYards = 220;
		int leadHorseYards = 0;
		int stepStop = 44; // loop safety stop
		int step = 0; 
		
		// Create race loop
		System.out.println("Enter horse lane and yards run this turn. (e.g. 1 60):");
		while(leadHorseYards < finishLineYards && step < stepStop + 1){
			
			int lane = 0;
			int yards = 0;
			
			// Add horses yards
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String line = br.readLine();
				String[] raceData = line.split(" ");
				
				// Debug Check: System.out.println(line + ", " + String.valueOf(raceData.length) + ", " + String.valueOf(step) + ", " + String.valueOf(leadHorseYards));
				
				// Check correct amount of data
				if(Check.dataCount(raceData)) {
				
					// Check integer and get value
					lane = Check.getIntegerValue(raceData[0].trim());
					yards = Check.getIntegerValue(raceData[1].trim());
					
					// Check yards data is of stated allowed yards 5, 10, 20, 40 or 60
					Check.allowedYards(yards);
				}
								
			} catch (IOException e) {
				System.out.println(e);
			}
			
			// Only update race if correct data available
			if(lane > 0 && yards > 0) {
				// Checks are passed, update race
				horses.get(lane - 1).addRaceYards(yards);
		        
				// Get lead horse yards
				leadHorseYards = leadHorseTotalYards(horses);
							
				step++;
			} else {
				System.out.println("Race not updated. Incorrect race data entered.");
			}
			
		}
	}
		
	public static void sortRaceFinishOrder(List<Horse> horses) {
		// Sort horses into race finish order
		Collections.sort(horses, new Comparator<Horse>() {
			// Reverse order compare
	        public int compare(Horse h1, Horse h2) {
	            return h2.getTotalYards().compareTo(h1.getTotalYards());
	        }
	    });
	}	
	
	public static void outputRaceSummary(List<Horse> horses) {
		// Output Race Summary
		System.out.println("");
		System.out.println("Race Summary");
		System.out.println("Position, Lane, Horse name");
		
		StringBuilder outputLine;
		
		for(int x = 0; x < horses.size(); x++) {

			outputLine = new StringBuilder();
			outputLine.append(String.valueOf(x + 1)).append(", ")
			.append(horses.get(x).getLaneNumber().toString()).append(", ")
			.append(horses.get(x).getName());
			
			System.out.println(outputLine.toString());
		}
	}
	
	public static String[] parseHorseNames(BufferedReader br) {
		
        System.out.print("Enter competitors:");
        
        String horseNames = "";
        String[] horseName = null;
        
        try {
        	horseNames = br.readLine();
        	
        	horseName = horseNames.split(",");
        	
        	// Clean up string, remove leading and trailing white space
        	if (horseName.length > 0) {
        		for (int x = 0; x < horseName.length; x++) {
        			horseName[x] = horseName[x].trim();
        		}
        	}
        	
        	// Check for correct number of horses, max 7
        	Check.maxHorses(horseName);
        	
        	// Check for one horse race
        	Check.oneHorseRace(horseName);
        	        	
        } catch(IOException e) {
        	System.out.println(e);
        	System.exit(0);
        }
        
        return horseName;
	}
	
	public static int leadHorseTotalYards(List<Horse> horses) { 
		int leadYards = 0;
		
		for(int x = 0; x < horses.size(); x++) {
			if(horses.get(x).getTotalYards() > leadYards) {
				leadYards = horses.get(x).getTotalYards();
			}
		}
		
		return leadYards;
	}

}
