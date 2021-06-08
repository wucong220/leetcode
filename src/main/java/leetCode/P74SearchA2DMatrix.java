package leetCode;

public class P74SearchA2DMatrix {
	public int biSearch(int[] input,int target){
		int low=0;
		int high=input.length-1;
		int mid=0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(target>input[mid]){
				low = mid+1;
			}
			else if(target<input[mid]){
				high = mid -1;
			}
			else 
				return mid;	
		}
		return -1;
	}
	
	public int biSearchMatrix(int[][] input,int target){
		int low=0;
		int high=input.length-1;
		int mid=0;
		while(low<=high){
			mid = low + (high-low)/2;
			if(target>input[mid][0]){
				low = mid+1;
			}
			else if(target<input[mid][0]){
				high = mid -1;
			}
			else 
				return mid;	
		}
		if(input[mid][0]>target&&mid>0)
			return mid-1;
		return mid;
	}
	
	
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowindex = biSearchMatrix(matrix,target);
        int index = biSearch(matrix[rowindex], target);
    	
        if(index>=0)
        	return true;
    	return false;
    }	
}
