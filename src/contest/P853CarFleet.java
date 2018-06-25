package contest;

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
		//System.out.println(Arrays.deepToString(pair));
		int fleetctr = position.length;
		while (true) {
			for (int i = 0; i < fleetctr; i++) {
				pair[i][0] += pair[i][1];
			}

			for (int i = fleetctr - 1; i >= 0; i--) {
				if (i == fleetctr - 1) {
					if (pair[i][0] > target) {
						if (i > 0 && (float) (target - pair[i - 1][0]) / pair[i - 1][1] <= (float) (target - pair[i][0])
								/ pair[i][1]) {
							pair[i - 1][0] = pair[i][0];
							pair[i - 1][1] = pair[i][1];
							fleetctr--;
						}else{
							result++;
							fleetctr--;
						}
					} else {
						if (i > 0 && pair[i - 1][0] >= pair[i][0]) {
							pair[i - 1][0] = pair[i][0];
							pair[i - 1][1] = pair[i][1];
							fleetctr--;
						}
					}
				} else {
					if (pair[i][0] > target) {
						if (i > 0 && (float) (target - pair[i - 1][0]) / pair[i - 1][1] <= (float) (target - pair[i][0])
								/ pair[i][1]) {
							pair[i - 1][0] = pair[i][0];
							pair[i - 1][1] = pair[i][1];
							for (int j = i; j < fleetctr - 1; j++) {
								pair[j][0] = pair[j + 1][0];
								pair[j][1] = pair[j + 1][1];
							}
							fleetctr--;
						}
						else{
						result++;
						fleetctr--;
						}
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
			//System.out.println(Arrays.deepToString(pair));;
			if (fleetctr == 0)
				break;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(carFleet(633947, new int[] { 438041,10102,52880,327011,192635,540709,246171,288172,299615,12225 },
				new int[] { 952932,300584,277425,445395,776871,998301,45486,793585,617741,73735 }));
	}
}
