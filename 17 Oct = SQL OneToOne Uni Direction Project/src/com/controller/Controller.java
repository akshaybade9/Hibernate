package com.controller;

import java.util.Scanner;

import com.service.OperationService;
import com.service.OperationServiceImpl;
import com.service.OperationService;

public class Controller {

	public static void main(String[] args) {

		OperationService op = new OperationServiceImpl();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====================Aplication Start=======================");
		
		boolean flag = true;

		while (flag) {

			System.out.println("1. Add Course");
			System.out.println("2. Display Course");
			System.out.println("3. Add Faculty");
			System.out.println("4. Display Faculty");
			System.out.println("5. Add Batch");
			System.out.println("6. Display Batch");
			System.out.println("7. Add Student");
			System.out.println("8. Display Student");

			
			System.out.println("9. For Terminate Application");
			

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addCourse();
				break;

			case 2:
				op.displayCourse();
				break;

			case 3:
				op.addFacalty();
				break;

			case 4:
				op.displayFacalty();
				break;

			case 5:
				op.AddBatch();
				break;
				
			case 6:
				op.DisplayBatch();
				break;
				
			case 7:
				op.AddStudent();
				break;
				
			case 8:
				op.DisplayStudent();
				break;
				
			case 9:
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
