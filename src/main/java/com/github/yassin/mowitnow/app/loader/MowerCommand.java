package com.github.yassin.mowitnow.app.loader;

import java.util.ArrayList;
import java.util.List;

import com.github.yassin.mowitnow.business.domain.Mower;
import com.github.yassin.mowitnow.business.enums.DirectionEnum;
import com.github.yassin.mowitnow.business.enums.RotationEnum;
import com.github.yassin.mowitnow.exceptions.ParsingException;

/**
 * MowerCommand define command that can be executed by Mower
 * 
 * @author Yassin
 */
public enum MowerCommand {

	ROTATE_LEFT('G'), ROTATE_RIGHT('D'), FORWARD('A');

	private char code;

	private MowerCommand(char code) {
		this.code = code;
	}

	public char getCode() {
		return this.code;
	}

	/**
	 * Execute a MowerCommand on Mower
	 * 
	 * @param mower
	 * @param command
	 */
	public static void execute(Mower mower, MowerCommand command) {

		switch (command) {
		case ROTATE_LEFT:
			mower.rotate(RotationEnum.LEFT);
			break;
		case ROTATE_RIGHT:
			mower.rotate(RotationEnum.RIGHT);
			break;
		case FORWARD:
			mower.move(DirectionEnum.FORWARD);
			break;
		default:
			throw new IllegalArgumentException("Mower command unsupported: "
					+ command);
		}

	}

	/**
	 * Parse a command from char representation
	 *
	 * @param c
	 * @return the mower command
	 * @throws ParsingException
	 *             if unknown command
	 */
	public static MowerCommand parseCommand(char c) throws ParsingException {

		for (MowerCommand cmd : values()) {
			if (cmd.getCode() == c) {
				return cmd;
			}
		}

		throw new ParsingException("Parse MowerCommand error: " + c);
	}

	/**
	 * Parse commands from String representation
	 *
	 * @param s
	 * @return a list of commands
	 * @throws ParsingException
	 *             if unknown command
	 */
	public static List<MowerCommand> parseCommands(String s)
			throws ParsingException {

		List<MowerCommand> commands = new ArrayList<MowerCommand>();

		if (s != null && s.length() > 0) {

			for (char c : s.toCharArray()) {
				commands.add(parseCommand(c));
			}

			return commands;
		}

		throw new ParsingException("Parse MowerCommands error: " + s);
	}

}
