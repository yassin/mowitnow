package com.github.yassin.mowitnow.business.domain;

/**
 * Direction define a direction ( go straight Or go back )
 * @author Yassin
 *
 */
public enum Direction {

	FORWARD(1),
	BACKWARD(-1);

    private int type;

    Direction(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
