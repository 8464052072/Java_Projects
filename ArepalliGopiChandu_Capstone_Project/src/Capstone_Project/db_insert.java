package Capstone_Project;
import java.lang.*;
import java.sql.*;
import java.util.*;

//*****----->>>>> Class to insert the new products into the database

public class db_insert {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product name:");
		String name=sc.next();
		name.toLowerCase();
		System.out.println("Enter the product Id:");
		String id=sc.next();
		System.out.println("Enter the product category:");
		String category=sc.next();
		category.toLowerCase();
		System.out.println("Enter the product buying price:");
		double buying_price=sc.nextDouble();
		double selling_price=buying_price+((buying_price)/2);
		System.out.println("Enter the available quantity of the product:");
		int available_quantity=sc.nextInt();
		double profit=selling_price-buying_price;
		double total_profit=profit*available_quantity;
		
		try
		{
			dbCon d=new dbCon();
			d.rs=d.stat.executeQuery("select SNO from products order by SNO desc");
			int n = 0;
			if (!d.rs.next()) {
				n=1;
			}
			else {
				int n1 = d.rs.getInt("SNO");
				n=n1;
				n++;
			}
			String qry ="insert into products values('"+n+"','"+name+"','"+id+"','"+category+"','"+buying_price+"','"+selling_price+"','"+available_quantity+"','"+profit+"','"+total_profit+"')";
			d.stat.executeUpdate(qry);
			System.out.println("\n\t1 record registered");
			System.out.println(qry);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
