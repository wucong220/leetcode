package leetCode100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P179LargestNumber {
	
	static private boolean compareString(String o1,String o2){
		int i=0,j=0;
		while(true){
			for(;i<o1.length()&&j<o2.length();){
				if(o1.charAt(i)==o2.charAt(j)){i++;j++;}
				else if(o1.charAt(i)>o2.charAt(j)){return true;}
				else return false;			
			}
			if(i<o1.length())j=0;
			else if(j<o2.length())i=0;
			else return true;
		}
	}
    static public String largestNumber(int[] nums) {
        List<String> l = new ArrayList<>();
        for (int i : nums) {
			l.add(String.valueOf(i));
		}
    	Collections.sort(l,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.equals(o2))return 0;
				else if(compareString(o1,o2))return -1;
				else return 1;
			}});
        StringBuilder sb = new StringBuilder();
        for(String s :l){
        	sb.append(s);
        }
        if(sb.charAt(0)=='0')return "0";
    	return sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(largestNumber(new int[]{3,30,34,5,9}));
	}
}
