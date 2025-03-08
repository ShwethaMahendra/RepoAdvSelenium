package DDT;

import java.util.ArrayList;

public class forEach {

	public static void main(String[] args) {
		
		//iterating through array
		
		int[] number= {1,2,3,4,5,6};
		
		for (int i : number) {
			System.out.println(i);
		}
	

	System.out.println("--------------------------");

		
	//iterating through arraylist
		
		ArrayList<String> name=new ArrayList<>();
		name.add("max");
		name.add("tax");
		name.add("vax");
		
		System.out.println(name);
		
		for (String names : name) {
			System.out.println(names);
		}

	}

}
