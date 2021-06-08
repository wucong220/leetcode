package leetCode100;

import java.util.Arrays;

public class P151ReverseWordsInAString {
   static public String reverseWords(String s) {
    	String[] ss=s.split(" ");
    	System.out.println(Arrays.toString(ss));
    	System.out.println();
    	if(ss.length==0||s.length()==0)return "";
    	StringBuilder sb = new StringBuilder(s.length()+1);
		for(int i=ss.length-1;i>=0;i--){
			if(!ss[i].equals(""))
			sb.append(ss[i]).append(' ');
		}
		sb.delete(sb.length()-1, sb.length())
    	;return sb.toString();
    }
    
	public static void main(String[] args) {
		String[] ss = " ".split(" ");
		System.out.println(Arrays.toString(ss)+ss.length);
		ss = "".split(" ");
		System.out.println(Arrays.toString(ss)+ss.length);
		System.out.println(reverseWords(""));
	}
}
