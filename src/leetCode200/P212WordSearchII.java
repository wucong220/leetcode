package leetCode200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P212WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
    	if(board.length<1||board[0].length<1||words.length<1)return new ArrayList<>();
    	
    	
    	List<String> ret = new ArrayList<>();
    	Map<Character,List<String>> map = new HashMap<>();
    	for(String word:words){
    		if(map.containsKey(word.charAt(0))){
    			map.get(word.charAt(0)).add(word);
    		}
    		else{
	    		List<String> l =new ArrayList<String>();
	    		l.add(word);
	    		map.put(word.charAt(0),l );
    		}
    	}
    	
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j>board.length;j++){
    			if(map.containsKey(board[i][j])){
    				List<String> l = map.get(board[i][j]);
    				for(String matching:l){
    					boolean[][] used = new boolean[board.length][board[0].length];
    					if(realFindWords(board,used,i,j,matching,0)){
    						l.remove(matching);
    						ret.add(matching);
    					}
    				}                                                                                                                                                                                                                                                                                                                                                                                                                          	
    				if(matcheds.isEmpty()){
    					map.remove(board[i][j]);
    				}
    			}
    		}
    	}
    }

	private boolean realFindWords(char[][] board,boolean[][] used, int x,int y,String word,int pos) {
		// TODO Auto-generated method stub
		if(getUp(board,x,y)==word.charAt(pos+1)){
			if(realFindWords(board, used, x-1, y, word,pos+1))return true;
		}
		if(getLeft(board,x,y)==word.charAt(pos+1)){
			if(realFindWords(board, used, x, y-1, word,pos+1))return true;
		}
		if(getDown(board,x,y)==word.charAt(pos+1)){
			if(realFindWords(board, used, x+1, y, word,pos+1))return true;
		}
		if(getRight(board,x,y)==word.charAt(pos+1)){
			if(realFindWords(board, used, x, y+1, word,pos+1))return true;
		}
		return false;
	}

	private Character getUp(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(x>0)return board[x-1][y];
		else return null;
	}
	private Character getLeft(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(y>0)return board[x][y-1];
		else return null;
	}
	private Character getDown(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(x<board.length-1)return board[x+1][y];
		else return null;
	}
	private Character getRight(char[][] board, int x, int y) {
		// TODO Auto-generated method stub
		if(y<board[0].length)return board[x][y+1];
		else return null;
	}
	
	
}
