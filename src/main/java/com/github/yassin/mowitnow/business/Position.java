package com.github.yassin.mowitnow.business;

import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;

/**
 * Position represent a position of movable and offer some method of moving to
 * next position
 * 
 * @author Yassin
 *
 */
public class Position {

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Return the next position after moving
	 *
	 * @param direction
	 * @param orientation
	 * @return new position
	 */
	public Position next(DirectionEnum direction, OrientationEnum orientation) {

		if (direction == null) {
			throw new IllegalArgumentException("Unknown direction: "
					+ direction);
		}
		if (orientation == null) {
			throw new IllegalArgumentException("Unknown orientation: "
					+ orientation);
		}

		switch (orientation.getOrienationType()) {
		case 1:
			this.y = this.y + direction.getType();
			break;
		case 2:
			this.x = this.x + direction.getType();
			break;
		case 3:
			this.y = this.y - direction.getType();
			break;
		case 4:
			this.x = this.x - direction.getType();
			break;
		}
		return this;
	}

	@Override
	public String toString() {
		return "Position{" + "x=" + x + ", y=" + y + '}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
