package Assign1;
import java.util.Scanner;

public class Balanced {
	
	public boolean Balance(char[] X, int n) {
		Stack S = new Stack();//max size of stack is 100
		char temp;//stores value of char
		for(int j = 0; j<n;j++) {
			if(X[j]=='{'||X[j]=='['||X[j]=='(') {
				S.push(X[j]);
			}
			else if(X[j]=='}'||X[j]==']'||X[j]==')') {
				//
				if (S.isEmpty()) {
					return false;//nothing to match with, thus not balanced
				}
				temp = S.pop();//Stores value of element popped from stack
				if (temp== '{' && X[j]=='}') {//Checking if it fits a matching pair
					continue;
				}
				else if(temp== '[' && X[j]==']') {
					continue;
				}
				else if(temp== '('&& X[j]==')') {
					continue;
				}
				else {
					return false;//Doesn't fit matching pair, therefore unbalanced
				}
				
			}
		}
		if (S.isEmpty()) {//All brackets have been matched
			return true;
		}
		else {
			return false;//There were some left over brackets
		}
	}

	public static void main(String[] args) {
		// Input Validation and conversion of string to char array
		System.out.println("Please enter a series of these arithmetic operators {,},[,],(,),0,1,2,3,4,5,6,7,8,9,+,-,*,/");
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
				if (!((40<= X[i]&&X[i]<= 57) || (91<=X[i] && X[i]<=93) || X[i]==123 || X[i]==125 )) {//ASCII of arithmetic operators
				   System.out.println("Error, invalid input. Enter a series of these arithmetic operators {,},[,],(,),0,1,2,3,4,5,6,7,8,9,+,-,*,/");
				   error = true;
				   break;
				}
			}
		}while(error);
		scanner.close();//closes scanner
		
		//Testing user input
		Balanced Balance_check = new Balanced();//Creating instance of balance class so that I can use balance method
		if(Balance_check.Balance(X,length)) {
			System.out.println("The string you entered is balanced!");
		}
		else {
			System.out.println("The string you entered is unbalanced");
		}
		
		
		//Defining test cases and Running the Algorithm
		String i = "(9*[3*{[(3+3)/5]*7}])";
		int lengthi = i.length();//returns the length of string
		char[] test_i = i.toCharArray();//convert input string into char array 
		if (Balance_check.Balance(test_i,lengthi)) {
			System.out.println("(9*[3*{[(3+3)/5]*7}]) is balanced");
		}
		else {
			System.out.println("(9*[3*{[(3+3)/5]*7}]) is unbalanced");
		}
		
		String ii = "{3*(2+[3-[4/[6/9]]]})";
		int lengthii = ii.length();//returns the length of string
		char[] test_ii = ii.toCharArray();//convert input string into char array
		if(Balance_check.Balance(test_ii,lengthii)) {
			System.out.println("{3*(2+[3-[4/[6/9]]]}) is balanced");
		}
		else {
			System.out.println("{3*(2+[3-[4/[6/9]]]}) is unbalanced");
		}
		
		String iii = "((3*(9-(4*(6-5))))";
		int lengthiii = iii.length();//returns the length of string
		char[] test_iii = iii.toCharArray();//convert input string into char array 
		if(Balance_check.Balance(test_iii,lengthiii)) {
			System.out.println("((3*(9-(4*(6-5)))) is balanced");
		}
		else {
			System.out.println("((3*(9-(4*(6-5)))) is unbalanced");
		}
		
		String iv = "{2-{3*{6/[[[(((9-0)))]]]}}/7}";
		int lengthiv = iv.length();//returns the length of string
		char[] test_iv = iv.toCharArray();//convert input string into char array 
		if(Balance_check.Balance(test_iv,lengthiv)) {
			System.out.println("{2-{3*{6/[[[(((9-0)))]]]}}/7} is balanced");
		}
		else {
			System.out.println("{2-{3*{6/[[[(((9-0)))]]]}}/7} is unbalanced");
		}
	}

}
