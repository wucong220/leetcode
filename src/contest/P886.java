package contest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class P886 {
	class Position{
		int pointl;
		int pointh;
		int po;
		public Position(int pointl, int pointh, int po) {
			super();
			this.pointl = pointl;
			this.pointh = pointh;
			this.po = po;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + po;
			result = prime * result + pointh;
			result = prime * result + pointl;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			
			Position other = (Position) obj;
			if (po != other.po)
				return false;
			if (pointh != other.pointh)
				return false;
			if (pointl != other.pointl)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Position [pointl=" + pointl + ", pointh=" + pointh + ", po=" + po + "]";
		}
		
	}
	
    public int reachableNodes(int[][] edges, int M, int N) {
        int[][] matrix = new int[N][N];
        for(int i=0;i<N;i++){
        	Arrays.fill(matrix[i], -1);
        }
        for(int i=0;i<edges.length;i++){
        	matrix[edges[i][0]][edges[i][1]]=matrix[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        Queue<Position> q = new LinkedList<>();
        Set<Position> visit = new HashSet<>();
        int count=M;
        int ret =1 ;
        Position init;
        q.offer(init=new Position(0,0,0));
        visit.add(init);
        while(!q.isEmpty()&&count>0){
        	int qs = q.size();
        	for(int i=0;i<qs;i++){
        		Position curr =  q.poll();
        		if(curr.po==0){		
        			for(int j=0;j<N;j++){
        				int lenth;
        				if((lenth=matrix[curr.pointl][j])>=0){
        					int pointl,pointh,po;
        					if(j<curr.pointl){
	        					 pointl = j;
	        					 pointh = curr.pointl;
	        					 po = lenth;
	        					if(lenth==0){
	        						pointh = pointl;
	        					}
        					}
        					else{
	        					 pointl = curr.pointl;
	        					 pointh = j;
	        					 po = 1;
	        					 if(lenth==0){
	        						 po=0;
	        						 pointl = pointh;
	        					 }
        					}
        					Position temp;
        					if(visit.add(temp=new Position(pointl, pointh, po))){
        						q.offer(temp);
        						ret++;
        					};
        					
        				}
        			}
        		}
        		else{
        			int lpointl,rpointl,lpointh,rpointh,lpo,rpo;
        			lpointl=rpointl=curr.pointl;
        			lpointh=rpointh=curr.pointh;
        			lpo=rpo=curr.po;
        			int lenth = matrix[curr.pointl][curr.pointh];
					Position temp;
					if(rpo==lenth){rpointl = rpointh;rpo=-1;}
					if(visit.add(temp=new Position(rpointl, rpointh, rpo+1))){
						q.add(temp);
						ret++;
					};
					if(lpo == 1)lpointh = lpointl;
					if(visit.add(temp=new Position(lpointl, lpointh, lpo-1))){
						q.offer(temp);
						ret++;
					};
        			
        		}	
        	}
        	count--;
        }
    	return ret;
    }
    
    public static void main(String[] args) {
    	int edges[][] = {{3,4,8},{0,1,3},{1,4,0},{1,2,3},{0,3,2},{0,4,10},{1,3,3},{2,4,3},{2,3,3},{0,2,10}}, M = 7, N = 5;
    	System.out.println(new P886().reachableNodes(edges, M, N));
    	
	}
}
