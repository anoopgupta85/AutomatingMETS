package day3;

public class MegaBytesConverter {

	public static void main(String[] args) {
		
		printMegaBytesAndKiloBytes(-1);	

	}
	
	public static void printMegaBytesAndKiloBytes ( int kiloBytes){
		
		if(kiloBytes<0){
			System.out.println("invalid Value");
					} else {
						
						int kb = kiloBytes%1024;
						int mb = kiloBytes/1024;
						System.out.println(kiloBytes + " KB = " + mb + " MB and " + kb + " KB" );
						
					}
		
	}

}
