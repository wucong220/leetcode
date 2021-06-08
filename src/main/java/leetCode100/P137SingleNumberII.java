package leetCode100;

import java.util.HashMap;



/*againest1
public int singleNumber(int[] A) {
    int ones = 0, twos = 0;
    for(int i = 0; i < A.length; i++){
        ones = (ones ^ A[i]) & ~twos;
        twos = (twos ^ A[i]) & ~ones;
    }
    return ones;
}*/

public class P137SingleNumberII {
	public int singleNumber(int[] nums) {
		int a = 0;
		int b = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			a^=nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			b&=nums[i];
		}
		return a;
	}
}
