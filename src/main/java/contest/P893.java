package contest;

import java.util.Arrays;

public class P893 {
	public static void main(String[] args) {
		System.out.println(new P893().numSpecialEquivGroups(new String[]{"a","b","c","a","c","c"}));
	}
    public int numSpecialEquivGroups(String[] A) {
    	int ret = A.length;
    	boolean visited[] = new boolean[A.length];
    	for(int i=0;i<A.length;i++){
    		if(visited[i])continue;
    		else{
    			for(int j=i+1;j<A.length;j++){
    				if(isSpecialEquivalent(A[i], A[j])){
    					visited[j] = true;
    					ret--;
    				}
    			}
    		}
    	}
    	
    	return ret;
    }
    
    private boolean isSpecialEquivalent(String a,String b){
    	int e_long,o_long;
    	if(a.length()%2==0)e_long=o_long=a.length()/2;
    	else {e_long=a.length()/2+1;o_long=a.length()/2;}
    	char[] ch_a = a.toCharArray();
    	char[] ch_b = b.toCharArray();
    	char[] ch_a_even = new char[e_long];
    	char[] ch_a_odd = new char[o_long];
    	char[] ch_b_even = new char[e_long];
    	char[] ch_b_odd = new char[o_long];
    	int index_e=0;
    	int index_o=0;
    	for(int i=0;i<a.length();i++){
    		if(i%2==0){
    			ch_a_even[index_e]=ch_a[i];
    			ch_b_even[index_e]=ch_b[i];
    			index_e++;
    		}
    		else{
    			ch_a_odd[index_o]=ch_a[i];
    			ch_b_odd[index_o]=ch_b[i];
    			index_o++;
    		}
    	}
    	Arrays.sort(ch_a_even);
    	Arrays.sort(ch_b_even);
    	Arrays.sort(ch_a_odd);
    	Arrays.sort(ch_b_odd);
    	return String.valueOf(ch_a_even).equals(String.valueOf(ch_b_even))&&String.valueOf(ch_a_odd).equals(String.valueOf(ch_b_odd));
    }
}
