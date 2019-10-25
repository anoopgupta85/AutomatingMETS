package day3;

public class BarkingDog {

	public static void main(String[] args) {
	
		bark(true,-1);

	}

	public static void bark ( boolean barking, int hourOfDay){
		
		boolean result = false;
		 if (barking == true && ((hourOfDay<8 && hourOfDay >=0) || hourOfDay >= 22)){
			 
			 result = true;
			 System.out.println(result);
		 }else if (barking == true && (hourOfDay>=8 || hourOfDay < 22)){
			 result = false;
			 System.out.println(result);				 
			 }
		 
		 
		 else if(barking == false && (hourOfDay<8 || hourOfDay >= 22)){
			 
			 result =  false;
			 System.out.println(result);
		 } else if ( hourOfDay < 0){
			 
			 result =  false;
			 System.out.println(result); 
		 }
	
	}
	
}
