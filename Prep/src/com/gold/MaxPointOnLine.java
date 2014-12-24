package com.gold;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointOnLine {
	
	public int maxPointsOnLine(List<Point> points)
	{
		int ans=0;
		Map<Line,Integer> map=new HashMap<Line, Integer>();
		
		for(Point p1:points)
		{
			int same=0;
			int max=0;
			map.clear();
			for(Point p2:points)
			{
				if(p1.x==p2.x && p1.y==p2.y)
					++same;
				else
				{
					Line line=new Line(p1.x-p2.x, p1.y-p2.y);
					int count=0;
					if(map.containsKey(line))
					{
						 count=map.get(line);
						map.put(line, count+1);
					}
					else{
						map.put(line, 1);
						count++;
					}
					
					max=Math.max(max,count);
				}
				ans=Math.max(ans, max+same);
			}
			return ans;
		}
		return ans;
		
		
	}

	
	
}
