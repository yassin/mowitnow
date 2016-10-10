package com.github.yassin.mowitnow.business.domain;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.Position;

/**
 * Lawn Test
 * 
 * @author Yassin
 *
 */
public class LawnTest {

	Lawn lawn;

	/**
	 * Test initialization 
	 *  
	 * We assume for all tests that :
	 * 			- the top position is (4,5) for shape limit
	 * 
	 */
	@BeforeTest
	public void setUp() {
		this.lawn = new Lawn(4, 5);
	}

	@Test(dataProviderClass = LawnTestDataProvider.class, dataProvider = "position_1_2")
	public void canMove_to_1_2_with_limit_4_5_must_return_true(Position position) {
		Assert.assertTrue(lawn.canMove(position));
	}

	@Test(dataProviderClass = LawnTestDataProvider.class, dataProvider = "position_5_6")
	public void canMove_to_5_6_with_limit_4_5_must_return_false(Position position) {
		Assert.assertFalse(lawn.canMove(position));
	}

	@Test(dataProviderClass = LawnTestDataProvider.class, dataProvider = "position_2_6")
	public void canMove_to_2_6_with_limit_4_5_must_return_false(Position position) {
		Assert.assertFalse(lawn.canMove(position));
	}

	@Test(dataProviderClass = LawnTestDataProvider.class, dataProvider = "position_6_4")
	public void canMove_to_6_4_with_limit_4_5_must_return_false(Position position) {
		Assert.assertFalse(lawn.canMove(position));
	}

}
