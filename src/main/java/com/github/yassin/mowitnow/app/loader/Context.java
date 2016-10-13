package com.github.yassin.mowitnow.app.loader;

import java.util.List;
import java.util.TreeMap;

import com.github.yassin.mowitnow.business.domain.Lawn;
import com.github.yassin.mowitnow.business.domain.Mower;

/**
 * Context of application defined by : - Lawn : define ShapeLimit - Mowers :
 * list of mowers and they command to execute
 * 
 * @author Yassin
 *
 */
public class Context {

	private Lawn lawn;
	private TreeMap<Mower, List<MowerCommand>> mowers;

	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public TreeMap<Mower, List<MowerCommand>> getMowers() {
		return mowers;
	}

	public void setMowers(TreeMap<Mower, List<MowerCommand>> mowers) {
		this.mowers = mowers;
	}

}
