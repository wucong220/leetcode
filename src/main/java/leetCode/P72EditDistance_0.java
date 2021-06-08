package leetCode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class P72EditDistance_0 {
	
	
    public int minDistance(String word1, String word2) {
    	
    	return 0;
    }
    
    int min(int x,int y,int j){
    	if(x>y&&x>j) return x;
    	if(y>x&&y>j) return y;
    	return j;
    }
    
    private int dp(String word1,String word2){
    	int [][] d = new int[word1.length()+1][word2.length()+1];
    	for(int i=0;i<word1.length()+1;i++){
    		for(int j=0;j<word2.length()+1;j++){
    			if(i==0){
    				d[i][j] = j;
    			}
    			else
    			if(j==0){
    				d[i][j] = i;
    			}
    			else
    			if(word1.charAt(i-1)==word2.charAt(j-1)){
    				d[i][j] = d[i-1][j-1];
    			}
    			else{
    				d[i][j] = min(d[i-1][j],d[i][j-1],d[i-1][j-1])+1;
    			}
    			
    		}
    	}
    	return d[word1.length()][word2.length()];
    }
    
    
    private int bfs(String word1,String word2){
    	Set<Character> dic = new HashSet<>();
    	for(char c:word2.toCharArray()){
    		dic.add(c);
    	}
    	
    	
    	if(word1.equals(word2))return 0;
    	else{
    		Queue<String> q = new ArrayDeque<>();
    		Set<String> visited = new HashSet<>();
    		int step = 0;
    		q.offer(word1);
    		while(!q.isEmpty()){
    			
    			for(int i=0;i<q.size();i++){
    				String curr = q.poll();
    				if(curr.equals(word2))return step;
    				if(curr.length()<=word2.length()){
    					StringBuilder sb = new StringBuilder(curr);
    					for(int j=0;j<=sb.length();j++){
    						for(char k:dic){
    							sb.insert(j, k);
    							if(visited.add(sb.toString())){
    								q.offer(sb.toString());
    							}
    							sb.deleteCharAt(j);
    						}
    					}
    				}
    				
    				if(curr.length()>=word2.length()){
    					StringBuilder sb = new StringBuilder(curr);
    					for(int j=0;j<sb.length();j++){
    							char temp = sb.charAt(j);
    							sb.deleteCharAt(j);
    							if(visited.add(sb.toString())){
    								q.offer(sb.toString());
    							}
    							sb.insert(j, temp);
    					}
    				}
    				StringBuilder sb = new StringBuilder(curr);
					for(int j=0;j<sb.length();j++){
						for(char k:dic){
							char temp = sb.charAt(j);
							if(temp!=k){
							sb.setCharAt(j, k);
							if(visited.add(sb.toString())){
								q.offer(sb.toString());
							}
							sb.setCharAt(j,temp);
							}
						}
					}
    			}
    			step++;
    		}
    	}
		return 0;
    }
    
    public static void main(String[] args) {
		int ret = new P72EditDistance_0().bfs("intention", "execution");
		System.out.println(ret);
	}
}
