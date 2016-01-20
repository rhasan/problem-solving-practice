package refresh2016.cp.exercise.ch1;

import java.util.Scanner;

/**
 * Using Java, read in a double
 * (e.g. 1.4732, 15.324547327, etc.)
 * echo it, but with a minimum field width of 7 and 3 digits after the decimal point
 * (e.g. ss1.473 (where ‘s’ denotes a space), s15.325, etc.)
 * 
 * @author rakebulh
 *
 */
public class Page12Ex_1_2_3_1_IO_format {
	
	public static void main(String args[]) {
		//InputStream inStream;
		Scanner in = new Scanner(System.in);
		
		double d = in.nextDouble();
		//double d = 1.4732;
		
		System.out.format("%7.3f",d);
		System.out.println();
		
		//d = 15.324547327;
		
		//System.out.format("%7.3f",d);
		in.close();
	}

}
