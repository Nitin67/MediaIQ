package com.housing;



public class ConvertAStringToOtherWithMinIntermediateSteps {

	
	
	public boolean IsInDic(String str)
	{
		String []strArray={"acc","abc","cba","add","adc","acd","cdd","bdd","abd","aad","ccd","bbd"};
		for (String string : strArray) {
			if(str.equalsIgnoreCase(string))
				return true;
		}
		return false;
	}
	
	
}
