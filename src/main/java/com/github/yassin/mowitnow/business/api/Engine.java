package com.github.yassin.mowitnow.business.api;

import com.github.yassin.mowitnow.exceptions.EngineException;

/**
 * Engine of movable object for starting and stopping
 * 
 * @author Yassin
 *
 */
public interface Engine {

	/**
	 * true if the engine Starting well
	 * @return boolean
	 */
	void start() throws EngineException;

	/**
	 * true if the engine stopping well
	 * @return boolean
	 */
	void stop() throws EngineException;
	
	/**
	 * true if the engine is started
	 * @return boolean
	 */
	boolean isStarted();
}
