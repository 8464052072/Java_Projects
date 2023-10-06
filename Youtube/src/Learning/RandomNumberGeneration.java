package Learning;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGeneration {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		Random random=new Random();
		
		
		for(int i=0;i<=4;i++)
		{
			int r=random.nextInt(101);
			System.out.println(r);
		}
	}

}
