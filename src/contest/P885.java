package contest;

import java.util.TreeMap;

public class P885 {
    public int numRescueBoats(int[] people, int limit) {
    	TreeMap<Integer,Integer> map = new TreeMap<>();
    	
    	for(int i=0;i<people.length;i++){
    		map.merge(people[i], 1, (v,nv)->++v);
    	}
    	int ret=0;
    	while(!map.isEmpty()){
    	int biggest = map.lastKey();
    	int li = limit - biggest;
    	map.compute(biggest,(k,v)->{if(v==1)return null;else return --v;} );
    	Integer another=map.floorKey(li);
    	if(another!=null)
    	map.compute(another,(k,v)->{if(v==1)return null;else return --v;} );
    	ret++;
    	}
    	return ret;
    	
    	
    }
    public static void main(String[] args) {
		new P885().numRescueBoats(new int[]{3,2,2,1}, 3);
	}
}
