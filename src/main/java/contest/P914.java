package contest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P914 {
	public static void main(String[] args) {
		boolean ret = new P914().hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,2,2});
		System.out.println(ret);
	}
	
	private int gcd(int a,int b){
		if(b==0)return a;
		return gcd(b,a%b);
	}
	
    public boolean hasGroupsSizeX(int[] deck) {
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<deck.length;i++){
    		map.merge(deck[i], 1, (a,b)->a+b);
    	}
    	Iterator<Integer> it = map.keySet().iterator();
    	int gcd = -1;
    	while(it.hasNext()){
    		if(gcd == -1){
    			gcd = map.get(it.next());
    		}
    		else {
    			int a = map.get(it.next());
    			int b = gcd;
    			if(a<b){
    				b=a;
    				a=gcd;
    			}
    			gcd = gcd(a,b);
    		}
    	}
    	
    	return gcd>=2;
    }

}
