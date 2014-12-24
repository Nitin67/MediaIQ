
public class regex {

	public static void main(String []args)
	{
		String str="jgrvbkgaaaaab";
		String ptr="a.a*b";
		System.out.println(regex(str,ptr)); 
		
	//System.out.println(regexMatch( str, ptr));	
	}
	
	private static boolean regex(String str, String ptr) {
		if(ptr.contains("$"))
		{
			return isEndWithDollar(str,ptr);
		}
		else if(ptr.contains("^")){
		return isStartWithExp(str, ptr);
			
		}
		else
		{
			for(int i=0;i<str.length();i++)
			{
				if(regexMatch(str.substring(i), ptr))
					return true;
			}
		}
		return false;
		
	}

	private static boolean regexMatch(String str, String ptr) {
		
		int j=0;
		int i=0;
		for( i=0;i<ptr.length()&&  j <str.length() ;i++)
		{
		
		 if(ptr.charAt(i)=='.')
		{
			if(j>=str.length())
				return false;
			else
				j++;
		}
		else if(ptr.charAt(i)=='*')
		{
			if(!(regexMatch(str.substring(j+1), ptr.substring(i)) || regexMatch(str.substring(j+1), ptr.substring(i+1))))
				return false;
			else return true;
			
		}
		else if(ptr.charAt(i)==str.charAt(j))
		{
			j++;
		}
		else
			return false;
		
			
		
		}
		// TODO Auto-generated method stub
		if(i<ptr.length())
			return false;
		
		return true;
	}

	private static boolean isStartWithExp(String str, String ptr) {
	
		//String parts[] = ptr.split("\\^");
		ptr=ptr.substring(1);
		if(regexMatch(str, ptr))
			return true;
		else
		return false;
		// TODO Auto-generated method stub
		
	}

	private static boolean isEndWithDollar(String str, String ptr) {
		;

		
		StringBuffer buf=new StringBuffer(str);
		buf.reverse();
		StringBuffer ptrBuf=new StringBuffer(ptr);
		ptrBuf.reverse();
		ptr=ptrBuf.substring(1);
		if(regexMatch(buf.toString(), ptr))
		return true;
		
		return false;
	}
}
