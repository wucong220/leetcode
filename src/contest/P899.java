package contest;

import java.util.Arrays;

public class P899 {
	 public String orderlyQueue(String S, int K) {
	        char[] ch = S.toCharArray();
	        String max = S;
	        if(K==1){
	            for(int i=0;i<S.length();i++){
	                String temp;
	                if(max.compareTo(temp=shift(ch,i))>0){
	                    max  = temp;
	                }            
	            }
	            return max;
	        }
	        else{
	            Arrays.sort(ch);
	            return String.valueOf(ch);
	        }
	    }
	    
	    public String shift(char[] ch,int n){
	        char[] chs = Arrays.copyOf(ch,ch.length);
	        for(int j=0;j<ch.length;j++)
	        {
	            chs[j] = ch[(j+ch.length-n)%ch.length];
	            
	        }  
	        return String.valueOf(chs);
	    }
	    
	    public static void main(String[] args) {
	    	String ret = new P899().orderlyQueue("tk", 1);
	    	System.out.println(ret);
		}
}
