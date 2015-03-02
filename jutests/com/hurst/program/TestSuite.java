package com.hurst.program;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CheckTest.class, 
	HorseTest.class,
	HorseRaceTest.class
})
public class TestSuite {}
