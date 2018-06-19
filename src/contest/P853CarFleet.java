package contest;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P853CarFleet {
	static public int carFleet(int target, int[] position, int[] speed) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < position.length; i++) {
			map.put(position[i], speed[i]);
		}
		int[][] pair = new int[position.length][2];
		int result = 0;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		for (int i = 0; it.hasNext(); i++) {
			Entry<Integer, Integer> entry = it.next();
			pair[i][0] = entry.getKey();
			pair[i][1] = entry.getValue();
		}
		System.out.println(Arrays.deepToString(pair));
		int fleetctr = position.length;
		while (true) {
			for (int i = 0; i < fleetctr; i++) {
				pair[i][0] += pair[i][1];
			}
			
			for (int i = fleetctr - 1; i >= 0; i--) {
				if (i == fleetctr - 1) {
					if (pair[i][0] > target) {
						result++;
						fleetctr--;
					} else {
						if (i > 0 &&pair[i - 1][0] >= pair[i][0]) {
							pair[i - 1][0] = pair[i][0];
							pair[i - 1][1] = pair[i][1];
							fleetctr--;
						}
					}
				} else {
					if (pair[i][0] > target) {
						result++;
						fleetctr--;
					} else {
						if (i > 0 && pair[i - 1][0] >= pair[i][0]) {
							pair[i - 1][0] = pair[i][0];
							pair[i - 1][1] = pair[i][1];
							for (int j = i; j < fleetctr - 1; j++) {
								pair[j][0] = pair[j + 1][0];
								pair[j][1] = pair[j + 1][1];
							}
							fleetctr--;
						}
					}
				}
			}
			System.out.println(Arrays.deepToString(pair)+result);
			if(fleetctr==0)break;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(carFleet(21, new int[] { 1,15,6,8,18,14,16,2,19,17,3,20,5 }, new int[] {8,5,5,7,10,10,7,9,3,4,4,10,2}));
	}
}
