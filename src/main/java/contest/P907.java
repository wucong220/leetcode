package contest;

import java.util.Deque;
import java.util.LinkedList;

public class P907 {
	public static void main(String[] args) {
		System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
	}
   
    
    static public int sumSubarrayMins(int[] A) {
        Deque<int[]> s1 = new LinkedList<>();
        Deque<int[]> s2 = new LinkedList<>();
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i=0;i<A.length;i++){
        	int count=1;
        	while(!s1.isEmpty()&&s1.peek()[0]>A[i]){
        		count+=s1.pop()[1];
        	}
        	left[i] = count;
        	s1.push(new int[]{A[i],count});
        }
        for(int i=A.length-1;i>=0;i--){
        	int count=1;
        	while(!s2.isEmpty()&&s2.peek()[0]>=A[i]){
        		count+=s2.pop()[1];
        	}
        	right[i] = count;
        	s2.push(new int[]{A[i],count});
        }
        int sum=0;	
        for(int i=0;i<A.length;i++){
        	sum+=A[i]*(left[i])*(right[i])%1000_000_007;	
        }
        return sum;
    }
}
