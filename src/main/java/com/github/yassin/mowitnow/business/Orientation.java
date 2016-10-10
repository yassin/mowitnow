package com.github.yassin.mowitnow.business;

import com.github.yassin.mowitnow.business.enums.OrientationEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;

/**
 * Orientation of movable EAST, NORTH, WEST, SOUTH
 * 
 * @author Yassin
 *
 */
public class Orientation {

	public Orientation(OrientationEnum orientationEnum) {
		super();
		this.orientationEnum = orientationEnum;
	}

	private OrientationEnum orientationEnum;

	/**
	 * Return a new orientation after a rotation
	 *
	 * @param rotation
	 *            to apply
	 * @return new orientation
	 */
	public Orientation rotate(RotationEnum rotation) {

		if (rotation == null) {
			throw new IllegalArgumentException("Unknown rotation");
		}

		int result = ((this.orientationEnum.getOrienationType() + rotation
				.getType()) % 4);
		if (result == 0)
			result = 4;
		switch (result) {
		case 1:
			this.orientationEnum = OrientationEnum.NORTH;
			break;
		case 2:
			this.orientationEnum = OrientationEnum.EAST;
			;
			break;
		case 3:
			this.orientationEnum = OrientationEnum.SOUTH;
			break;
		case 4:
			this.orientationEnum = OrientationEnum.WEST;
			break;
		}

		return this;

	}

	public OrientationEnum getOrientationEnum() {
		return orientationEnum;
	}

	@Override
	public String toString() {
		return "Orientation = " + this.orientationEnum.name();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orientationEnum == null) ? 0 : orientationEnum.hashCode());
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
		Orientation other = (Orientation) obj;
		if (orientationEnum != other.orientationEnum)
			return false;
		return true;
	}

}
