package com.github.yassin.mowitnow.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

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
		int x = this.x;
		int y = this.y;
		switch (orientation.getOrienationType()) {
		case 1:
			y = y + direction.getType();
			break;
		case 2:
			x = x + direction.getType();
			break;
		case 3:
			y = y - direction.getType();
			break;
		case 4:
			x = x - direction.getType();
			break;
		}
		return new Position(x, y);
	}

	/**
	 * Return Position from String (5 5)
	 * 
	 * @throws ParsingException
	 */
	public static Position parsePositionFromString(String line)
			throws ParsingException {

		Pattern paternPositionMatcher = Pattern.compile("^(\\d+)[ ](\\d+)$");
		Matcher m = paternPositionMatcher.matcher(line);
		if (m.matches()) {
			return new Position(Integer.parseInt(m.group(1)),
					Integer.parseInt(m.group(2)));
		}
		throw new ParsingException("Parsing position error of line :"+line);
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
