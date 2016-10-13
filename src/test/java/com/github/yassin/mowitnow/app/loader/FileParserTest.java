package com.github.yassin.mowitnow.app.loader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * FileParser Test
 * 
 * @author Yassin
 *
 */
public class FileParserTest {

	FileParser fileParser;

	@BeforeTest
	public void setUp() {
		fileParser = new FileParser();
	}

	@Test(dataProviderClass = FileParserTestDataProvider.class, dataProvider = "good_file")
	public void loadContextFromFile_expect_context_load_ok_and_result_ok(String filePath) {
		try {
			// test
			Context context = FileParser.loadContextFromFile(filePath);
			// expected
			int axisX[] = new int[2];
			int axisY[] = new int[2];
			OrientationEnum expectedOrientation[] = new OrientationEnum[2];
			int expectedCommandsSize[] = new int[2];
			axisX[0] = 1;
			axisX[1] = 3;
			axisY[0] = 2;
			axisY[1] = 3;
			expectedOrientation[0] = OrientationEnum.NORTH;
			expectedOrientation[1] = OrientationEnum.EAST;
			expectedCommandsSize[0] = 9;
			expectedCommandsSize[1] = 10;

			// test
			Assert.assertEquals(context.getLawn().getTopRight(), new Position(
					5, 5));
			Assert.assertEquals(context.getMowers().size(), 2);
			int i = 0;
			
						
			for (Map.Entry<Mower, List<MowerCommand>> entry : context.getMowers().entrySet()) {
				Mower mower = entry.getKey();
				List<MowerCommand> mowerCommands = entry.getValue();
				Assert.assertEquals(
						mower.getOrientation().getOrientationEnum(),
						expectedOrientation[i]);
				Assert.assertEquals(mower.getPosition().getX(), axisX[i]);
				Assert.assertEquals(mower.getPosition().getY(), axisY[i]);
				Assert.assertEquals(mowerCommands.size(),
						expectedCommandsSize[i]);
				i++;
			}
			Assert.assertEquals(context.getLawn().getTopRight(), new Position(
					5, 5));
			Assert.assertEquals(context.getMowers().size(), 2);
		} catch (FileNotFoundException e) {
			Assert.fail();
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}

	}

	@Test(dataProviderClass = FileParserTestDataProvider.class, dataProvider = "file_not_exist")
	public void loadContextFromFile_expect_throw_file_not_found_exception(
			String filePath) {
		try {
			FileParser.loadContextFromFile(filePath);
		} catch (FileNotFoundException e) {
			Assert.assertEquals(e.getMessage(), "test.txt (Le fichier spécifié est introuvable)");
		} catch (ParsingException e) {
			Assert.fail();
		} catch (IOException e) {
			Assert.fail();
		}
	}
}
