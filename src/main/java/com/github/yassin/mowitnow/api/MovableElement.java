package com.github.yassin.mowitnow.api;

import com.github.yassin.mowitnow.business.domain.Direction;
import com.github.yassin.mowitnow.business.domain.Orientation;
import com.github.yassin.mowitnow.business.domain.Position;
import com.github.yassin.mowitnow.business.domain.Rotation;

/**
 * a MovableElement define movable object
 * 
 * @author Yassin
 *
 */
public interface MovableElement {

	/**
	 * Position of movableElement
	 */
	Position position = new Position();
	
	/**
	 * Orientation of movableElement
	 */
	Orientation orientation = new Orientation();
	/**
	 * move to direction
	 * 
	 * @param direction
	 * @return
	 */
	boolean move(Direction direction);

	/**
	 * rotate to à new orientation
	 * 
	 * @param rotation
	 */
	void rotate(Rotation rotation);

	/**
	 * get a current Position
	 * @return Position
	 */
	Position getPosition();

	/**
	 * get a current Orientation
	 * @return Orientation
	 */
	Orientation getOrientation();
}
