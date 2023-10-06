package Learning;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		while(true) {
		
		System.out.println("Enter first number:");
		double n1=sc.nextDouble();
		
		System.out.println("Enter operator(+,-,/,*) :");
		char symbol=sc.next().charAt(0);
		
		System.out.println("Enter second number:");
		double n2=sc.nextDouble();
		
		double result = 0;
		
		switch(symbol){
			case '+':
				result=n1+n2;
				break;
			case '-':
				result=n1-n2;
				break;
			case '/':
				result=n1/n2;
				break;
			case '*':
				result=n1*n2;
				break;
				
			default:
				System.out.println("Invalid Operator");
				return;
			
		}
		System.out.println("Result is:"+result);
		}
		
		
	}

}
