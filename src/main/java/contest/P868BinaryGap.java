package contest;

public class P868BinaryGap {
    public int binaryGap(int N) {
    	int flag = -1;
    	int max = 0;
    	for(int i = 0;i<32;i++){
    		if((N&(1<<i))>0){
    			if(flag==-1){
    				flag = i;
    			}
    			else{
    				max = Math.max(i-flag, max);
    				flag = i;
    			}
    		}
    	}
    	return max;
    }
}
