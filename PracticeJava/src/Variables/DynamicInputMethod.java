package Variables;

import java.util.Scanner;

public class DynamicInputMethod {
	
	/*
	 * num --> table point
	 * 
	 */
	
	public void printTable(int num)
	{
		
		for (int i = 1; i <=10 ; i ++)
		{
			System.out.println(num+" * "+i+" = "+(num*i));	
			}
		
		
	}

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a numeric number");
		int var = scan.nextInt();
		System.out.println(" The enterred number is: " +var);
		
		DynamicInputMethod obj = new DynamicInputMethod();
		obj.printTable(var);

	}

}
