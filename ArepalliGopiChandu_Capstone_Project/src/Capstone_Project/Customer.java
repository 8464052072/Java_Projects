package Capstone_Project;

import java.util.*;

//*****----->>>>> Class contains all the methods related to Customer...

public class Customer {
	static int welcomeBonus=0;
	Scanner sc = new Scanner(System.in);
	public String username, emailId, password;
	Customer register[] = new Customer[1000];
	int register_count = 0;
//	Customer details = new Customer();

	public void customerInterface() {
		Customer details = new Customer();
		try {
			int ch;
			do {
				System.out.println("~~~~~~Hi, Welcome to the Princy online store!!!!~~~~~");
				System.out.println("1.Register if you are a new user.");
				System.out.println("2.Login if you already have an account.");
				System.out.println("0.Exit from the Princy Digital Store.....");
				System.out.println("\nPlease select one of the above options:");
				ch = sc.nextInt();

				switch (ch) {
				case 0: {
					System.out.println("Thank you!!! You have successfully Exited...");
					break;
				}
				case 1: {
//					details.cutomerRegistration();
					register[register_count] = details.cutomerRegistration(register_count);
					register_count++;
					break;
				}
				case 2: {
					boolean flag_1 = details.CustomerLogin(register_count, register);
//					boolean flag_1 = details.customerLogin();
					if (flag_1 == true) {
						details.Menu();
					} else {
						System.out.println("Error!! Please enter correct Username and Password.\n");
					}
					break;
				}
				default: {
					System.out.println("Error!!! Please select the correct choice....");
					break;
				}
				}
			} while (ch != 0);
		} catch (InputMismatchException e) {
			System.out.println();
		}
		catch(NoSuchElementException e) {
			System.out.println();
		}
	}

// *****----->>>>> Method for registration of the new customer....

	Customer cutomerRegistration(int register_count) {
		Customer details = new Customer();
		if (register_count > 1000) {
			System.out.println("The User Registration is full. No further registrations are allowed.");
		} else {
			System.out.println("\nPlease enter the following details:");
			System.out.println("Enter your user name:");
			details.username = sc.next();
			System.out.println("Enter your email id:");
			details.emailId = sc.next();
			System.out.println("Enter your Password:");
			details.password = sc.next();
			welcomeBonus=5;
			System.out.println("Your registration was successful.and you got 5rs as welcome bonus!.Please choose Login to continue!!!!\n");
		}
		return details;

	}


// *****----->>>>> Method for registration of the new customer....
	
/*	public void cutomerRegistration()
	{
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the user name:");
		String nm=sc.next();
		System.out.println("Enter the password:");
		String pass=sc.next();
		sc.close();
		try
		{
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select * from customer where username='"+nm+"' && password='"+pass+"'");
			if(d.rs.next())
			{
				System.out.println("UserName already exists...Please choose Login to continue!!!");
			}
			else
			{
				welcomeBonus=5;
				String qry="insert into customer values ('"+nm+"','"+pass+"')";
				d.stat.executeUpdate(qry);
				System.out.println("\n\t record registered successfully\n");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
*/
	
//*****----->>>>> Method for Login of the customer

	public boolean CustomerLogin(int register_count, Customer details[]) {
		boolean flag = false;
		String findName, findPass;
		System.out.println("\nEnter the Username to Login:");
		findName = sc.next();
		System.out.println("\nEnter the Password to Login:");
		findPass = sc.next();
//		Scanner c = new Scanner(System.in);
		for (int i = 0; i < register_count; i++) {
			if (findName.equals(details[i].username) && findPass.equals(details[i].password)) {
				System.out.println("~~~Login Successful!");
				flag = true;
			}

		}
		return flag;
	}

	
//*****----->>>>> Method for Login of the customer
/*	public boolean customerLogin()
	{
		Scanner sc=new Scanner (System.in);
		boolean flag=false;
		System.out.println("Enter the user name:");
		String nm=sc.next();
		System.out.println("Enter the password:");
		String pass=sc.next();
		sc.close();
		try
		{
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select * from customer where username='"+nm+"' && password='"+pass+"'");
			if(!d.rs.next())
			{
				System.out.println("You have entered a wrong credentials!!!Please try again to Login otherwise create a new user account by registration method");
			}
			else
			{
				System.out.println("Login successful!!!");
				flag=true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;

	}
*/

//*****----->>>>> Method to execute the customer menu 

	public void Menu() {
		Customer details = new Customer();
		int ch;
		try
		{
		do {
			System.out.println("\n---->> Welcome Back to the Princy Digital Store <<----");
			System.out.println("1.List the products in the store...");
			System.out.println("2.Search the product by using productid...");
			System.out.println("3.Search the product by using the name of the product...");
			System.out.println("0.To Logout of the Store");
			System.out.println("Please select one option from above");
			ch = sc.nextInt();
			switch (ch) {
			case 0: {
				System.out.println(
						"\n\n____________Your have Logged Out Successfully____________\n***********Thankyou for visiting 'Princy Digital Store'**********\n");
				System.exit(0);
				break;
			}
			case 1: {
				details.List();
				break;
			}
			case 2: {
				details.ProductId();
				break;
			}
			case 3: {
				details.ProductName();
				break;
			}
			default: {
				System.out.println("Error!!! Please select the correct option....");
				break;
			}
			}
		} while (ch != 0);
		
		}catch(Exception e)
		{
			System.out.println();
		}

	}

//*****----->>>>> Method to list all the products in the store

	public void List() {
		try {
			dbCon d = new dbCon();
			d.rs = d.stat.executeQuery("select SNO,name,id,category,selling_price,available_quantity from products");
			d.md = d.rs.getMetaData();
			int c = d.md.getColumnCount();
			for (int i = 1; i <= c; i++) {
				System.out.print("\t" + d.md.getColumnLabel(i));
			}
			System.out.println(
					"\n   ---------------------------------------------------------------------------------------------------------------");
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
				System.err.println(
						"No products are available ar this time!!!Please Re-visit after some time.....Thank You\n\n");
		} catch (Exception e) {
			System.out.println(e);
		}
		Customer details = new Customer();
		details.Billing();
//		Billing bill=new Billing();
//		bill.Billing();
	}

//*****----->>>>> Method to search the products by using the product id..

	public void ProductId() {
		try {
			System.out.println("Enter product id:");
			int search = sc.nextInt();
			dbCon d = new dbCon();
			d.rs = d.stat.executeQuery(
					"select SNO,name,id,category,selling_price,available_quantity from products where id='" + search
							+ "'");
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
		Customer details = new Customer();
		details.Billing();
//		Billing bill=new Billing();
	}

//*****----->>>>> Method to search the products by using the product name..

	public void ProductName() {
		try {
			System.out.println("Enter the product name:");
			String search = sc.next();
			search.toLowerCase();
			dbCon d = new dbCon();
			d.rs = d.stat.executeQuery(
					"select SNO,name,id,category,selling_price,available_quantity from products where name='" + search
							+ "'");
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
		Customer details = new Customer();
		details.Billing();
//		Billing bill=new Billing();
	}

// *****----->>>>> Method to search the products by using the product category..

	public void ProductCategory() {
		try {
			System.out.println("Enter the product category:");
			String search = sc.next();
			search.toLowerCase();
			dbCon d = new dbCon();
			d.rs = d.stat.executeQuery("select SNO,name,id,category,selling_price,available_quantity from products where category='" + search+ "'");
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
		Customer details = new Customer();
		details.Billing();
//		Billing bill=new Billing();

	}
	
// *****----->>>>> Method to print the Total bill..
	
	public void Billing()
	{
		double price=0;
		int available_quantity=0;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the product id of the product that you want to buy:");
		String product=sc.next();
		System.out.println("Enter the quantity of the product to buy:");
		int required_quantity=sc.nextInt();
		sc.close();
		try
		{
		dbCon d=new dbCon();
		d.rs=d.stat.executeQuery("select selling_price,available_quantity from products where id='"+product+"'");
		d.md=d.rs.getMetaData();
		int c=d.md.getColumnCount();
	
		while(d.rs.next())
		{
		price=d.rs.getDouble(1);
		available_quantity=d.rs.getInt(2);
			if (required_quantity<=available_quantity)
			{
				System.out.println("Total Bill is:"+((price*required_quantity)-welcomeBonus));
				available_quantity=available_quantity-required_quantity;
				String qry="update products set available_quantity='"+available_quantity+"' where id='"+product+"'";
				d.stat.executeUpdate(qry);
			}
			else
			{
				System.out.println("the quantity you required is not available in the store!!Sorry!!");
			}
		}
	
		}
		catch(Exception e)
		{
			System.err.println();
		}
	}
	
}
