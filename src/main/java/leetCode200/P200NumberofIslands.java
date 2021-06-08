package leetCode200;

import java.util.LinkedList;
import java.util.Queue;

public class P200NumberofIslands {
    
	public int numIslands(char[][] grid) {
		int count=0;
		for(int x=0;x<grid.length;x++){
			for(int y=0;y<grid[0].length;y++){
				if(grid[x][y]=='1'){
					count++;
					bfs(grid,x,y);
				}
			}
		}
    	
    	return count;
    }
    
    void bfs(char[][] grid,int x,int y){
    	Queue<int[]> q = new LinkedList<>();
    	q.offer(new int[]{x,y});
    	while(!q.isEmpty()){
    		int[] cur = q.poll();
    		char c;
    		int X,Y;
    		if((c=grid[X=cur[0]][Y=cur[1]])=='1')
    			grid[X][Y] = '#';
    		else if(c=='#'||c=='0')
    			continue;
    		
    		if(X>0)q.offer(new int[]{X-1,Y});
    		if(X<grid.length-1)q.offer(new int[]{X+1,Y});
    		if(Y>0)q.offer(new int[]{X,Y-1});
    		if(Y<grid[0].length-1)q.offer(new int[]{X,Y+1});
    	}
    }
}
