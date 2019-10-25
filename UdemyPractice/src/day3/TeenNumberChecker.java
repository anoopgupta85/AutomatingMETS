package day3;

public class TeenNumberChecker {

	public static void main(String[] args) {
		
		boolean result = hasTeen(23,22,24);
		System.out.println(result);
	

	}
	
	public static boolean hasTeen(int num1, int num2, int num3){
		
		boolean result = false;
		
		if (( num1 >= 13 && num1 <=19) ||  ( num2 >= 13 && num2 <=19) ||  ( num3 >= 13 && num3 <=19)){
			
			result = true;
		}
		
		else{
			
			result = false;
		}
		
		return result;
	}

}
