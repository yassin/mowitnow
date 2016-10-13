package com.github.yassin.mowitnow.business.api;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.github.yassin.mowitnow.exceptions.ParsingException;


/**
 * Run command on movable element 
 * @author Yassin
 *
 */
public interface Runner {

	/**
	 *  Run command on movable element
	 * @param filePath of file containing command
	 * @throws FileNotFoundException
	 * @throws ParsingException
	 * @throws IOException
	 */
	void run(String filePath) throws FileNotFoundException, ParsingException, IOException;
}
