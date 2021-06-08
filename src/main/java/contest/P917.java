package contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class P917 {
	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
	}
	
    static public String reverseOnlyLetters(String S) {
        List<Character> list = new ArrayList<>();
        for(char c:S.toCharArray()){
        	if((c>='a'&&c<='z')||(c>='A'&&c<='Z'))
        	list.add(c);
        }
        Collections.reverse(list);
        char[] ret = S.toCharArray();
        Iterator<Character> it = list.iterator();
        for(int i=0;i<S.length();i++){
        	char c = ret[i];
        	if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
        		ret[i] = it.next();
        	}
        }
    	
    	return String.valueOf(ret);
    }
}
