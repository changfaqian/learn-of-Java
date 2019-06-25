package dotcom2;

import java.util.*;

public class Helpertest {

	public static void main(String[] args) {
		GameHelper helper=new GameHelper();
		ArrayList<String> newlocation=helper.placeDotCom(3);
		System.out.println(newlocation);
	}

}
