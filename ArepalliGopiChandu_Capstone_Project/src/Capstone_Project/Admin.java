package Capstone_Project;

import java.util.*;

//*****----->>>>> Class contains all the methods related to Admin...

public class Admin {
	Scanner sc = new Scanner(System.in);
	public String username, password;

//*****----->>>>> Method to Login the Admin of the Store	

	public void adminLogin() {
		Admin data = new Admin();
		System.out.println("Enter your user name:");
		username = sc.next();
		System.out.println("Enter your password:");
		password = sc.next();
		if (username.equals("P") && password.equals("P")) {
			System.out.println("Welcome Boss!!!!You have Loggedin successfully \n");
			data.Menu();
		} else {
			System.out.println("Error!!!Admin Login failed\n");
		}
	}

//*****----->>>>> Method to execute the admin menu

	public void Menu() {
		Admin data = new Admin();
		int ch;
		try {
			
			do {
				System.out.println("---->> Here's the options for you <<----");
				System.out.println("1.List the products in the store...");
				System.out.println("2.Search the product by using productid...");
				System.out.println("3.Search the product by using the name of the product...");
				System.out.println("4.Search the product by using the product category...");
//				System.out.println("5.To check the total amount, spend on products which are available in the store...");
//				System.out.println("6.TO check the Profit amount on the total products...");
				System.out.println("0.To Logout of the Store");
				System.out.println("\nPlease select one of the above options:");
				ch = sc.nextInt();
				switch (ch) {
				case 0: {
					System.out.println("\n\n____________Your have Logged Out Successfully____________\n***********Thankyou for visiting 'Princy Digital Store'**********\n");
					System.exit(0);
					break;
				}
				case 1: {
					data.List();
					break;
				}
				case 2: {
					data.ProductId();
					break;
				}
				case 3: {
					data.ProductName();
					break;
				}
				case 4: {
					data.ProductCategory();
					break;
				}
//				case 5: {
//					break;
//				}
//				case 6:{
//					break;
//				}
				default: {
					System.out.println("Error!!! Please select the correct option....");
					break;
				}
				}
			} while (ch != 0);

		} catch (InputMismatchException e) {
			System.err.println("You have choosed the Wrong option,I'm Exiting!!!1");
		}
	}
	
//*****----->>>>> Method to list all the products in the store

	public void List()
	{
		try
		{
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select * from products");
			d.md=d.rs.getMetaData();
			int c=d.md.getColumnCount();
			for (int i=1;i<=c;i++)
			{
				System.out.print("\t"+d.md.getColumnLabel(i));
			}
			System.out.println("\n   ---------------------------------------------------------------------------------------------------------------");
			int n=0;
			while(d.rs.next())
			{
				n++;
				for (int i=1;i<=c;i++)
				{
					System.out.print("\t"+d.rs.getString(i));
				}
				System.out.println();
			}
			if(n>0)
				System.out.println("\n\t"+n+"record(s) found\n\n");
			else
				System.err.println("No products are available ar this time!!!Please Re-visit after some time.....Thank You\n\n");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
//*****----->>>>> Method to search the products by using the product id..
	
	public void ProductId()
	{
		try
		{
			System.out.println("Enter product id:");
			int search=sc.nextInt();
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select * from products where id='"+search+"'");
			d.md=d.rs.getMetaData();
			int c=d.md.getColumnCount();
			for (int i=1;i<=c;i++)
			{
				System.out.print("\t"+d.md.getColumnLabel(i));
			}
			System.out.println("\n-------------------------------------------------------------------------------------------------------");
			int n=0;
			while(d.rs.next())
			{
				n++;
				for (int i=1;i<=c;i++)
				{
					System.out.print("\t"+d.rs.getString(i));
				}
				System.out.println();
			}
			if(n>0)
				System.out.println("\n\t"+n+"record(s) found\n\n");
			else
				System.err.println("No such products are available realted to your search\n\n");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
//*****----->>>>> Method to search the products by using the product name..

	public void ProductName()
	{
		try
		{
			System.out.println("Enter the product name:");
			String search=sc.next();
			search.toLowerCase();
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select * from products where name='"+search+"'");
			d.md=d.rs.getMetaData();
			int c=d.md.getColumnCount();
			for (int i=1;i<=c;i++)
			{
				System.out.print("\t"+d.md.getColumnLabel(i));
			}
			System.out.println("\n-------------------------------------------------------------------------------------------------------");
			int n=0;
			while(d.rs.next())
			{
				n++;
				for (int i=1;i<=c;i++)
				{
					System.out.print("\t"+d.rs.getString(i));
				}
				System.out.println();
			}
			if(n>0)
				System.out.println("\n\t"+n+"record(s) found\n\n");
			else
				System.err.println("No such products are available realted to your search\n\n");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
// *****----->>>>> Method to search the products by using the product category..

		public void ProductCategory() {
			try {
				System.out.println("Enter the product category:");
				String search = sc.next();
				search.toLowerCase();
				dbCon d = new dbCon();
				d.rs = d.stat.executeQuery("select * from products where category='" + search+ "'");
				d.md = d.rs.getMetaData();
				int c = d.md.getColumnCount();
				for (int i = 1; i <= c; i++) {
					System.out.print("\t" + d.md.getColumnLabel(i));
				}
				System.out.println(
						"\n-------------------------------------------------------------------------------------------------------");
				int n = 0;
				while (d.rs.next()) {
					n++;
					for (int i = 1; i <= c; i++) {
						System.out.print("\t" + d.rs.getString(i));
					}
					System.out.println();
				}
				if (n > 0)
					System.out.println("\n\t" + n + "record(s) found\n\n");
				else
					System.err.println("No such products are available realted to your search\n\n");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

}
