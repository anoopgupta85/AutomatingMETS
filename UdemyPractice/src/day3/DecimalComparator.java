package day3;

public class DecimalComparator {

	public static void main(String[] args) {
		
		boolean matching = areEqualByThreeDecimalPlaces(-3.1756, -3.1756);
		System.out.println(matching);
		

	}
	
	public static boolean areEqualByThreeDecimalPlaces(double num1, double num2){
		
		boolean result = false;
		
		if (num1 == num2){
			
			result = true;
		}
		
		else {
			
			result = false;
		}
		
		return result;
	}

}
