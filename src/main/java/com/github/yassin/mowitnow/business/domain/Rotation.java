package com.github.yassin.mowitnow.business.domain;

/**
 * enum define a type of Rotation.
 *  
 * @author Yassin
 */
public enum Rotation {

	RIGHT(1),
	LEFT(-1);

	private int type;

	private Rotation(int type) {
		this.type = type;
	}

	public int getType() {
		return this.type;
	}
}
