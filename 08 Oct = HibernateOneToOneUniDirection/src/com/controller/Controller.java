package com.controller;

import java.util.Scanner;

import com.service.OperationService;
import com.service.OperationServiceImpl;

public class Controller {

	public static void main(String[] args) {

		boolean flag = true;

		Scanner sc = new Scanner(System.in);
		OperationService os = new OperationServiceImpl();

		while (flag) {
			System.out.println("1. Insert Student With Address");
			System.out.println("2. Show All Data");
			System.out.println("3. Get Single Student With Address");
			System.out.println("4. Update Student");
			System.out.println("5. Update Address Using Student");
			System.out.println("6. Delete Student");
			System.out.println("8. Terminate Application");
			
			System.out.println("Choose Any Number From Above Menu: ");
			
			String n = sc.next();

			switch (n) {
			case "1":

				os.insertStudentWithAddress();
				break;

			case "2":

				os.showAllData();
				break;

			case "3":

				os.getSingleStudentWithAddress();
				break;

			case "4":

				os.updateStudent();
				break;

			case "5":

				os.updateAddressUsingStudent();
				break;
				
			case "6":

				os.deleteStudent();
				break;

				
			case "8":

				flag = false;
				break;

			default:
				System.out.println("You Entered Wrong Input");
				break;
			}

		}

	}

}
