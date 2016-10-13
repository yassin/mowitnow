package com.github.yassin.mowitnow.app.loader;

import org.testng.annotations.DataProvider;

import com.github.yassin.mowitnow.business.Orientation;
import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.domain.Lawn;
import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;

/**
 * FileParser Test Data Provider
 * 
 * @author Yassin
 *
 */
public class MowerCommandTestDataProvider {


	@DataProvider(name = "mower_2_3_N_forward")
	public static Object[][] mower_2_3_N_forward() {
		Orientation currentOrientation = new Orientation(OrientationEnum.NORTH);
		Position topRight = new Position(5, 5);
		Lawn lawn = new Lawn(topRight );
		Position currentPosition = new Position(2, 3);
		Mower mower = new Mower(currentPosition, currentOrientation, lawn);
		
		return new Object[][] { {mower, MowerCommand.FORWARD } };
	}
	
	@DataProvider(name = "mower_2_3_N_rotate_left")
	public static Object[][] mower_2_3_N_rotate_left() {
		Orientation currentOrientation = new Orientation(OrientationEnum.NORTH);
		Position topRight = new Position(5, 5);
		Lawn lawn = new Lawn(topRight );
		Position currentPosition = new Position(2, 3);
		Mower mower = new Mower(currentPosition, currentOrientation, lawn);
		
		return new Object[][] { {mower, MowerCommand.ROTATE_LEFT } };
	}
	
	@DataProvider(name = "mower_2_3_N_rotate_right")
	public static Object[][] mower_2_3_N_rotate_right() {
		Orientation currentOrientation = new Orientation(OrientationEnum.NORTH);
		Position topRight = new Position(5, 5);
		Lawn lawn = new Lawn(topRight );
		Position currentPosition = new Position(2, 3);
		Mower mower = new Mower(currentPosition, currentOrientation, lawn);
		
		return new Object[][] { {mower, MowerCommand.ROTATE_RIGHT } };
	}
	
	@DataProvider(name = "forward")
	public static Object[][] forward() {
		return new Object[][] { {'A' } };
	}
	
	@DataProvider(name = "rotate_left")
	public static Object[][] rotate_left() {
		return new Object[][] { {'G' } };
	}
	
	@DataProvider(name = "rotate_right")
	public static Object[][] rotate_right() {
		return new Object[][] { {'D' } };
	}
	
	@DataProvider(name = "fail_char_command")
	public static Object[][] fail_char_command() {
		return new Object[][] { {'E' } };
	}
	
	@DataProvider(name = "forward_forward_rotate_left_forward_rotate_right")
	public static Object[][] forward_forward_rotate_left_forward_rotate_right() {
		return new Object[][] { {"AAGAD" } };
	}
	
	@DataProvider(name = "fail_string_command")
	public static Object[][] fail_string_command() {
		return new Object[][] { {null } };
	}
}
