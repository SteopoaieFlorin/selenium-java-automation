package Utils;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomGenerator {
	public static int integerValue(int upperRange) {
		Random random = new Random();
		return random.nextInt(upperRange);
	}
	public static String rndBetween(int min, int max) {
		Random random = new Random();
		int a = random.nextInt(min, max);
		DecimalFormat twodigits = new DecimalFormat("00");
		return twodigits.format(a);
		
	}
	
	
	public static String stringValue(int count) {
		String CHARACTER_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*CHARACTER_STRING.length());
			builder.append(CHARACTER_STRING.charAt(character));
				}
		return builder.toString();
	}
	


}
