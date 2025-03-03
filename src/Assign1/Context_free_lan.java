package Assign1;

import java.util.Scanner;

public class Context_free_lan {
	public String Algorithm(char[] X,int n) {
		Stack S = new Stack(); //Stack constructor, initialized to size 100
		char temp;//stores value of popped element in stack
		int count = 0;
		for(int i = 0; i<n;i++) {
			if(X[i] == '0' && count == 0)//Add to the stack
				S.push(X[i]);
			else if(X[i]=='1') { 
				if (S.isEmpty()) {
					return "No"; //No zero thus not part of language, not same amount of zero's
				}
				temp = S.pop();
				if (temp != '0') {
					return "No";
				}
				count++;
			}
		}
		if (S.isEmpty())
			return "Yes";//All 1's have been matched with a 0 and thus it's part of the language
		else
			return "No";
	}

	public static void main(String[] args) {
		//Input validation and conversion into char array
		System.out.println("Please enter a series of 0's and 1's.");
		boolean error;
		Scanner scanner = new Scanner(System.in);
		int length;
		char[] X = null;
		do {
			String input = scanner.nextLine();
			length = input.length();//returns the length of string
			X = input.toCharArray();//convert input string into char array named X
			error = false;
			for(int i = 0; i<length;i++) {
				if (X[i] != '1' && X[i] != '0') {//Checks if input consists only of 0's and 1's
				   System.out.println("Error, invalid input. Please enter a series of 0's and 1's.");
				   error = true;
				   break;
				}
			}
		}while(error);
		scanner.close();//closes scanner
		
		Context_free_lan Context = new Context_free_lan();//Instance of own class because I want to use the method Algorithm in that class
	    long start = System.nanoTime();//start time of algorithm
	    String result_1 = Context.Algorithm(X, length); // Captures result of algorithm
	    long end = System.nanoTime();//Measure the end time
	    long duration = end - start;//Calculate duration
	    if (result_1 == "Yes") {
			System.out.println("Your input is part of the context free language");
		}
		else {
			System.out.println("Your input is not part of the context free language");
		}
	    System.out.println("Running time of the algorithm in nanoseconds: " + duration);

	}

}
