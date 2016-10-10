package com.github.yassin.mowitnow.business;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;

/**
 * Position Test
 * 
 * @author Yassin
 *
 */
public class PositionTest {

	public Position position;

	/**
	 * Test initialization
	 * 
	 * We assume for all tests that : - the first position is (1,2)
	 */
	@BeforeTest
	public void setUp() {
		this.position = new Position(1, 2);
	}

	private void resetPositionBetweenTest() {
		this.position.setX(1);
		this.position.setY(2);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "forward_north")
	public void next_forward_north_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 3);

	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "forward_east")
	public void next_forward_east_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 2);
		Assert.assertEquals(newPosition.getY(), 2);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "forward_south")
	public void next_forward_south_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 1);

	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "forward_west")
	public void next_forward_west_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 0);
		Assert.assertEquals(newPosition.getY(), 2);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "backward_north")
	public void next_backward_north_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 1);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "backward_east")
	public void next_backward_east_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 0);
		Assert.assertEquals(newPosition.getY(), 2);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "backward_south")
	public void next_backward_south_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 1);
		Assert.assertEquals(newPosition.getY(), 3);
	}

	@Test(dataProviderClass = PositionTestDataProvider.class, dataProvider = "backward_west")
	public void next_backward_west_test(DirectionEnum direction,
			OrientationEnum orientation) {
		resetPositionBetweenTest();
		Position newPosition = this.position.next(direction, orientation);
		Assert.assertEquals(newPosition.getX(), 2);
		Assert.assertEquals(newPosition.getY(), 2);
	}

}
