package com.github.yassin.mowitnow.app.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * CommandLancher define a luncher of command on context
 * 
 * @author Yassin
 *
 */
public class MowersRunnerTest {

	MowersRunner mowerRunner = new MowersRunner();	
	@Test
	public void run_result_OK() {
		String s = "src/test/resources/testFile_OK.txt";
		try {
			mowerRunner.run(s);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void run_FileNotFoundException() {
		String s = "src/test/resources/testFile_OK.txt";
		try {
			mowerRunner.run(s);
		} catch (FileNotFoundException e) {
			Assert.assertEquals(e.getMessage(), s + " (Le fichier spécifié est introuvable)");
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void run_ParsingException() {
		String s = "src/test/resources/testFile_OK.txt";
		try {
			mowerRunner.run(s);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.assertEquals(e.getMessage(), "Parsing position error of line :5 5 5 5");
		} catch (IOException e) {
			Assert.fail();
		}
	}
	
	@Test
	public void run_expected_mower_out_limit() {
		String s = "src/test/resources/testFile_out_limit.txt";
		try {
			mowerRunner.run(s);
			Assert.assertEquals(mowerRunner.getContext().getMowers().entrySet().iterator().next().getKey().getPosition().getX(), 6);
			Assert.assertEquals(mowerRunner.getContext().getMowers().entrySet().iterator().next().getKey().getPosition().getY(), 4);
			Assert.assertEquals(mowerRunner.getContext().getMowers().entrySet().iterator().next().getKey().getOrientation().getOrientationEnum(), OrientationEnum.NORTH);
			
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
