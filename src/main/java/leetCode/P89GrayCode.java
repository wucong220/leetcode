package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P89GrayCode {
    public static List<Integer> grayCode(int n) {
    	if(n==0) return Arrays.asList(0);
    	if(n==1) return Arrays.asList(0,1);
        List<Integer> ret = new ArrayList<Integer>();
    	List<Integer> l= grayCode(n-1);
    	//System.out.println(l);
        ret.addAll(l);
        Collections.reverse(l);

    	for(int i=0;i<l.size();i++){
    		ret.add((int) (Math.pow(2, n-1)+l.get(i)));
    	}
        
        
    	return ret;
    }
    public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
}
