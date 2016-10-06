package com.github.yassin.mowitnow.api;

import com.github.yassin.mowitnow.business.domain.Position;

/**
 *  a ShapeLimit define à limit of Shape.
 * @author Yassin
 *
 */
public interface ShapeLimit {

	
	/**
	 * Return true if the movable object can move to Position
	 */
	public boolean canMove(Position position);
}
