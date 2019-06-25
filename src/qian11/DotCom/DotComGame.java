package qian11.DotCom;
import java.util.ArrayList;
public class DotComGame {
	public static void main(String[] args) {
		int numofguesses=0;
		GamerHelper helper=new GamerHelper();
		DotCom theDotCom=new DotCom();
		int randomNum=(int)(Math.random()*5);
		ArrayList<String> locations=new ArrayList<String>();
		for(int i=0;i<3;i++) {
			locations.add(String.valueOf(randomNum+i));
		}
		theDotCom.setLocationCells(locations);
		boolean isAlive=true;
		while(isAlive==true) {
			String guess=helper.getUserInput("enter a number");
			String result=theDotCom.checkYourself(guess);
			numofguesses++;
			if(result.equals("kill")) {
				isAlive=false;
				System.out.println("You took "+numofguesses+"guesses");
			}
		}
	}

}
