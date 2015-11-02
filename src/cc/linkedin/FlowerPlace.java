package cc.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.careercup.com/question?id=5119852580700160
 * @author rakebulh
 *
 */
public class FlowerPlace {
	
	public static boolean canPlaceFlowers(List<Boolean> fb, int numberToPlace) {
		
		if(fb.size() < numberToPlace) return false;
		List<Boolean> flowerbed = new ArrayList<Boolean>(fb);
		int total = 0;
		if(flowerbed.get(0) == Boolean.FALSE) {
			total++;
			flowerbed.set(0, Boolean.TRUE);
			if(flowerbed.size() > 1 && flowerbed.get(1) == Boolean.TRUE) {
				total--;
				flowerbed.set(0, Boolean.FALSE);
			}
		}
		for(int i = 1; i < flowerbed.size()-1; i++) {
			
			if(flowerbed.get(i) == Boolean.FALSE) {
				if(flowerbed.get(i-1) == Boolean.FALSE && flowerbed.get(i+1) == Boolean.FALSE) {
					total++;
					flowerbed.set(i, Boolean.TRUE);
				}
			}
		}

		if(flowerbed.size() > 0 && flowerbed.get(flowerbed.size()-1) == Boolean.FALSE) {
			total++;
			flowerbed.set(flowerbed.size()-1, Boolean.TRUE);
			if(flowerbed.size() > 1 && flowerbed.get(flowerbed.size()-2) == Boolean.TRUE) {
				total--;
				flowerbed.set(flowerbed.size()-1, Boolean.FALSE);
			}
		}
		//System.out.println(total);
		return total >= numberToPlace;
	}
	
	public static void main(String[] arg) {
		Boolean[] flowers1 = {true,false,false,false,false,false,true,false,false};
		List<Boolean> folwersList1 = Arrays.asList(flowers1);
		System.out.println(canPlaceFlowers(folwersList1, 3));
		System.out.println(canPlaceFlowers(folwersList1, 4));

		Boolean[] flowers2 = {true,false,false,true,false,false,true,false,false};
		List<Boolean> folwersList2 = Arrays.asList(flowers2);
		System.out.println(canPlaceFlowers(folwersList2, 1));
		System.out.println(canPlaceFlowers(folwersList2, 2));
		
		Boolean[] flowers3 = {false};
		List<Boolean> folwersList3 = Arrays.asList(flowers3);
		System.out.println(canPlaceFlowers(folwersList3, 1));
		System.out.println(canPlaceFlowers(folwersList3, 2));		

	
	}

}
