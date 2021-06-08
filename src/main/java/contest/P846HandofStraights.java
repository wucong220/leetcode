package contest;

import java.util.Arrays;

public class P846HandofStraights {
	static public boolean isNStraightHand(int[] hand, int W) {
    	if(hand.length%W!=0)return false;
    	
    	Arrays.sort(hand);
    	int[][] Wset = new int[hand.length/W][W];
    	int[] Wset_index = new int[hand.length/W];
    	Arrays.fill(Wset_index, -1);
    	for(int i=0;i<hand.length;i++){
    		for(int j=0;j<Wset_index.length;j++){
    			if(Wset_index[j]==-1){
    				Wset[j][++Wset_index[j]]=hand[i];
    				break;
    			}
    			else if(Wset_index[j]<W-1){
    				if(Wset[j][Wset_index[j]]==hand[i]-1){
    					Wset_index[j]++;
    					Wset[j][Wset_index[j]]=hand[i];
    					break;
    				}
    			}
    		}
    	}
    	for(int i=0;i<Wset_index.length;i++){
    		if(Wset_index[i]!=W-1)return false;
    	}
    	
    	
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
	}
}
