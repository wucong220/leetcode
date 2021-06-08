package contest;

import java.util.Arrays;

public class P888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0,sumB=0;
        for(int i=0;i<A.length;i++){
        	sumA+=A[i];
        }
        for(int i=0;i<B.length;i++){
        	sumB+=B[i];
        }
        if(sumA==sumB)return new int[]{0,0};
        int gap = Math.abs(sumA-sumB);
        int half_gap = gap/2;


    	for(int i=0;i<A.length;i++){
    		for(int j=0;j<B.length;j++){
    			if(sumA>sumB&&A[i]-B[j]==half_gap){
    				return new int[]{A[i],B[j]};
    			}
    			else if(sumB>sumA&&B[j]-A[i]==half_gap){
    				return new int[]{A[i],B[j]};
    			}
    		}
    	}
    	return null;
        
    	
    }
}
