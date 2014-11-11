package com.mediaiq.gol.common;

public interface NextGenerationPatternGenerator {

	/**
	 * @param generation
	 * @param x
	 * @param y
	 * @return The number of alive neighbors for a given cell[x][y] in generation.
	 */
	int getLiveNeighbors(GenerationPattern generation, int row, int col);

	/**
	 * @param currentGeneration
	 * @return The next generation after evaluating based on the rules of the game
	 */
	 GenerationPattern createNextGeneration(GenerationPattern currentGeneration);
}
