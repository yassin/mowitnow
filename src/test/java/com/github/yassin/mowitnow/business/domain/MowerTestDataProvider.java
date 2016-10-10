package com.github.yassin.mowitnow.business.domain;

import org.testng.annotations.DataProvider;

import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;

public class MowerTestDataProvider {

	@DataProvider(name = "forward_direction")
	public static Object[][] forward_direction() {
		return new Object[][] { { DirectionEnum.FORWARD } };
	}

	@DataProvider(name = "backward_direction")
	public static Object[][] backward_direction() {
		return new Object[][] { { DirectionEnum.BACKWARD } };
	}

	@DataProvider(name = "rotate_left")
	public static Object[][] rotate_left() {
		return new Object[][] { { RotationEnum.LEFT } };
	}

	@DataProvider(name = "rotate_right")
	public static Object[][] rotate_right() {
		return new Object[][] { { RotationEnum.RIGHT } };
	}
}
