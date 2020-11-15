package jkjtf;

import java.util.Scanner;

public class Jenum {
	
	enum risk {
		
		LOW,
		MEDIUM,
		HIGH;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter option 1 or 2 or 3\n");
		int option = input.nextInt();
		
		switch(option) {
		
		case 1: 
			System.out.println(risk.LOW);
			break;
		case 2:
			System.out.println(risk.MEDIUM);
			break;
		case 3:
			System.out.println(risk.HIGH);
			break;
		}
	
	}

}
