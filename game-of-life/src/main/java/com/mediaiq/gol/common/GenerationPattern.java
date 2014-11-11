package com.mediaiq.gol.common;

import java.util.Arrays;

public class GenerationPattern {

	private Cell[][] seed;
	private final int row;
	private final int col;

	public  GenerationPattern(int row, int col) {
	
		this.row=row;
		this.col=col;
		seed = new Cell[row][col];
	}

	public Cell[][] getSeed() {
		return seed;
	}

	public void setSeed(Cell[][] seed) {
		this.seed = seed;
	}
	public void setSeed(char[][] seedVal) {
		Cell[][] seedCpy = new Cell[seedVal.length][];
		for(int i=0; i < seedVal.length; i++){
			seedCpy[i] = new Cell[seedVal[i].length];
			for(int j=0; j < seedVal[i].length; j++){
				seedCpy[i][j] = new Cell(seedVal[i][j]);
			}
		}
		this.seed = seedCpy; 
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		result = prime * result + Arrays.hashCode(seed);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
	
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenerationPattern other = (GenerationPattern) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		if (!Arrays.deepEquals(seed, other.seed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GenerationPattern [seed=" + Arrays.toString(seed) + "]";
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public boolean isAlive(int r,int c)
	{
		return this.seed[r][c].getState().compareTo(State.ALIVE)==0;
	}
	
	public void setCellAlive(int i,int j)
	{
		if(seed!=null && i<row && j<col && i>=0 && j>=0)
		{
			seed[i][j]=new Cell(State.ALIVE);
		}
	}
	public void setCellDead(int i,int j)
	{
		if(seed!=null && i<row && j<col && i>=0 && j>=0)
		{
			seed[i][j]=new Cell(State.DEAD);
		}
	}
	
}
