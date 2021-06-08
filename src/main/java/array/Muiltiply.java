package array;

public class Muiltiply {
	   static  public int[] multiply(int[] A) {
	        int n = A.length;
	        int[] d = new int[n];
	        int[] r = new int[n];
	        d[0] = A[0];
	        
	        for(int i=1;i<n-1;i++){
	            d[i]= d[i-1]*A[i];
	        }
	        r[n-1] = A[n-1];
	        for(int i=n-1-1;i>0;i--){
	            r[i]= r[i+1]*A[i];
	        }
	        int[] B = new int[n];
	        for(int i=0;i<n;i++){
	             if(i==0)B[i]=r[i+1];
	            else if(i==n-1)B[i]=d[i-1];
	            else
	             B[i]=d[i-1]*r[i+1];   
	        }
	        return B;
	    }
}
