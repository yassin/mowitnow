package com.github.yassin.mowitnow.business.domain;

import org.apache.log4j.Logger;

import com.github.yassin.mowitnow.business.Orientation;
import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.api.Engine;
import com.github.yassin.mowitnow.business.api.MovableElement;
import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;
import com.github.yassin.mowitnow.exceptions.EngineException;

/**
 * Mower is movable element
 * 
 * @author Yassin
 *
 */
public class Mower implements MovableElement, Engine {

	private Logger log = Logger.getLogger(MowerTest.class);
	private Position currentPosition;
	private Orientation currentOrientation;
	private Lawn lawn;
	private boolean engineStarted = false;

	public Mower(Position currentPosition, Orientation currentOrientation,
			Lawn lawn) {
		super();
		this.currentPosition = currentPosition;
		this.currentOrientation = currentOrientation;
		this.lawn = lawn;
	}

	public boolean move(DirectionEnum direction) {
		Position newPosition = currentPosition.next(direction, getOrientation()
				.getOrientationEnum());
		if (lawn.canMove(newPosition)) {
			this.currentPosition = newPosition;
			return true;
		}
		return false;
	}

	public void rotate(RotationEnum rotation) {
		this.currentOrientation = currentOrientation.rotate(rotation);
	}

	public Position getPosition() {
		return currentPosition;
	}

	public Orientation getOrientation() {
		return currentOrientation;
	}

	public void setCurrentPosition(Position currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void setCurrentOrientation(Orientation currentOrientation) {
		this.currentOrientation = currentOrientation;
	}

	public void start() throws EngineException {
		if(isStarted()){
			throw new EngineException("Engine already started");
		}
		engineStarted = true ;
		log.info("Engine Started ok");
	}

	public void stop() throws EngineException {
		if(!isStarted()){
			throw new EngineException("Engine already stopped");
		}
		engineStarted = false ;
		log.info("Engine Stopped ok");
	}

	public boolean isStarted() {
		return engineStarted;
	}

}
