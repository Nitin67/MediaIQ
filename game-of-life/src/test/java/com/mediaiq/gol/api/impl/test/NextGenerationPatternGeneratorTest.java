package com.mediaiq.gol.api.impl.test;

import static org.junit.Assert.*;


import org.junit.Test;

import com.mediaiq.gol.api.impl.NextGenerationPatternGeneratorImpl;
import com.mediaiq.gol.common.GenerationPattern;
import com.mediaiq.gol.common.NextGenerationPatternGenerator;

public class NextGenerationPatternGeneratorTest {


	@Test
	public void runTest1(){
		NextGenerationPatternGenerator generationPatternGenerator = new NextGenerationPatternGeneratorImpl();
		GenerationPattern generation = new GenerationPattern(2,2);
		char[][] input = { {'X', 'X'}, {'X', 'X'}};
		generation.setSeed(input);
		
		GenerationPattern nextGenerationPattern = new GenerationPattern(2, 2);
		char[][] output = { {'X', 'X'}, {'X', 'X'}};
		nextGenerationPattern.setSeed(output);
		GenerationPattern nextGenerationPatternGenerated=generationPatternGenerator.createNextGeneration(generation);
		assertEquals(nextGenerationPattern, nextGenerationPatternGenerated);
	}

	@Test
	public void runTest2(){
		NextGenerationPatternGenerator generationPatternGenerator = new NextGenerationPatternGeneratorImpl();
		GenerationPattern generation = new GenerationPattern(3,3);
		char[][] input =  { {'-', 'X', '-'}, {'-', 'X', '-'}, {'-', 'X', '-'}};
		generation.setSeed(input);
		
		GenerationPattern nextGenerationPattern = new GenerationPattern(3, 3);
		char[][] output = {{'-', '-', '-'},{'X', 'X', 'X'}, {'-', '-', '-'}};
		nextGenerationPattern.setSeed(output);
		
		GenerationPattern nextGenerationPatternGenerated=generationPatternGenerator.createNextGeneration(generation);
		assertEquals(nextGenerationPattern, nextGenerationPatternGenerated);

	}
	@Test
	public void runTest3(){
		NextGenerationPatternGenerator generationPatternGenerator = new NextGenerationPatternGeneratorImpl();
		GenerationPattern generation = new GenerationPattern(3,3);
		char[][] input = { {'-', 'X', '-'}, {'-', '-', 'X'}, {'X', 'X', 'X'}};
		generation.setSeed(input);
		
		GenerationPattern nextGenerationPattern = new GenerationPattern(3, 3);
		char[][] output = {{'-', '-', '-'},{'X', '-', 'X'}, {'-', 'X', 'X'}};
		nextGenerationPattern.setSeed(output);
		GenerationPattern nextGenerationPatternGenerated=generationPatternGenerator.createNextGeneration(generation);
		assertEquals(nextGenerationPattern, nextGenerationPatternGenerated);

	}
	@Test
	public void runTest4(){
		NextGenerationPatternGenerator generationPatternGenerator = new NextGenerationPatternGeneratorImpl();
		GenerationPattern generation = new GenerationPattern(4,3);
		char[][] input = { {'-', 'X', '-'}, {'X', 'X', 'X'}, {'X', '-', 'X'}, {'-', 'X', '-'}};
		generation.setSeed(input);
		
		GenerationPattern nextGenerationPattern = new GenerationPattern(4, 3);
		char[][] output = {{'X', 'X', 'X'},{'X', '-', 'X'}, {'X', '-', 'X'}, {'-', 'X', '-'}};
		nextGenerationPattern.setSeed(output);
		GenerationPattern nextGenerationPatternGenerated=generationPatternGenerator.createNextGeneration(generation);
		assertEquals(nextGenerationPattern, nextGenerationPatternGenerated);
		
	}
	
}
