package com.hurst.program;

import static org.junit.Assert.*;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import com.hurst.program.HorseRace;

public class HorseRaceTest {

	public HorseRaceTest() {
		PropertyConfigurator.configure("config/log4j.properties");
	}
	
	@Test
	public void testParseHorseNames() {
		
		try {
			
			String testOne = "Big Bob, Red Rum, Old Yeller";
			InputStream stream = new ByteArrayInputStream(testOne.getBytes(StandardCharsets.UTF_8));

			BufferedReader br = new BufferedReader(new InputStreamReader(stream));

			String[] horseNames1 = HorseRace.parseHorseNames(br);
			
			assertEquals(horseNames1[0], "Big Bob");
			assertEquals(horseNames1[1], "Red Rum");
			assertEquals(horseNames1[2], "Old Yeller");
															
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
