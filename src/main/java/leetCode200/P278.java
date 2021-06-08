package leetCode200;

public class P278 {
    public int firstBadVersion(int n) {
    	int low = 1;
    	int high = n;
    	while(low<high){
    		int mid = low+(high-low)/2;
    		if(isBadVersion(mid)){
    			high = mid;
    		}
    		else{
    			low = mid+1;
    		}
    	}
    	return high;
    	TreeMap
    }
    
    
    boolean isBadVersion(int n){return false;}
}
