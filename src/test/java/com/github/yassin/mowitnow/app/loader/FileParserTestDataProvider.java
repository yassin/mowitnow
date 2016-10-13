package com.github.yassin.mowitnow.app.loader;

import org.testng.annotations.DataProvider;

/**
 * FileParser Test Data Provider
 * 
 * @author Yassin
 *
 */
public class FileParserTestDataProvider {


	@DataProvider(name = "good_file")
	public static Object[][] good_file() {
		return new Object[][] { { "src/test/resources/testFile_OK.txt" } };
	}
	
	@DataProvider(name = "bad_file")
	public static Object[][] bad_file() {
		return new Object[][] { { "src/test/resources/testFile_KO.txt" } };
	}
	
	@DataProvider(name = "file_not_exist")
	public static Object[][] file_not_exist() {
		return new Object[][] { { "test.txt" } };
	}
}
