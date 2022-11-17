package com;

import java.util.Scanner;

public class PrimeNumberExample {



	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter A Number: ");

		int no = sc.nextInt();
		int count = 0;

		for (int i = 2; i <= no - 1; i++) {

			if (no % i == 0) {
				// System.out.println("Number is Not Prime...");
				count++;
				break;

			}

		}

		if (count == 0) {
			System.out.println(no + " " + "Number is Prime");

		} else {
			System.out.println(no + " " + "Number Is Not Prime");
		}
	}

}
