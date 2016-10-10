package com.github.yassin.mowitnow.business;

import org.testng.annotations.DataProvider;

import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;

public class PositionTestDataProvider {

	
	@DataProvider(name = "forward_north")
	public static Object[][] forward_north() {
		return new Object[][] { { DirectionEnum.FORWARD, OrientationEnum.NORTH } };
	}
	
	@DataProvider(name = "forward_east")
	public static Object[][] forward_east() {
		return new Object[][] { { DirectionEnum.FORWARD, OrientationEnum.EAST } };
	}
	
	@DataProvider(name = "forward_west")
	public static Object[][] forward_west() {
		return new Object[][] { { DirectionEnum.FORWARD, OrientationEnum.WEST } };
	}
	
	@DataProvider(name = "forward_south")
	public static Object[][] forward_south() {
		return new Object[][] { { DirectionEnum.FORWARD, OrientationEnum.SOUTH } };
	}
	
	@DataProvider(name = "backward_north")
	public static Object[][] backward_north() {
		return new Object[][] { { DirectionEnum.BACKWARD, OrientationEnum.NORTH } };
	}
	
	@DataProvider(name = "backward_east")
	public static Object[][] backward_east() {
		return new Object[][] { { DirectionEnum.BACKWARD, OrientationEnum.EAST } };
	}
	
	@DataProvider(name = "backward_west")
	public static Object[][] backward_west() {
		return new Object[][] { { DirectionEnum.BACKWARD, OrientationEnum.WEST } };
	}
	
	@DataProvider(name = "backward_south")
	public static Object[][] backward_south() {
		return new Object[][] { { DirectionEnum.BACKWARD, OrientationEnum.SOUTH } };
	}
}
