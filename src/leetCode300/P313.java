package leetCode300;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class P313 {
    static public int nthSuperUglyNumber(int n, int[] primes) {
    	Arrays.sort(primes);
    	TreeSet<Integer> ugly = new TreeSet<>();
    	ugly.add(1);
		for(int p:primes){
			ugly.add(p);
		}
		
		
    	Iterator<Integer> it = ugly.iterator();
    	int ret = 0;
    	for(int i=0;i<n;i++){
    		ret=it.next();
    	}
    	return ret;
    }
    
    public static void main(String[] args) {
		int[] primes={2,7,13,19};
		nthSuperUglyNumber(12, primes);
	}
}
