package com.github.yassin.mowitnow.app.runner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
	
	private Context context;

	public void run(String filePath) throws FileNotFoundException,
			ParsingException, IOException {
		// load context
		 context = FileParser.loadContextFromFile(filePath);

		for (Map.Entry<Mower, List<MowerCommand>> iterable : context.getMowers()
				.entrySet()) {
			Mower mower = iterable.getKey();
			List<MowerCommand> mowerCommands = iterable.getValue();
			if (mower.getPosition().getX() > context.getLawn().getTopRight()
					.getX()
					|| mower.getPosition().getY() > context.getLawn()
							.getTopRight().getY()) {
				log.info(mower.toString()
						+ " is out of Lawn limit no command can be executed");
			} else {
				for (MowerCommand mowerCommand : mowerCommands) {
					MowerCommand.execute(mower, mowerCommand);
				}
				log.info(mower.toString());
			}
		}
	}

	public Context getContext() {
		return context;
	}
	
}
