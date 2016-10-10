package com.github.yassin.mowitnow.business.domain;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.Orientation;
import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;
import com.github.yassin.mowitnow.exceptions.EngineException;

/**
 * Mower Test
 * 
 * @author Yassin
 *
 */
public class MowerTest {

	Mower mower;

	/**
	 * Test initialization
	 * 
	 * We assume for all tests that : - The top position of lawn is (5,6) for
	 * shape limit - A current position of Mower is (1,2) - An orientation of
	 * mower is North
	 */
	@BeforeTest
	public void setUp() {
		Lawn lawn = new Lawn(5, 6);
		Position currentPosition = new Position(1, 2);
		Orientation currentOrientation = new Orientation(OrientationEnum.NORTH);
		mower = new Mower(currentPosition, currentOrientation, lawn);
	}

	/**
	 * reset mower to first configuration
	 */
	private void resetMower() {
		mower.setCurrentOrientation(new Orientation(OrientationEnum.NORTH));
		mower.setCurrentPosition(new Position(1, 2));
	}

	@Test(dataProviderClass = MowerTestDataProvider.class, dataProvider = "forward_direction")
	public void move_straight_must_return_true_and_new_position_1_3_and_north_orientation(
			DirectionEnum direction) {
		resetMower();
		Assert.assertTrue(mower.move(direction));
		Assert.assertEquals(mower.getPosition(), new Position(1, 3));
		Assert.assertEquals(mower.getOrientation(), new Orientation(
				OrientationEnum.NORTH));

	}

	@Test(dataProviderClass = MowerTestDataProvider.class, dataProvider = "backward_direction")
	public void move_back_must_return_true_and_new_position_1_1_and_north_orientation(
			DirectionEnum direction) {
		resetMower();
		Assert.assertTrue(mower.move(direction));
		Assert.assertEquals(mower.getPosition(), new Position(1, 1));
		Assert.assertEquals(mower.getOrientation(), new Orientation(
				OrientationEnum.NORTH));
	}

	@Test(dataProviderClass = MowerTestDataProvider.class, dataProvider = "rotate_left")
	public void rotate_left_must_return_east(RotationEnum rotation) {
		resetMower();
		mower.rotate(rotation);
		Assert.assertEquals(mower.getPosition(), new Position(1, 2));
		Assert.assertEquals(mower.getOrientation(), new Orientation(
				OrientationEnum.WEST));
	}

	@Test(dataProviderClass = MowerTestDataProvider.class, dataProvider = "rotate_right")
	public void rotate_right_must_return_east(RotationEnum rotation) {
		resetMower();
		mower.rotate(rotation);
		Assert.assertEquals(mower.getPosition(), new Position(1, 2));
		Assert.assertEquals(mower.getOrientation(), new Orientation(
				OrientationEnum.EAST));
	}

	@Test
	public void start_a_not_started_mower() {
		try {
			if (mower.isStarted())
				mower.stop();
			mower.start();
		} catch (EngineException e) {
		}
		Assert.assertEquals(mower.isStarted(), true);
	}

	@Test
	public void start_a_already_started_mower_must_throw_engine_exception() {

		try {
			if (!mower.isStarted())
				mower.start();
			mower.start();
		} catch (EngineException e) {
			Assert.assertEquals(e.getMessage(), "Engine already started");
		}
	}

	@Test
	public void stop_a_not_stpped_mower() {
		try {
			if (!mower.isStarted())
				mower.start();
			mower.stop();
			Assert.assertEquals(mower.isStarted(), false);
		} catch (EngineException e) {
		}
	}

	@Test
	public void stop_a_already_stoped_mower_must_must_throw_engine_exception() {
		try {
			if (mower.isStarted())
				mower.stop();
			mower.stop();
		} catch (EngineException e) {
			Assert.assertEquals(e.getMessage(), "Engine already stopped");
		}
	}

}
