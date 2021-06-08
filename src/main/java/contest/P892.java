package contest;

public class P892 {
	public static void main(String[] args) {
		
	}
	
    public int surfaceArea(int[][] grid) {
    	if(grid.length==0)return 0;
    	int sum=0;
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			sum+= 4*grid[i][j]+2;
    			if(i<grid.length-1){
    				sum-=2*Math.min(grid[i+1][j],grid[i][j]);
    			}
    			if(j<grid[0].length-1){
    				sum-=2*Math.min(grid[i][j+1],grid[i][j]);
    			}
    		}
    	}
    	return sum;
    }
}
