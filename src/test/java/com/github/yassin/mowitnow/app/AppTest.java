package com.github.yassin.mowitnow.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.exceptions.ParsingException;

public class AppTest {

	@Test
	public void appTest_result_OK() {
		String s[] = new String[1];
		s[0] = "src/test/resources/testFile_OK.txt";
		try {
			App.main(s);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void appTest_FileNotFoundException() {
		String s[] = new String[1];
		s[0] = "test.txt";
		try {
			App.main(s);
		} catch (FileNotFoundException e) {
			Assert.assertEquals(e.getMessage(), s[0] + " (Le fichier spécifié est introuvable)");
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}

	@Test
	public void appTest_ParsingException() {
		String s[] = new String[1];
		s[0] = "src/test/resources/testFile_KO.txt";
		try {
			App.main(s);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.assertEquals(e.getMessage(), "Parsing position error of line :5 5 5 5");
		} catch (IOException e) {
			Assert.fail();
		}
	}

}
