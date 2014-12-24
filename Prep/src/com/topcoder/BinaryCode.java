package com.topcoder;

public class BinaryCode {

	public static String[] decode(String message)
	{
		String str[]=new String[2];
		str[0]="NONE";
		str[1]="NONE";
		if(message==null)
			return str;
		else
		{
			
			
			if(Integer.parseInt(message.substring(0,1))>1){
				str[0]="NONE";
				if(Integer.parseInt(message.substring(0,1))>2)
				{	str[1]="NONE";
					return str;
				}
				
			}
				
			else
			{
				str[0]="0";
				for(int i=0;i<message.length()-1;i++)
				{	
				 
				   if((Integer.parseInt(str[0].substring(i,i+1))==0 && Integer.parseInt(message.substring(i,i+1))>2)||(Integer.parseInt(str[0].substring(i,i+1))==1 && Integer.parseInt(message.substring(i,i+1))>3))
				   {
					   str[0]="NONE";
					   break;
				   }
				   else 
				   {
					   if(i==0){
						   if(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))>1|| Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))<0)
						   { 
						   str[0]="NONE";
						   break;
						   }
					  str[0]+=String.valueOf(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))) ;
					   
					   }else{
						   if(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))-(Integer.parseInt(str[0].substring(i-1,i)))>1||Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))-(Integer.parseInt(str[0].substring(i-1,i)))<0)
						   { 
						   str[0]="NONE";
						   break;
						   }
						   else
						   str[0]+=String.valueOf(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[0].substring(i,i+1)))-(Integer.parseInt(str[0].substring(i-1,i))));
				   
					   }
					   }
						
				}
			}
			
			 if(Integer.parseInt(message.substring(0,1))==0)
				{
					str[1]="NONE";
				}
			 else
			 {

					str[1]="1";
					for(int i=0;i<message.length()-1;i++)
					{	
					  
					   if((Integer.parseInt(str[1].substring(i,i+1))==0 && Integer.parseInt(message.substring(i,i+1))>2)||(Integer.parseInt(str[1].substring(i,i+1))==1 && Integer.parseInt(message.substring(i,i+1))>3))
					   {
						   str[1]="NONE";
						   break;
					   }
					   else 
					   {
						   if(i==0)
						   {
							   if(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))>1||Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))<0)
							   {
								   str[1]="NONE";
								   break;
							   }
							   else
						  str[1]+=String.valueOf(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))) ;
						   }
						   else{
							   if(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))-(Integer.parseInt(str[1].substring(i-1,i)))>1 || Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))-(Integer.parseInt(str[1].substring(i-1,i)))<0)
							   { 
							   str[1]="NONE";
							   break;
							   }
							   else
							   str[1]+=String.valueOf(Integer.parseInt(message.substring(i,i+1))-(Integer.parseInt(str[1].substring(i,i+1)))-(Integer.parseInt(str[1].substring(i-1,i))));
						   }
						   }
							
					}
				
				 
			 }
		}
		return str;
	}
}
