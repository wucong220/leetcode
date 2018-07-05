package leetCode200;

import java.util.LinkedList;
import java.util.Stack;

public class P214ShortestPalindrome {
	//在前面补最少的字符，让字符串构成回文。
	//源字符串应该是由       （一个回文）+（一串字符） ，我们只需要在前面补上（一串字符）即可，
	//所以我们只需要找到， 由最左边的字符开头的最长的回文。
    public String shortestPalindrome(String s) {
		char[] ch = s.toCharArray();
    	int pos = 0;
    	for(int i=0;i<s.length();i++){
    		if(isPalindrome(ch,0, i))pos = i+1;
    	}
    	
    	return getReverseString(s.substring(pos))+s;
    }
    
    private boolean isPalindrome(char[] ch,int start,int end){
    	while(start<end){
    		if(ch[start++]!=ch[end--]){
    			return false;
    		}
    	}
    	return true;
    }
    
    private String getReverseString(String s){
    	char[] ch = s.toCharArray();
    	for(int i=0;i<ch.length/2;i++){
    		char t = ch[i];
    		ch[i] = ch [ch.length-1-i];
    		ch[ch.length-1-i] = t;
    	}
    	return	String.valueOf(ch);
    }
    
    public static void main(String[] args) {
		System.out.println(new P214ShortestPalindrome().shortestPalindrome("abcd"));
	}
}
