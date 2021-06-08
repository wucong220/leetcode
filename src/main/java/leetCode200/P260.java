package leetCode200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P260 {
    public int[] singleNumber(int[] nums) {
        Integer pair = null;
        List<Integer> ret = new ArrayList<>(2);
        
        Arrays.sort(nums);
    	int i = 0;
        for(int j=0;j<nums.length;j++){
            if(pair==null){
            	pair=nums[i];
            }
            else{
            	if(nums[i]==pair){
            		pair=null;
            	}
            	else{
            		ret.add(pair);
            		pair=nums[i];
            	}
            }
        }
        
        return new int[]{ret.get(0),ret.get(1)};
    }
    
    public static void main(String[] args) {
		new P260().singleNumber(new int[]{1,2,1,3,2,5});
	}
}
