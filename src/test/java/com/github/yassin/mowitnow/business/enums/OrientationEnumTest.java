package com.github.yassin.mowitnow.business.enums;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * OrientationEnum test
 * 
 * @author Yassin
 *
 */
public class OrientationEnumTest {


	@Test(dataProviderClass = OrientationEnumTestDataProvider.class , dataProvider = "north")
	public void parseOrientation_must_return_north(String c) {
		try {
			OrientationEnum result = OrientationEnum.parseOrientation(c);
			Assert.assertEquals(result.getOrienationType(),1);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = OrientationEnumTestDataProvider.class , dataProvider = "east")
	public void parseOrientation_must_return_east(String c) {
		try {
			OrientationEnum result = OrientationEnum.parseOrientation(c);
			Assert.assertEquals(result.getOrienationType(),2);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = OrientationEnumTestDataProvider.class , dataProvider = "west")
	public void parseOrientation_must_return_west(String c) {
		try {
			OrientationEnum result = OrientationEnum.parseOrientation(c);
			Assert.assertEquals(result.getOrienationType(),4);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = OrientationEnumTestDataProvider.class , dataProvider = "south")
	public void parseOrientation_must_return_south(String c) {
		try {
			OrientationEnum result = OrientationEnum.parseOrientation(c);
			Assert.assertEquals(result.getOrienationType(),3);
		} catch (ParsingException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = OrientationEnumTestDataProvider.class , dataProvider = "empty")
	public void parseOrientation_must_throw_exception(String c) {
		try {
			OrientationEnum.parseOrientation(c);
			Assert.fail();
		} catch (ParsingException e) {
			Assert.assertEquals(e.getMessage(), "Parse orientation error: "+ c);
		}
	}
}
