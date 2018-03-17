package leetCode;

public class P69Sqrt {
    static public int mySqrt(int x) {
        long low = 0;
        long high = x;
        long mid = x/2;
        while(low<=high){
        	mid = low+(high-low)/2;
        	if(mid*mid>x){
        		high = mid-1;
        	}
        	else if(mid*mid<x){
        		low = mid+1;
        	}
        	else
        	{
        		return (int)mid;
        	}
        }
        if(mid*mid>x)mid--;
    	
    	
    	return (int)mid;
    }
    
    public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
}
