package Variables;

public class Home {

	public static void main(String[] args) {
		
		Home a1 = new Home();
		a1.concatenateTwoStrings();

	}
	
	void concatenateTwoStrings()
	{
		String firstName = "Anoop";
		String lastName ="Gupta";
		String finalString =firstName +" "+ lastName;
		System.out.println(finalString);		
	}

}
