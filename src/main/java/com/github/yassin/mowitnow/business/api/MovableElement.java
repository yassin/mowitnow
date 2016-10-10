package com.github.yassin.mowitnow.business.api;

import com.github.yassin.mowitnow.business.Orientation;
import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;

/**
 * a MovableElement define movable object
 * 
 * @author Yassin
 *
 */
public interface MovableElement {

	/**
	 * move to direction
	 * true if it can
	 * @param direction
	 * @return boolean
	 */
	boolean move(DirectionEnum direction);

	/**
	 * rotate to a new orientation using rotation
	 * 
	 * @param rotation
	 */
	void rotate(RotationEnum rotation);

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
