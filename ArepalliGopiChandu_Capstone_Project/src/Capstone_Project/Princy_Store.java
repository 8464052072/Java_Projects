package Capstone_Project;

import java.util.*;

public class Princy_Store {

//*****----->>>>> This is my main method

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
//		Princy_Store storeData = new Princy_Store();
//		sc.close();
		try {
			do {
				System.out.println("~~~~~~Hi, Welcome to the Princy online store!!!!~~~~~");
				System.out.println("SELECT one option from below....!!\n1--->for Admin Login\n2--->for Customer Login\n0--->for Exiting");
				choice = sc.nextInt();
				//sc.close();
				/*
				 * try { choice = sc.nextInt(); }catch(Exception e) { System.out.
				 * println("you have selected the wrong option please select again..."); }
				 */
				switch (choice) {
				case 0:{
					System.out.println("Thank you!!! You have successfully Exited...");
					break;
				}
				case 1: {
					System.out.println("You have choosed the Admin Login !!! Please provide the following details....");
					Admin adminData=new Admin();
					adminData.adminLogin();
					break;
				}
				case 2: {
					System.out.println("You have choosed the Customer Login !!!");
					Customer customerData=new Customer();
					customerData.customerInterface();
					break;
				}
				default: {
					System.out.println("Error!!! Please select the correct choice....");
					break;
				}
				}
			} while (choice != 0);
		} catch (InputMismatchException e) {
			System.err.println("You have choosed the Wrong option,I'm Exiting!!!1");
		}
		catch(NoSuchElementException e) {
			System.out.println();
		}
		/*
		 * catch (Exception e) {
		 * System.err.println("You have choosed the correct option!!!!"); }
		 */
	}
	
}
