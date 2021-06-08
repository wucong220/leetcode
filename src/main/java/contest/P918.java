package contest;

public class P918 {
	public static void main(String[] args) {
		System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
	}

	static public int maxSubarraySumCircular(int[] A) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int j = 0; j < A.length; j++) {
			for (int i = j,k=0;k<A.length ;k++,i = (i + 1) % A.length) {
				if (sum + A[i] < 0) {
					sum = 0;
					if(i>j)j=i;
				}
				else sum+=A[i];
				max = Math.max(sum, max);
			}
			sum = 0;
		}
		if(max==0){
			int min = Integer.MIN_VALUE;
			for(int i:A){
				min = Math.max(min, i);
			}
			return min;
		}
		
		return max;
	}
}
