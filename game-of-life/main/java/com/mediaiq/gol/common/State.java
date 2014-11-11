package com.mediaiq.gol.common;

public enum State {

	ALIVE('X'),DEAD('-');
	
	private final char stateValue;
	
	State(char state) {
		this.stateValue=state;
		// TODO Auto-generated constructor stub
	}
	
	public char getStateValue() {
		return stateValue;
	}
	
	public static State getStateFromConstant(String state)
	{
		
		return State.valueOf(state);
	}
}
