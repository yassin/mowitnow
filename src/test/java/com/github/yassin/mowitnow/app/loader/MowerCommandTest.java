package com.github.yassin.mowitnow.app.loader;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * MowerCommand test
 * 
 * @author Yassin
 */
public class MowerCommandTest {

	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "mower_2_3_N_forward")
	public void execute_mower_2_3_N_forward_return_2_4_N(Mower mower, MowerCommand command) {
		MowerCommand.execute(mower, command);
		Assert.assertEquals(mower.getOrientation().getOrientationEnum(),OrientationEnum.NORTH );
		Assert.assertEquals(mower.getPosition().getX(),2 );
		Assert.assertEquals(mower.getPosition().getY(),4 );
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "mower_2_3_N_rotate_left")
	public void execute_mower_2_3_N_forward_return_2_3_W(Mower mower, MowerCommand command) {
		MowerCommand.execute(mower, command);
		Assert.assertEquals(mower.getOrientation().getOrientationEnum(),OrientationEnum.WEST );
		Assert.assertEquals(mower.getPosition().getX(),2 );
		Assert.assertEquals(mower.getPosition().getY(),3 );
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "mower_2_3_N_rotate_right")
	public void execute_mower_2_3_N_forward_return_2_3_E(Mower mower, MowerCommand command) {
		MowerCommand.execute(mower, command);
		Assert.assertEquals(mower.getOrientation().getOrientationEnum(),OrientationEnum.EAST );
		Assert.assertEquals(mower.getPosition().getX(),2 );
		Assert.assertEquals(mower.getPosition().getY(),3 );
	}

	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "forward")
	public void parseCommand_return_forward(char c) {
		try {
			Assert.assertEquals(MowerCommand.parseCommand(c),MowerCommand.FORWARD);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "rotate_left")
	public void parseCommand_return_rotate_left(char c) {
		try {
			Assert.assertEquals(MowerCommand.parseCommand(c),MowerCommand.ROTATE_LEFT);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "rotate_right")
	public void parseCommand_return_rotate_right(char c) {
		try {
			Assert.assertEquals(MowerCommand.parseCommand(c),MowerCommand.ROTATE_RIGHT);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "fail_char_command")
	public void parseCommand_return_parse_exception(char c) {
		try {
			Assert.assertEquals(MowerCommand.parseCommand(c),MowerCommand.ROTATE_RIGHT);
		} catch (ParsingException e) {
			Assert.assertEquals(e.getMessage(), "Parse MowerCommand error: "+c);
		}
	}

	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "forward_forward_rotate_left_forward_rotate_right")
	public void parseCommands_must_return_forward_forward_rotate_left_forward_rotate_right(String s) {
		try {
			//expected
			MowerCommand mowerCommand_expected[] = new MowerCommand[5];
			mowerCommand_expected[0] = MowerCommand.FORWARD;
			mowerCommand_expected[1] = MowerCommand.FORWARD;
			mowerCommand_expected[2] = MowerCommand.ROTATE_LEFT;
			mowerCommand_expected[3] = MowerCommand.FORWARD;
			mowerCommand_expected[4] = MowerCommand.ROTATE_RIGHT;
			
			//test
			List<MowerCommand> result = MowerCommand.parseCommands(s);
			
			//test
			int i = 0;
			for (MowerCommand mowerCommand : result) {
				Assert.assertEquals(mowerCommand, mowerCommand_expected[i]);
				i++;
			}
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = MowerCommandTestDataProvider.class, dataProvider = "fail_string_command")
	public void parseCommands_must_return_parse_exception(String s) {
		try {
			MowerCommand.parseCommands(s);
		} catch (ParsingException e) {
			Assert.assertEquals(e.getMessage(), "Parse MowerCommands error: "+s);
		}
	}

}
