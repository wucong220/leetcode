package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class P841KeysandRooms {
	static public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Set<Integer> keys = new HashSet<Integer>();
		int visitedcount = 0;
		boolean visited[] = new boolean[rooms.size()];
		keys.add(0);
		while (keys.size() > 0) {
			Iterator<Integer> iterator = keys.iterator();
			Set<Integer> newkeys = new HashSet<>(); 
			while (iterator.hasNext()) {
				int key =iterator.next();
				if(visited[key])continue;
				visited[key]=true;
				visitedcount++;
				List<Integer> list = rooms.get(key);
				for (Iterator<Integer> iterator2 = list.iterator(); iterator2.hasNext();) {
					Integer integer = (Integer) iterator2.next();
					newkeys.add(integer);
				}
			}
			keys=newkeys;
		}
		//System.out.println(visited);
		if (visitedcount == rooms.size())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		input.add(new ArrayList<Integer>(Arrays.asList(2,3)));
		input.add(new ArrayList<Integer>());
		input.add(new ArrayList<Integer>(Arrays.asList(2)));
		input.add(new ArrayList<Integer>(Arrays.asList(1,3,1)));
		System.out.println(canVisitAllRooms(input));
	}
}
