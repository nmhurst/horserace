package com.hurst.program;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.PropertyConfigurator;
import org.junit.*;

import java.io.IOException;

public class CheckTest {
	
	public CheckTest() {
		PropertyConfigurator.configure("config/log4j.properties");
	}
	
	@Test
	public void testIsInteger() {
				
		try {
			
			boolean r1 = Check.isInteger("a");
			assertEquals(false, r1);
			
			boolean r2 = Check.isInteger("1.1");
			assertEquals(false, r2);
			
			boolean r3 = Check.isInteger("1");
			assertEquals(true, r3);
			
			boolean r4 = Check.isInteger("0");
			assertEquals(true, r4);
						
			boolean r5 = Check.isInteger("-1");
			assertEquals(true, r5);
			
			boolean r6 = Check.isInteger(null);
			assertEquals(false, r6);
									
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test 
	public void testAllowedYards() {
		
		boolean r1 = Check.allowedYards(5);
		assertEquals(true, r1);
		
		boolean r2 = Check.allowedYards(1);
		assertEquals(false, r2);
		
	}
	
	@Test(expected = IOException.class)
	public void testBadMaxHorses() throws IOException {
	
		String[] testThree = {"h1", "h2", "h3", "h4", "h5", "h6", "h7", "h8"};
		System.out.println(String.valueOf(testThree.length));
		Check.maxHorses(testThree);
		
	}
	
	@Test
	public void testGoodMaxHorses() throws IOException{
	
		String[] testThree = {"h1", "h2", "h3", "h4", "h5", "h6", "h7"};
		System.out.println(String.valueOf(testThree.length));
		Check.maxHorses(testThree);
		
	}
	
	@Test(expected = IOException.class)
	public void testBadOneHorseRace() throws IOException {
	
		String[] testThree = {"h1"};
		System.out.println(String.valueOf(testThree.length));
		Check.oneHorseRace(testThree);
		
	}
	
	@Test
	public void testGoodOneHorseRace() throws IOException {
	
		String[] testThree = {"h1", "h2", "h3"};
		System.out.println(String.valueOf(testThree.length));
		Check.oneHorseRace(testThree);
		
	}

}
