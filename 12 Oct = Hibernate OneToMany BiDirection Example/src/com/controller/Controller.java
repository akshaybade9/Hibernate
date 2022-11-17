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

			System.out.println("1.Add Student With Multiple Subject ");
			System.out.println("2.Show All Student Data With Multiple Subject ");
			System.out.println("3. Get Singe Student With Multiple Subject");
			System.out.println("4. Update Student");
			System.out.println("5. Update Perticular Subject using Student Id");
			System.out.println("6. Delete Student");
			System.out.println("7.Add Multiple Subject To Single Student");
			System.out.println("8. Show All Subject With Student Data");
			System.out.println("9. Get Single Subject With Student Data");
			System.out.println("10. Update Subject");
			System.out.println("11. For Terminate The Application");

			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				os.addStudentWithMultipleSubject();
				break;
				
			case 2:
				os.showAllStudentDataWithMultipleSubject();
				break;
				
			case 3:
				os.getSingeStudentWithMultipleSubject();
				break;
				
			case 4:
				os.updateStudent();
				break;
				
			case 5:
				os.updatePerticularSubjectusingStudentId();
				break;
				
			case 6:
				os.deleteStudent();
				break;
				
			case 7:
				os.addMultipleSubjectToSingleStudent();
				break;
				
			case 8:
				os.showAllSubjectWithStudentData();
				break;
				
			case 9:
				os.getSingleSubjectWithStudentData();
				break;
				
			case 10:
				os.updateSubject();
				break;
				
			case 11:
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
