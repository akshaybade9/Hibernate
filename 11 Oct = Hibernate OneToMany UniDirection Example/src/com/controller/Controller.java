package com.controller;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.service.OperationService;
import com.service.OperationServiceImpl;
import com.util.HibernateUtil;

public class Controller {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OperationService os = new OperationServiceImpl();

		boolean flag = true;

		System.out.println("============Apllication Started============");

		
		
		while (flag) {

			System.out.println("1.Add User Data With Multiple Product ");
			System.out.println("2.Show All User With Multiple Product Data ");
			System.out.println("3. Get Single User With Multiple Product Data");
			System.out.println("4. Update User");
			System.out.println("5. Update Perticular Product Data Using User Id");
			System.out.println("6. Delete Perticular Product Data Using User Id");
			System.out.println("7. Delete User");
			System.out.println("8. Add Product Data To Existing User");
			System.out.println("9. Terminate The Apllication...");

			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				os.addUserDataWithMultipleProduct();
				break;
				
			case 2:
				os.showAllUserWithMultipleProductData();
				break;
				
			case 3:
				os.getSingleUserWithMultipleProductData();
				break;
				
			case 4:
				os.updateUser();
				break;
				
			case 5:
				os.updatePerticularProductDataUsingUserId();
				break;
				
			case 6:
				os.deletePerticularProductDataUsingUserId();
				break;
				
			case 7:
				os.deleteUser();
				break;
				
			case 8:
				os.addProductDataToExistingUser();
				break;
				
			case 9:
				flag = false;
				System.out.println("Aplication is Terminated...");
				break;

			default:
				System.out.println("Please Enter Correct Input");
				break;
			}

		}

	}

}
