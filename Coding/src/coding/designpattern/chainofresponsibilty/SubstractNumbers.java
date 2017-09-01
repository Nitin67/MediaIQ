package coding.designpattern.chainofresponsibilty;

public class SubstractNumbers implements Chain{

	Chain nextChain = null;
	
	@Override
	public void setNextChain(Chain chain) {
		this.nextChain = chain;
	}

	@Override
	public void calculate(Numbers numbers) {
		if(numbers.getCalculationMethod().equals("Sub"))
		{
			System.out.println(numbers.getNum1() - numbers.getNum2());
		}
		else if(nextChain !=null ){
			nextChain.calculate(numbers); 
		}
		
	}
}
