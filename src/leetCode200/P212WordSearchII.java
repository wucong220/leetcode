package leetCode200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P212WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
    	if(board.length<1||board[0].length<1||words.length<1)return new ArrayList<>();
    	
    	
    	List<String> ret = new ArrayList<>();
    	Map<Character,Set<String>> map = new HashMap<>();
    	for(String word:words){
    		if(map.containsKey(word.charAt(0))){
    			map.get(word.charAt(0)).add(word);
    		}
    		else{
	    		Set<String> l =new HashSet<String>();
	    		l.add(word);
	    		map.put(word.charAt(0),l );
    		}
    	}
    	
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[0].length;j++){
    			if(map.containsKey(board[i][j])){
    				Set<String> l = map.get(board[i][j]);
    				Iterator<String> it = l.iterator();
    				while(it.hasNext()){
    					String matching = it.next();
    					boolean[][] used = new boolean[board.length][board[0].length];
    					if(realFindWords(board,used,i,j,matching,0)){
    						it.remove();
    						ret.add(matching);
    					}
    				}                                                                                                                                                                                                                                                                                                                                                                                                                          	
    				if(l.isEmpty()){
    					map.remove(board[i][j]);
    				}
    			}
    		}
    	}
    	return ret;
    }

	private boolean realFindWords(char[][] board,boolean[][] used, int x,int y,String word,int pos) {
		// TODO Auto-generated method stub
		if(pos==word.length()-1)return true;
		used[x][y]=true;
		if(getUp(board,x,y)==word.charAt(pos+1)&&used[x-1][y]==false){
			if(realFindWords(board, used, x-1, y, word,pos+1))return true;
		}
		if(getLeft(board,x,y)==word.charAt(pos+1)&&used[x][y-1]==false){
			if(realFindWords(board, used, x, y-1, word,pos+1))return true;
		}
		if(getDown(board,x,y)==word.charAt(pos+1)&&used[x+1][y]==false){
			if(realFindWords(board, used, x+1, y, word,pos+1))return true;
		}
		if(getRight(board,x,y)==word.charAt(pos+1)&&used[x][y+1]==false){
			if(realFindWords(board, used, x, y+1, word,pos+1))return true;
		}
		used[x][y]=false;
		return false;
	}

	private Character getUp(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(x>0)return board[x-1][y];
		else return '*';
	}
	private Character getLeft(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(y>0)return board[x][y-1];
		else return '*';
	}
	private Character getDown(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(x<board.length-1)return board[x+1][y];
		else return '*';
	}
	private Character getRight(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(y<board[0].length-1)return board[x][y+1];
		else return '*';
	}
	public static void main(String[] args) {
		List<String> l=new P212WordSearchII().findWords(
new char[][]{ {'o','a','a','n'},
			  {'e','t','a','e'},
			  {'i','h','k','r'},
			  {'i','f','l','v'}}
, new String[]{"oath","pea","eat","rain"});
		System.out.println(l);
	}
}

