package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class P79WordSearch {
    public static boolean exist(char[][] board, String word) {
    	int heigth = board.length;
    	int width = board[0].length;
    	Word[][] boardm = new Word[heigth][width]; 
    	
    	Map<Character,List<Word>> map =new HashMap<>();
    	for(int i=0;i<heigth;i++){
    		for(int j=0;j<width;j++){
    			List<Word> lw =map.containsKey(board[i][j])?map.get(board[i][j]):new ArrayList<Word>();
    			Word wordd;
    			if(boardm[i][j]==null){
    				wordd = new Word();
    				boardm[i][j] = wordd;
    			}    				
    			lw.add(boardm[i][j]);
				map.put(board[i][j],lw);
				wordd = boardm[i][j];
				wordd.value = board[i][j];
				
				if(i>0)wordd.neigthbors.add(boardm[i-1][j]);
				if(j>0)wordd.neigthbors.add(boardm[i][j-1]);
				if(j<width-1){if(i==0)boardm[i][j+1]=new Word();wordd.neigthbors.add(boardm[i][j+1]);}
				if(i<heigth-1){boardm[i+1][j]=new Word();wordd.neigthbors.add(boardm[i+1][j]);}
    		}
    	}
    	
    		int i=0;
    		if(map.containsKey(word.charAt(i))){
    			List<Word> lw = map.get(word.charAt(i));
    			i++;
    			if(i==word.length())return true;
    			for (Word wordd : lw) {
    				wordd.used=true;
    				Iterator<Word> iterator = wordd.neigthbors.iterator();
    				while(iterator.hasNext()){
    					Word next = iterator.next();
    					if(next.value==word.charAt(i)){
    						i++;
    						if(i==word.length())return true;
    						next.used=true;		
    						if(findAnotherWord(i,word,next))return true;
    						next.used=false;
    						i--;
    					}  					
    				}
    				wordd.used=false;
    				
				}
    		}
    	
    	
    	
		return false;
    }

	private static boolean findAnotherWord(int i,String word,Word curr) {
		// TODO Auto-generated method stub
				Iterator<Word> iterator = curr.neigthbors.iterator();
				while(iterator.hasNext()){
					Word next = iterator.next();
					if(next.value==word.charAt(i)&&next.used==false){
						i++;
						next.used=true;
						if(i==word.length())return true;
						if(findAnotherWord(i,word,next))return true;
						next.used=false;
						i--;
					}  					
				}
				return false;
	}
	public static void main(String[] args) {
		char[][] input = new char[][]{
			/*{'A','B','C','E'},
			  {'S','F','C','S'},
			  {'A','D','E','E'}*/
			{'a','b'}
			,{'c','d'}
			};
		System.out.println(exist(input,"acdb"));
	}
}


class Word{
	char value;
	boolean used = false;
	List<Word> neigthbors = new ArrayList<>();
	@Override
	public String toString() {
		return value + "," + used;
	}
}