package leetCode100;

public class P174DungeonGame {
    static public int calculateMinimumHP(int[][] dungeon) {
    	int[][] d = new int[dungeon.length][dungeon[0].length];
    	
    	for(int i=dungeon.length-1;i>=0;i--){
    		for(int j=dungeon[0].length-1;j>=0;j--){
    			if(i==dungeon.length-1&&j==dungeon[0].length-1){
    				if(dungeon[i][j]>=0)d[i][j]=1;
    				else d[i][j] = 1-dungeon[i][j];
    			}
    			else{
    				int temp;
	    			if(i==dungeon.length-1){
	    				temp=d[i][j+1];
	    			}
	    			else if(j==dungeon[0].length-1){
	    				temp=d[i+1][j];			
	    			}
	    			else{
	    				temp = Math.min(d[i+1][j],d[i][j+1]);	
	    			}
	    			if(dungeon[i][j]>=0){d[i][j]=1;if(1+dungeon[i][j]<temp)d[i][j]+=temp-dungeon[i][j]-1;}
					else {d[i][j] = 1-dungeon[i][j];if(1<temp)d[i][j]+=temp-1;} 
    			}
    		}
    	}
    	return d[0][0];
    }
    
    public static void main(String[] args) {
		System.out.println(calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
	}
}
