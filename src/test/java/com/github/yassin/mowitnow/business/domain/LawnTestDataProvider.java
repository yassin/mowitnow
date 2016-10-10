package com.github.yassin.mowitnow.business.domain;

import org.testng.annotations.DataProvider;

import com.github.yassin.mowitnow.business.Position;

public class LawnTestDataProvider {

	@DataProvider(name = "position_1_2")
	public static Object[][] position_1_2() {
		Position position = new Position(1, 2);
		return new Object[][] { { position } };
	}
	
	@DataProvider(name = "position_5_6")
	public static Object[][] position_5_6() {
		Position position = new Position(5, 6);
		return new Object[][] { { position } };
	}
	
	@DataProvider(name = "position_2_6")
	public static Object[][] position_2_6() {
		Position position = new Position(2, 6);
		return new Object[][] { { position } };
	}
	
	@DataProvider(name = "position_6_4")
	public static Object[][] position_6_4() {
		Position position = new Position(6, 4);
		return new Object[][] { { position } };
	}
}
