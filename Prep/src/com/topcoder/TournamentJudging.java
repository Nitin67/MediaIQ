package com.topcoder;

public class TournamentJudging {
	int getPoints(int []rawScores,int []conversionFactor)
	{
		int sum=0;
		for(int i=0;i<rawScores.length;i++)
		{
			sum+=Math.round( (float)((float)rawScores[i]/(float)conversionFactor[i]));
		}
		return sum;
	}

}
