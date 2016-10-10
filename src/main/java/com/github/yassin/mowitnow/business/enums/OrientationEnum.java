package com.github.yassin.mowitnow.business.enums;

/**
 * OrientationEnum define orientation of movable 
 * 		   N 1
 * 	 W 4		 E 2
 * 		   S 3
 * 
 * @author Yassin
 *
 */
public enum OrientationEnum {
	
	NORTH(1),
	EAST(2),
	SOUTH(3),
	WEST(4);

	private int type;

	private OrientationEnum(int type) {
		this.type = type;
	}

	public int getOrienationType() {
		return this.type;
	}
	
	public void setOrienationType(int type) {
		this.type = type;
	}
}
