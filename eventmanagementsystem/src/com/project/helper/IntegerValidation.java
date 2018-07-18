package com.project.helper;

import java.util.Scanner;

public class IntegerValidation {
	private int n;
	Scanner sc=new Scanner(System.in);
	int validatInteger()
	{
		do{
			System.out.println("Please Enter A Positive Integer:");
		    while (!sc.hasNextInt()) {
		        System.out.println("Please Enter A Valid Input (Positive Integer) :");
		        sc.next(); // this is important!
		    }
		    n = sc.nextInt();
		} while (n <= 0);
		return n;
	}

}
