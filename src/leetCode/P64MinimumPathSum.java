package leetCode;

public class P64MinimumPathSum {
    static public int minPathSum(int[][] grid) {
        int width = grid[0].length;
    	
    	int[] d = new int[width];
    	
    	for(int i=0;i<grid.length;i++){
    		int[] row =grid[i];
    		for(int j = 0 ;j<width;j++){

    			if(j>0){
        			if(i==0){
        				d[j]=d[j]+d[j-1];
        			}else
    				d[j]=d[j]<d[j-1]?d[j]:d[j-1];
    				
    			}
    			d[j]=d[j]+row[j];
    		}
    	}
    	
    	
    	return d[width-1];
    }
    
    public static void main(String[] args) {
		int[][] input =new int[][]{{1,3,1},
			 {1,5,1},
			 {4,2,1}};
		System.out.println(minPathSum(input));
	}
}
