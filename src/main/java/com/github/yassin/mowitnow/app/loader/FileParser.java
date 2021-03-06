package com.github.yassin.mowitnow.app.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import com.github.yassin.mowitnow.business.Orientation;
import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.domain.Lawn;
import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * FileParser allow to Load Context of App
 * 
 * @author Yassin
 *
 */
public class FileParser {

	/**
	 * load context from file
	 * 
	 * @return context
	 * @throws FileNotFoundException
	 */
	public static Context loadContextFromFile(String filePath)
			throws FileNotFoundException, ParsingException, IOException {

		Context contextResult = new Context();

		// sort Mower
		Comparator<Mower> comparator = new Comparator<Mower>() {

			public int compare(Mower o1, Mower o2) {
				if (o1.getId() < o2.getId())
					return -1;
				else if (o1.getId() > o2.getId())
					return 1;
				else if (o1.getId() == o2.getId())
					return 1;
				return 2;
			}
		};

		TreeMap<Mower, List<MowerCommand>> mowers = new TreeMap<Mower, List<MowerCommand>>(comparator);
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = br.readLine();
		// first line define limit Lawn
		Lawn lawn = new Lawn(Position.parsePositionFromString(line));
		contextResult.setLawn(lawn);
		line = br.readLine();
		// load Mowers
		int mowerId = 1;
		while (line != null) {
			String orientation = line.substring(line.length() - 1,
					line.length());
			String position = line.substring(0, line.length() - 2);
			Orientation currentOrientation = new Orientation(
					OrientationEnum.parseOrientation(orientation));
			Position currentPosition = Position
					.parsePositionFromString(position);

			Mower mower = new Mower(currentPosition, currentOrientation, lawn);

			mower.setId(mowerId);
			line = br.readLine();
			List<MowerCommand> mowersComamnd = MowerCommand.parseCommands(line);
			mowers.put(mower, mowersComamnd);
			line = br.readLine();
			mowerId++;
		}
		br.close();
		contextResult.setMowers(mowers);
		return contextResult;

	}
}
