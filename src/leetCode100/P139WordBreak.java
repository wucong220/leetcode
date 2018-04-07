package leetCode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P139WordBreak {
	//Time limit Exceeded
    static public boolean wordBr1eak(String s, List<String> wordDict) {
    	boolean ret = false;
    	if(s.length()==0)
    		return true;
    	for(String prefix:wordDict){	
    		if(s.startsWith(prefix))
    		ret = ret||wordBreak(s.substring(prefix.length()),wordDict);
    		if(ret)return ret;
    	}
    	return ret;
    }
    
    static public boolean wordBreak(String s, List<String> wordDict){
    	
    	boolean[] dj = new boolean[s.length()+1];
    	
    	Collections.sort(wordDict,new Comparator<String>(){


			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				
				return o1.length()-o2.length();
			}});
    	
    	for(int i = 0;i<=wordDict.size();i++){
    		dj[0] = true;
    	}
    	for(int i=1;i<=s.length();i++){
    		for(int j=1;j<=wordDict.size();j++){
    			String word = wordDict.get(j-1);
    			int wordl = word.length();
    			if(i>=wordl&&match(s,i-wordl,word)){
    				dj[i]=dj[i]||dj[i-wordl];
    			}
    		}
    	}
    	return dj[s.length()];
    }
    static public boolean match(String s,int start,String b){
    	for(int i=0;i<b.length();i++){
    		if(s.charAt(i+start)!=b.charAt(i))return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	String s = "dogs";
    	ArrayList<String> as = new ArrayList<>(Arrays.asList("dog","s","gs"));
    	System.out.println(wordBreak(s,as));
	}
}
