package contest;

public class P852PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] A) {
    	for(int i=0;i<A.length;i++){
    		if(A[i]>A[i+1]){
    			return i;
    		}
    	}
    	return -1;
    }
}
