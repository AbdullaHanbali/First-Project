package login;

import java.util.Random;

public class dev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] myNames = {"Abdullah","Omar","Yazan","Ali"};
		
		Random rand = new Random();
		
		int myRandomNumber = rand.nextInt(myNames.length);
		
		System.out.println(myRandomNumber);

	}

}
