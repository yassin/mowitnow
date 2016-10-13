package com.github.yassin.mowitnow.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.exceptions.ParsingException;

public class AppTest {

	@Test
	public void appTest_run_usage_ko_expected_0() {
		String s[] = new String[1];
		try {
			Assert.assertEquals(App.run(s),0);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void appTest_run_usage_ok_expected_1() {
		String s[] = new String[1];
		s[0] = "src/test/resources/testFile_OK.txt";
		try {
			Assert.assertEquals(App.run(s),1);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}
}
