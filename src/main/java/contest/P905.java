package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class P905 {
	public static void main(String[] args) {
		int[] in = new int[]{1,2,3,4};
		System.out.println(Arrays.toString(sortArrayByParity(in)));
	}
	
    static public int[] sortArrayByParity(int[] A) {
    	for(int i=0;i<A.length;i++){
            for(int j=i;j>=1;j--){
            	if(A[j-1]%2==1&&A[j]%2==0){
            		A[j-1]^=A[j];
            		A[j]^=A[j-1];
            		A[j-1]^=A[j];
            	}
            }
        }
    	return A;
    }
}
