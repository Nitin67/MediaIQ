package com.gold;

public class Line {
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 31 *dx +dy;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || obj.getClass()!=this.getClass())
			return false;
		if(obj==this)
			return true;
		Line line=(Line)obj;
		return (line.dx==this.dx && line.dy==this.dy);
			
		
	}
	final int dx;
	final int dy;
	Line(int dx,int dy)
	{
		if(dy==0)
		{
			dx=Math.abs(dx);
		}
		else if(dy<0)
		{
			dx=-dx;
			dy=-dy;
		}
		int gcd=gcd(Math.abs(dx),dy);
		dx=dx/gcd;
		dy=dy/gcd;
		this.dx=dx;
		this.dy=dy;
	}
	private int gcd(int a, int b) {
		return (b==0)?a:gcd(b,a%b);
	}

}
