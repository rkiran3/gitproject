package com;

public class Fibonacci {

	public static void edureka() {
		int n, first = 0,next = 1;
        
        System.out.println("Enter how may fibonnaci numbers to print");
        
        n = 10;
        System.out.print("The first " + n + " Fibonacci numbers are: ");
        System.out.print(first + " " + next);
        for (int i = 1; i<=n-2; ++i)
        {
            int sum = first + next;
            first = next;
            next = sum;
            System.out.print(" " + sum);
        }
	}

	public static long fibonacci(long l) {
		long retval;
		
		if (l == 0) {
			retval =  0;
		} else if (l == 1) {
			retval = 1;
		} else {
			retval = fibonacci(l-2) + fibonacci(l-1);
		}

		System.out.println(retval);
		
		return retval;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(10));
				
		int f0 = 0;
		int f1 = 1;
		for (int i=1; i <= 10; i++) {
			
			int sum = f0 + f1;
			
			System.out.println("Iter: " + i + " Sum: " + sum);
			
			f0 = f1;
			f1 = sum;
		}

		edureka();
		
	}

}
