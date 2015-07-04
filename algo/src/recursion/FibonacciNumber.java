package recursion;

import java.util.Scanner;

public class FibonacciNumber {
	public static void main(String[] args) {
		System.out.println("enter the fibonacci number you want to get");
		Scanner scn = new Scanner(System.in);
		String entry = scn.nextLine();
		int nth = Integer.parseInt(entry);
		int result = fibonacci(nth);
		System.out.println("nth fibonacci is "+ result);
		scn.close();
		
	}

	private static int fibonacci(int n) {
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
	}
}
