package contest;

public class P849MaximizeDistanceToClosestPerson {
	public static void main(String[] args) {
		System.out.println(maxDistToClosest(new int[]{1,0,0,0}));
	}
    static public int maxDistToClosest(int[] seats) {
    	
    	int max = Integer.MIN_VALUE;
    	int flag=0;
    	int counter =0;
    	for(int i=0;i<seats.length;i++){
    		if(seats[i]==0){
    			if(flag==0){
	    			counter++;
	    			max = Math.max(counter, max);
    			}
    			else{
    				counter++;
    				max = Math.max((counter+1)/2, max);
    			}
	    	}
    		else{
    			counter=0;
    			flag=1;
    		}
    	}
    	max = Math.max(counter, max);
    	
    	return max;
    }
}
