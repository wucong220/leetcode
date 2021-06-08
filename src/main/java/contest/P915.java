package contest;

public class P915 {
    public int partitionDisjoint(int[] A) {
    	int max = -1;
    	int temp_max = -1;
    	int patential_cutpoint=-1;
    	for(int i=0;i<A.length;i++){
    		if(max==-1){
    			max = A[i];
    			patential_cutpoint=i+1;
    		}
    		else if(A[i]>=max){
    			temp_max = Math.max(A[i],temp_max);
    		}
    		else{
    			if(temp_max != -1){
    				max = temp_max;
    				temp_max = -1;
    			}
    			patential_cutpoint = i+1;
    		}
    	}
    	return patential_cutpoint;
    }
    public static void main(String[] args) {
		System.out.println(new P915().partitionDisjoint(new int[]{24,11,49,80,63,8,61,22,73,85}));
	}
}
