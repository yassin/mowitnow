package com.github.yassin.mowitnow.business;

import org.testng.annotations.DataProvider;

import com.github.yassin.mowitnow.business.enums.RotationEnum;

public class OrientationTestDataProvider {

	
	@DataProvider(name = "rotation_left")
	public static Object[][] rotation_left() {
		return new Object[][] { { RotationEnum.LEFT } };
	}
	
	@DataProvider(name = "rotation_right")
	public static Object[][] rotation_right() {
		return new Object[][] { { RotationEnum.RIGHT } };
	}
}
