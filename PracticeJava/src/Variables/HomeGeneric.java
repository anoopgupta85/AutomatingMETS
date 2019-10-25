package Variables;

public class HomeGeneric {

	public static void main(String[] args) {
		
		HomeGeneric a1 = new HomeGeneric();
	String b1 = 	a1.concatenateTwoStrings("Anoop","Gupta");   // arguments.call the method using method signature.
		System.out.println(b1);
	}
	/*
	 * concatenateTwoStrings(String firstName, String lastName) - this is called method signature
	 */
	public String concatenateTwoStrings(String firstName, String lastName) // parameter or parameter list
	{
		//String firstName = "Anoop";
		//String lastName ="Gupta";
		String finalString =firstName +" "+ lastName;
		//System.out.println(finalString);		
		return finalString;
	}

	}


