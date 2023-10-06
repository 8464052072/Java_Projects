package Learning;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		ArrayList<String> task=new ArrayList<String>();
		
		while(true)
		{
			System.out.println("Select one option");
			System.out.println("1.Add task");
			System.out.println("2.remove task");
			System.out.println("3.show tasks");
			System.out.println("4.exit");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter task:");
				task.add(sc.nextLine());
				System.out.println("Task Added successfully!");
				break;
			
			case 2:
				System.out.println("Enter task no to remove the task:");
				int taskNumber=sc.nextInt();
				if (taskNumber>=1 && taskNumber<=task.size()) {
					task.remove(taskNumber-1);
					System.out.println("task removed");	
				}else
					System.out.println("Invalid task number");
				break;
				
			case 3:
				System.out.println("TO DO LIST:");
				for (int i=0;i<task.size();i++)
				{
					System.out.println(i+1+". "+task.get(i));
				}
				break;
				
			case 4:
				//return;
				//System.exit(0);
			
			default:
				System.out.println("Invalid choice");
				break;
					
				
				
			}
			
		}
	}

}
