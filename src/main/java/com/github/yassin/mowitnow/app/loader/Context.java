package com.github.yassin.mowitnow.app.loader;

import java.util.HashMap;
import java.util.List;

import com.github.yassin.mowitnow.business.domain.Lawn;
import com.github.yassin.mowitnow.business.domain.Mower;

/**
 * Context of application defined by :
 * 		- Lawn : define ShapeLimit
 * 		- Mowers : list of mowers and they command to execute
 *  
 * @author Yassin
 *
 */
public class Context {

	private Lawn lawn;
	private HashMap<Mower, List<MowerCommand>> mowers ;
	
	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public HashMap<Mower, List<MowerCommand>> getMowers() {
		return mowers;
	}

	public void setMowers(HashMap<Mower, List<MowerCommand>> mowers) {
		this.mowers = mowers;
	}

}
