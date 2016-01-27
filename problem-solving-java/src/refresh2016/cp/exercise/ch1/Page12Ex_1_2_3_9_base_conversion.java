package refresh2016.cp.exercise.ch1;

import java.math.BigInteger;

public class Page12Ex_1_2_3_9_base_conversion {
	public static void main(String[] args) {
		String numberStr = "FF";
		int x = 16;
		
		int y1 = 10;
		int y2 = 2;
		
		System.out.println(new BigInteger(numberStr, x).toString(y1));
		System.out.println(new BigInteger(numberStr, x).toString(y2));
	}
}
