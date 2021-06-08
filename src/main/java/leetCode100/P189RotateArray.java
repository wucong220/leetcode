package leetCode100;

public class P189RotateArray {
    //o(k) o(n)
	public void rotate(int[] nums, int k) {
    	k=k%nums.length;
        int[] t = new int[k];
        System.arraycopy(nums, nums.length-k,t, 0, k);
        System.arraycopy(nums, 0,nums, k, nums.length-k);
        System.arraycopy(t, 0, nums, 0, k);
    }
    
    //o1 o(nk)
    public void rotateo1(int[] nums, int k) {
    	for(int i=0;i<k%nums.length;i++){
    		int temp = nums[nums.length-1];
    		for(int j=nums.length-1;j>0;j--){
    			nums[j]=nums[j-1];
    		}
    		nums[0]=temp;
    	}
    }
}
