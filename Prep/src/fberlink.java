import java.util.HashSet;


public class fberlink {
	/*
	 * Complete the function below.
	 */

	    static int isImperfectString(String input) {
	    
	    	char ch[]=input.toCharArray();
	    	
	    	for(int i=1;i<=input.length()-1;i++)
	    	{
	    		 if(input.length() <= 1)

	    		        return 1;
	    		HashSet<String> set=new HashSet<String>();
	    		for(int j=0;j<input.length()-i;j++)
	    		{
	    			int size=set.size();
	    			StringBuilder builder=new StringBuilder();
	    			builder.append(ch[j]);
	    			builder.append(ch[i+j]);
	    			if(set.contains(builder.toString()))
	    				return 0;
	    			set.add(builder.toString());
	    		
	    		}
	    	}
	    	return 1;
	    }
	    
	    public static void main(String []args)
	    {
	    	System.out.println(isImperfectString("FLBL"));
	    }


}
