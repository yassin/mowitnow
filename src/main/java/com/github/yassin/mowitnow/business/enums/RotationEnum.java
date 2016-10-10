package com.github.yassin.mowitnow.business.enums;

/**
 * RotationEnum define a type of Rotation.
 * 
 *     -1           1
 *  <--------    -------->
 *  
 * @author Yassin
 */
public enum RotationEnum {

	RIGHT(1),
	LEFT(-1);

	private int type;

	private RotationEnum(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
}
