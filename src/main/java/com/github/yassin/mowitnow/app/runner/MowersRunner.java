package com.github.yassin.mowitnow.app.runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.github.yassin.mowitnow.app.loader.Context;
import com.github.yassin.mowitnow.app.loader.FileParser;
import com.github.yassin.mowitnow.app.loader.MowerCommand;
import com.github.yassin.mowitnow.business.api.Runner;
import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * CommandLancher define a luncher of command on context
 * 
 * @author Yassin
 *
 */
public class MowersRunner implements Runner {
	Logger log = Logger.getLogger(MowersRunner.class);

	public void run(String filePath) throws FileNotFoundException,
			ParsingException, IOException {
		// load context
		Context context = FileParser.loadContextFromFile(filePath);

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
		TreeMap<Mower, List<MowerCommand>> sortedMap = new TreeMap<Mower, List<MowerCommand>>(comparator);
		sortedMap.putAll(context.getMowers());
		for (Map.Entry<Mower, List<MowerCommand>> iterable : sortedMap.entrySet()) {
			Mower mower = iterable.getKey();
			List<MowerCommand> mowerCommands = iterable.getValue();
			for (MowerCommand mowerCommand : mowerCommands) {
				MowerCommand.execute(mower, mowerCommand);
			}
			log.info(mower.toString());
		}
	}

}
