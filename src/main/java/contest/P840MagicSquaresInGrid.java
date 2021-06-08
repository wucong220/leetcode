package contest;

import java.util.HashSet;
import java.util.Set;

public class P840MagicSquaresInGrid {
    public static int numMagicSquaresInside(int[][] grid) {
    	if(grid.length<3)return 0;
    	if(grid[0].length<3)return 0;
    	int ret=0;
    	for(int i=1;i<grid.length-1;i++){
        	for(int j=1;j<grid[0].length-1;j++){
        		if(grid[i][j]==5&&testMagic(grid,i,j))ret++;
        	}
        }
    	
    	return ret;
    }

	static private boolean testMagic(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		Set<Integer> si = new HashSet<Integer>(4);
		int a=0;
		si.add(grid[i-1][j-1]);
		a=grid[i-1][j-1];
		if(a<=0||a>=10)return false;
		si.add(grid[i-1][j]);
		a=grid[i-1][j];
		if(a<=0||a>=10)return false;
		si.add(grid[i-1][j+1]);
		a=grid[i-1][j+1];
		if(a<=0||a>=10)return false;
		si.add(grid[i][j-1]);
		a=grid[i][j-1];
		if(a<=0||a>=10)return false;
		
		if(grid[i-1][j-1]==10-grid[i+1][j+1]
				&&grid[i-1][j]==10-grid[i+1][j]
						&&grid[i-1][j+1]==10-grid[i+1][j-1]
								&&grid[i][j-1]==10-grid[i][j+1]&&si.size()==4)return true;
		else
			return false;
	}
	public static void main(String[] args) {
		System.out.println(numMagicSquaresInside(new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}}));
	}
}
