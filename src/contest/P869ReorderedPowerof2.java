package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P869ReorderedPowerof2 {
    public boolean reorderedPowerOf2(int N) {
        String s = String.valueOf(N);
        int length = s.length();
        Map<Integer,List<String>> dic = new HashMap<>();
        for(int i=1;i>0&&i<=Integer.MAX_VALUE;i=i*2){
        	String str = String.valueOf(i);
        	int len = str.length();
        	if(dic.containsKey(len)){
        		dic.get(len).add(str);
        	}
        	else{
        		List<String> l  = new ArrayList<String>();
        		l.add(str);
        		dic.put(len, l);
        	}
        }
        List<String> ls = dic.get(length);
        for(int i=0;i<ls.size();i++){
        	if(hasSameChar(ls.get(i),s))return true;
        }
        return false;
    }
    
    private boolean hasSameChar(String s1,String s2){
    	char[] ch1 = s1.toCharArray();
    	char[] ch2 = s2.toCharArray();
    	Arrays.sort(ch1);
    	Arrays.sort(ch2);
    	for(int i=0;i<ch1.length;i++){
    		if(ch1[i]!=ch2[i])return false;
    	}
    	return true;
    }
    public static void main(String[] args) {
		boolean ret = new P869ReorderedPowerof2().reorderedPowerOf2(46);
		System.out.println(ret);
	}
}
