package leetCode200;

import java.util.Arrays;

public class P238 {
	void build(long[] seg,int[] nums ,int index,long left,long right){
		if(left==right){
			seg[index]=nums[(int)left];
		}
		else{
			int m = (int)(left+(right-left)/2);
			build(seg,nums, index*2+1,left,m);
			build(seg,nums, index*2+2,m+1,right);
			seg[index] = seg[index*2+1]*seg[index*2+2];
		}
	}
	
	
	long queryRange(long[] seg,int index,long qleft,long qright,long left,long right){
		if(qleft<=left&&qright>=right){
			return seg[index];
		}
		else if(qleft>right||qright<left){
			return 1;
		}
		else{
			int m = (int)(left+(right-left)/2);
			return queryRange(seg, index*2+1, qleft, qright, left,m)
					*queryRange(seg,index*2+2,qleft,qright,m+1,right);
		}
	}
	
	
    public int[] productExceptSelf(int[] nums) {
    	long[] seg = new long[nums.length*4];
    	build(seg,nums,0,0,nums.length-1);
    	int[] ret = new int[nums.length];
    	for(int i=0;i<nums.length;i++){
    		ret[i] = (i<nums.length-1?(int) queryRange(seg, 0, i+1, nums.length-1, 0, nums.length-1):1)
    				*(i>0?(int) queryRange(seg, 0, 0,i-1, 0, nums.length-1):1);
    	}
    	return ret;
    }
    public static void main(String[] args) {
		int[] input = {1,2,3,4};
		System.out.println(Arrays.toString(new P238().productExceptSelf(input)));
	}
}
