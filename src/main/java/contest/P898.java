package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P898 {
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> temp1 = new HashSet<>();
        Set<Integer> temp2 = new HashSet<>();
        for(int i=0;i<A.length;i++){
            temp2 = new HashSet<>();
            for(int n:temp1){
                temp2.add(A[i]|n);
            }
            temp2.add(A[i]);
            temp1 = temp2;
            System.out.println(temp2);
            set.addAll(temp2);
    	}
    	return set.size();
    }
    
    public static void main(String[] args) {
		int[] A = new int[]{1,1,2};
		System.out.println(subarrayBitwiseORs(A));
	}
}
