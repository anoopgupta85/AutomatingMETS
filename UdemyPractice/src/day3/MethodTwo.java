package day3;

public class MethodTwo {

	public static void main(String[] args) {
	
		int position = calculateHighScorePosition(1000);
		displayHighScorePosition( "Omair", position);
		position = calculateHighScorePosition(900);
		displayHighScorePosition( "Salman", position);
		position = calculateHighScorePosition(400);
		displayHighScorePosition( "Usman", position);
		position = calculateHighScorePosition(50);
		displayHighScorePosition( "Rezwan", position);
		
	}

	
	public static void 	displayHighScorePosition(String playerName, int position){	
	
	System.out.println(playerName + " managed to get into position " + position + " on the high score table");	
		
	}
	
	public static int calculateHighScorePosition(int playerScore){
		
		int position1;
		
		if (playerScore >=1000){
			
			position1 = 1;
			
		} else if (playerScore >=500 ){
			
			position1 = 2;
			
		} else if (playerScore >=100){
			
			position1 = 3;
			
		} else {
			
			position1 = 4;
			
		}
		return position1;
		
		
		
	}
}
