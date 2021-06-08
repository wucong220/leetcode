package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class P900 {

}

class RLEIterator {
	TreeMap<Long,Integer> map;
	long index;
	long size;

	public RLEIterator(int[] A) {
		map = new TreeMap<>();
		long start=0;
		for (int i = 0; i < A.length; i += 2) {
			map.put(start, A[i+1]);
			start += A[i];
		}
		size = start;
		index = -1;
	}

	public int next(int n) {
		index+=n;
		if(index<size)
			return map.floorEntry(index).getValue();
		else return -1;
	}
}