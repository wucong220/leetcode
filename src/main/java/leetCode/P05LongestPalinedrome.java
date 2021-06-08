package leetCode;

public class P05LongestPalinedrome {
	    public String longestPalindrome(String s) {
	        char[] ch = s.toCharArray();
	        boolean[][] d= new boolean[s.length()][s.length()];
	        int max = 0;
	        int mj=0;
	        for(int i=0;i<s.length();i++){
	        	for(int j=i;j<s.length();j++){
	        		if(i==0)d[j][j]=true;
	        		else if(i==1)d[j-1][j]=s.charAt(j)==s.charAt(j-1)?true:false;
	        		else d[j-i][j]=(s.charAt(j-i)==s.charAt(j)&&d[j-i+1][j-1])?true:false;
	        		if(d[j-i][j]){
	        			if(i+1>max){max = i+1;
	        				mj = j; 
	        			}
	        		}
	        	}
	        }
	        return s.substring(mj+1-max,mj+1);
	    }
	    
	    public static void main(String[] args) {
			System.out.println(new P05LongestPalinedrome().longestPalindrome("aacdefcaa"));
		}
}
