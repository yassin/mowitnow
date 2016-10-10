package com.github.yassin.mowitnow.business;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;

/**
 * Orientation Test
 * 
 * @author Yassin
 *
 */
public class OrientationTest {

	Orientation orientation;
	
	/**
	 * Test initialization 
	 *  
	 * We assume for all tests that :
	 * 			- the first orientation is North
	 * 
	 * NB : the test are depends each other (the orientation change between test)
	 * 
	 */
	@BeforeTest
	public void setUp(){
		this.orientation = new Orientation(OrientationEnum.NORTH);
	}
	
	@Test(dataProviderClass = OrientationTestDataProvider.class , dataProvider = "rotation_left")
	public void rotate_left_must_return_new_orientation_west(RotationEnum rotation) {
		Assert.assertEquals(this.orientation.rotate(rotation).getOrientationEnum(),OrientationEnum.WEST);
	}
	
	@Test(dataProviderClass = OrientationTestDataProvider.class , dataProvider = "rotation_right")
	public void rotate_right_must_return_new_orientation_north(RotationEnum rotation) {
		Assert.assertEquals(this.orientation.rotate(rotation).getOrientationEnum(),OrientationEnum.NORTH);
	}

	
}
