package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * this method is used to avoid Duplicates
	 * @return
	 */
	
	public int getRandomValue() {
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}

}
