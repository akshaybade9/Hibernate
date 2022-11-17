package com;

import java.util.Scanner;

public class oddAndEvenExample {
	
	
	
	//  12/2====6
	//  12%2====0
	//9%2====1
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Any Number: ");
		
		int no = sc.nextInt();
		
		if(no%2==0) {

			System.out.println(no+"Number is Even");
		
		}else {
		
			System.out.println(no +"Number is Odd");
		}
		
		
		
		
		
	}
	
	

}
