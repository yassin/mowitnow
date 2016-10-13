package com.github.yassin.mowitnow.business.enums;

import org.testng.annotations.DataProvider;

public class OrientationEnumTestDataProvider {

	
	@DataProvider(name = "north")
	public static Object[][] north() {
		return new Object[][] { { "N" } };
	}
	
	@DataProvider(name = "east")
	public static Object[][] east() {
		return new Object[][] { { "E" } };
	}
	
	@DataProvider(name = "west")
	public static Object[][] west() {
		return new Object[][] { { "W" } };
	}
	
	@DataProvider(name = "south")
	public static Object[][] south() {
		return new Object[][] { { "S"} };
	}
	
	@DataProvider(name = "empty")
	public static Object[][] empty() {
		return new Object[][] { { ""} };
	}
}
