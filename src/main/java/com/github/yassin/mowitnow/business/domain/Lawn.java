package com.github.yassin.mowitnow.business.domain;

import com.github.yassin.mowitnow.business.Position;
import com.github.yassin.mowitnow.business.api.ShapeLimit;

/**
 * Lawn is rectangular Shape with limit defined by topRight position
 * @author p080152
 *
 */
public class Lawn implements ShapeLimit {

	private Position topRight;
	
	public Lawn(Position topRight) {
		super();
		this.topRight = topRight;
	}
	
	public Lawn(int x,int y) {
		super();
		this.topRight = new Position(x, y);
	}

	public boolean canMove(Position position) {
		if(position.getX() <= topRight.getX() && position.getY() <= topRight.getY() 
				& position.getX()>= 0 & position.getY() >= 0 )
			return true;
		return false;
	}

}
