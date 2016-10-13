package com.github.yassin.mowitnow.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.github.yassin.mowitnow.app.runner.MowersRunner;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * Main Class to Start Demonstration
 *
 */
public class App {
	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) throws FileNotFoundException,
			ParsingException, IOException {
		// Usage
		if (args.length != 1 || args[0] == null) {
			log.info("Usage : Mowitnow.jar <filePath>");
			return;
		}

		String filePath = args[0];

		MowersRunner runner = new MowersRunner();
		runner.run(filePath);
	}
}
