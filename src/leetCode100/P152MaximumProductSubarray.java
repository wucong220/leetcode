package leetCode100;

public class P152MaximumProductSubarray {

	static public int maxProduct(int[] nums) {
		Integer positive = null;
		Integer nagative = null;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				positive = null;
				nagative = null;
			} else {
				if (nums[i] > 0) {
					if(positive!=null)positive *= nums[i];
					else positive = nums[i];
					if(nagative!=null)nagative *= nums[i];
				} else {	
					Integer oldnagative = nagative;
					if(positive!=null)nagative = positive *nums[i];
					else nagative = nums[i];
					
					if(oldnagative!=null)positive = oldnagative*nums[i];
					else positive = null;
				}
			}
			if(positive!=null)max = Math.max(max, positive);
			else if(nagative!=null) max = Math.max(max, nagative);
            else max = Math.max(0, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] in = new int[] { 2,-5,-2,-4,3 };
		System.out.println(maxProduct(in));
	}
}
