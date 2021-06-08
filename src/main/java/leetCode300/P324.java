package leetCode300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P324 {
    public void wiggleSort(int[] nums) {
        
        List<Integer> l1 = new ArrayList<>();       
        List<Integer> l2 = new ArrayList<>();
        Arrays.sort(nums);
        int partition = -1;
        if(nums.length%2==0)partition = nums.length/2;
        else partition = nums.length/2+1;
        
        for(int i=0;i<nums.length;i++){
            if(i<partition){
                l1.add(nums[i]);
            }
            else {
                l2.add(nums[i]);
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=l1.remove(0);
            }
            else nums[i]=l2.remove(0);
        }
    }
    
    public static void main(String[] args) {
    	int[] nums = new int[]{1, 5, 1, 1, 6, 4};
    	new P324().wiggleSort(nums);
    	System.out.println(Arrays.toString(nums));
	}
}
