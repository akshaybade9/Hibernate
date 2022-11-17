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
			System.out.println("1. Add Person Data with Aadhar Data");
			System.out.println("2. Get all Person Data");
			System.out.println("3. Single Person Get with Aadhar Data");
			System.out.println("4. Update Person");
			System.out.println("5. Update Aadhar Data Using Person Data");
			System.out.println("6. Add Aadhar Data with Person Data");
			System.out.println("7. Get All Aadhar Data");
			System.out.println("8. Single Aadhar Data with Person Data");
			System.out.println("9. Update Aadhar");
			System.out.println("10. Update Person Using Aadhar Data");
			System.out.println("11. For Terminate Application");

			String n = sc.next();

			switch (n) {
			case "1":

				os.addPersonWithAadharCard();
				break;

			case "2":

				os.getAllPersonDataWithAadharData();
				break;

			case "3":

				os.getSinglePersonDataWithAadharData();
				break;

			case "4":

				os.updatePerson();
				break;

			case "5":

				os.updateAadharUsingPersonId();
				break;
				
			case "6":

				os.addAadharDataWithPerson();
				break;
				
			case "7":

				os.getAllAadharDataWithPersonData();
				break;
				
			case "8":

				os.getSingleAadharDatawithPerson();
				break;
				
			case "9":

				os.upadateAadharData();
				break;
				
			case "10":

				os.updatePersonUsingAadharData();
				break;

				
			case "11":

				flag = false;
				break;

			default:
				System.out.println("You Entered Wrong Input");
				break;
			}

		}

	}

}
