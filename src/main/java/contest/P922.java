package contest;

import java.util.Arrays;

public class P922 {
	public static void main(String[] args) {
		int[] array = { 648, 831, 560, 986, 192, 424, 997, 829, 897, 843 };
		System.out.println(Arrays.toString(sortArrayByParityII(array)));
	}

	static public int[] sortArrayByParityII(int[] A) {
        for(int i=0;i<A.length;i++){
        	if(A[i]%2!=i%2){
	        	for(int j=i+1;j<A.length;j++){
	        		if(A[i]%2==1-A[j]%2&&A[j]%2!=j%2){
	        			int temp = A[i];
	        			A[i] = A[j];
	        			A[j] = temp;
	        			break;
	        		}
	        	}
        	}
        }
        return A;
    }
}
