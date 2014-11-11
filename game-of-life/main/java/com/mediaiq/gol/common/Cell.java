package com.mediaiq.gol.common;

public class Cell {

	private State state;
	
	public Cell(State state) {
		this.state=state;
	}

	public Cell(char c)
	{
		if(c=='X')
			this.state=State.ALIVE;
		else if(c=='-')
			this.state=State.DEAD;
	}
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Cell [state=" + state + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.state == ((Cell)obj).state)
			return true;
		else
			return false;
		
		
	}
}
