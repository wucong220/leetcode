package leetCode;

public class P60PermutationSequence {
	static public void quickSort(int[] input,int start,int end){
		if(start>=end){
			return;
		}
		int i=start;
		int j=end;
		int key = input[i];
		while(i<j){
			while(input[j]>=key&&i<j)j--;
			if(i<j)input[i]=input[j];
			while(input[i]<=key&&i<j)i++;
			if(i<j)input[j]=input[i];
		}
		input[i] = key;
		quickSort(input,start,i-1);
		quickSort(input,i+1,end);
	}
	
	
	static public void nextPermutation(int[] nums) {
		int i;
		for ( i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				quickSort(nums,i,nums.length-1);
				break;
			}
		}
		if(i==0){
			quickSort(nums,0,nums.length-1);
			return;
		}
		for(int j=i-1;j<nums.length;j++){
			if(nums[j]>nums[i-1]){
				int temp = nums[i-1];
				nums[i-1] = nums[j];
				nums[j] = temp;
				break;
			}
		}
	}
    static public String getPermutation(int n, int k) {
        int[] input = new int[n];
        for(int i =0 ;i<n;i++){
        	input[i]=i+1;
        }
        k--;
        while(k-->0){
        	nextPermutation(input);;
        }
        char[] ret=  new char[n];
        for(int i = 0;i<n;i++){
        	ret[i] = (char)('0'+input[i]);
        }

        return String.valueOf(ret);
    }
    
    public static void main(String[] args) {
		System.out.println(getPermutation(3, 1));
	}
}
