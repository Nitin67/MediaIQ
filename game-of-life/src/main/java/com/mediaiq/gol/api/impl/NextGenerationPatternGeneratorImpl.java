package com.mediaiq.gol.api.impl;


import com.mediaiq.gol.common.GenerationPattern;
import com.mediaiq.gol.common.NextGenerationPatternGenerator;


public class NextGenerationPatternGeneratorImpl implements NextGenerationPatternGenerator {
	
	@Override
	public int getLiveNeighbors(GenerationPattern generation, int row, int col) {
	
		int liveCount=0;
		if(row>=generation.getRow()|| row<0)
				return -1;
		if(col>=generation.getRow() || col<0)
				return -1;
		if(row-1>=0)
		{
			if(col-1>=0 && generation.isAlive(row-1, col-1) )
			{
				liveCount++;
			}
			if( generation.isAlive(row-1, col))
				liveCount++;
			if(col+1<generation.getCol()  && 	generation.isAlive(row-1, col+1))
			{
				liveCount++;
			}
			
		}
		if(row+1<generation.getRow())
		{
			if(col-1>=0 && generation.isAlive(row+1, col-1))
			{
				liveCount++;
			}
			if(generation.isAlive(row+1, col))
				liveCount++;
			if(col+1<generation.getCol() && generation.isAlive(row+1, col+1))
			{
				liveCount++;
			}
		}
		if(col+1<generation.getCol() && generation.isAlive(row, col+1) )
		{
			liveCount++;
		}
		if(col-1>=0 && generation.isAlive(row, col-1))
		{
			liveCount++;
		}
		return liveCount;
	}

	@Override
	public GenerationPattern createNextGeneration(
			GenerationPattern currentGenerationPattern) {
		if(currentGenerationPattern==null)
			return null;
		GenerationPattern nextGenerationPattern=new GenerationPattern(currentGenerationPattern.getRow(), currentGenerationPattern.getCol());
		
		for(int i=0;i<currentGenerationPattern.getRow();i++)
		{
			for(int j=0;j<currentGenerationPattern.getCol();j++)
			{
				
				int liveNeighboursCount=getLiveNeighbors(currentGenerationPattern, i, j);
				
				if(currentGenerationPattern.isAlive(i, j))
				{
					if(liveNeighboursCount>=2 && liveNeighboursCount<=3)
						nextGenerationPattern.setCellAlive(i, j);
					else
						nextGenerationPattern.setCellDead(i, j);
				}
				else 
				{
					if(liveNeighboursCount==3)
						nextGenerationPattern.setCellAlive(i, j);
					else
						nextGenerationPattern.setCellDead(i, j);
				}
			}
		}
		
		return nextGenerationPattern;
	}

}
