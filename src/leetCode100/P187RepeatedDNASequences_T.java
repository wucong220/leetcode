package leetCode100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P187RepeatedDNASequences_T {
	static private boolean compare(String s,int a,int b){
		for(int i=0;i<10;i++){
			if(s.charAt(a++)!=s.charAt(b++))return false;
		}
		return true;
	}
    static public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        
        for(int i=0;i<s.length()-10;i++){
        	for(int j=i+1;j<s.length()-9;j++){
        		if(compare(s,i,j)){
        			set.add(s.substring(i,i+10));
        			break;
        		}
        		
        	}
        }
        return new ArrayList<String>(set);
    }
    public static void main(String[] args) {
		System.out.println(findRepeatedDnaSequences("AAAAAAAAAAA"));
	}
}
