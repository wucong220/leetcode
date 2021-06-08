package contest;

import java.util.Arrays;

public class P875 {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int sum=0;
        for(int i=0;i<piles.length;i++){
        	sum+=piles[i];
        }
        int min = sum/H+1;
        
        for(int i=0;i<piles.length;i++){
        	if(piles[i]>min)
        }
        
    }
}
