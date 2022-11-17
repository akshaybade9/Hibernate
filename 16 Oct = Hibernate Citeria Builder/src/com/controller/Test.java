package com.controller;

import java.util.Scanner;

import com.service.OperationInterface;
import com.service.OperationInterfaceImpl;

public class Test {

	public static void main(String[] args) {

		OperationInterface op = new OperationInterfaceImpl();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====================Aplication Start=======================");
		
		boolean flag = true;

		while (flag) {

			System.out.println("1. Add Product");
			System.out.println("2. Show All Product");
			System.out.println("3. Get Single Product");
			System.out.println("4. Get Single Colomn Data");
			System.out.println("5. Get Multiple Colomn Data");
			System.out.println("6. For Terminate Application");
			

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addProductData();
				break;

			case 2:
				op.showAllData();
				break;

			case 3:
				op.getSingleProduct();
				break;

			case 4:
				op.getSingleColomnData();
				break;

			case 5:
				op.getMultipleColomnData();
				break;
				
			case 6:
				System.out.println("Application Is Terminated....");
				flag = false;
				break;

			default:
				System.out.println("Please Enter Correct Input");
				
				break;
			}

		}
	}

}
