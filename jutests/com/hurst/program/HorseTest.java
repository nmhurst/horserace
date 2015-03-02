package com.hurst.program;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import com.hurst.program.Horse;


public class HorseTest {

	public HorseTest() {
		PropertyConfigurator.configure("config/log4j.properties");
	}
	
	@Test
	public void testHorse() throws Exception {
			
		Horse horse = new Horse();
		
		int horseLaneNumber = horse.getLaneNumber(); 
		assertEquals(horseLaneNumber, 0);
		
		int horseTotalYards = horse.getTotalYards(); 
		assertEquals(horseTotalYards, 0);
		
		horse.addRaceYards(5);
		
		horseTotalYards = horse.getTotalYards(); 
		assertEquals(horseTotalYards, 5);
	
	}
	
}
