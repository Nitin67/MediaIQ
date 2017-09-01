package coding.designpattern.chainofresponsibilty;

import java.util.Scanner;

public class Testing {

	public static void main(String[] args) {
		MultiplyNumbers multiplyNumbers = new MultiplyNumbers();
		SubstractNumbers substractNumbers = new SubstractNumbers();
		AddNumbers addNumbers = new AddNumbers();
		substractNumbers.setNextChain(multiplyNumbers);
		addNumbers.setNextChain(substractNumbers);
		
		Numbers numbers = new Numbers();
		numbers.setNum1(20);
		numbers.setNum2(2);
		numbers.setCalculationMethod("Add");
		
		addNumbers.calculate(numbers);
		Scanner scan = new Scanner(System.in);
	}
}
