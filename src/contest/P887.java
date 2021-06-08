package contest;

public class P887 {
    public int projectionArea(int[][] grid) {
        int z = grid.length*grid.length;
        for(int i =0;i<grid.length;i++){
        	for(int j=0;j<grid.length;j++){
        		if(grid[i][j]==0)z-=1;
        	}
        }
        
        int x = 0;
        for(int i=0;i<grid.length;i++){
        	x+=getXMax(grid[i]);
        }
        int y=0;
        for(int i=0;i<grid.length;i++){
        	y+=getYMax(grid,i);
        }
    	return x+y+z;
    }

	private int getXMax(int[] is) {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i=0;i<is.length;i++){
			if(is[i]>max)max=is[i];
		}
		return max;
	}
	
	private int getYMax(int[][] is,int column) {
		// TODO Auto-generated method stub
		int max = 0;
		for(int i=0;i<is.length;i++){
			if(is[i][column]>max)max=is[i][column];
		}
		return max;
	}
}
