package contest;

public class P921 {
	public static void main(String[] args) {
		System.out.println(minAddToMakeValid("((("));
	}
	
    static public int minAddToMakeValid(String S) {
    	char[] ch  = S.toCharArray();
    	int left = 0;
    	int right = 0;
    	int top = 0;
    	for(int i=0;i<ch.length;i++){
    		if(top==0){
    			if(ch[i]==')')left++;
    			else top++;
    		}
    		else {
    			if(ch[i]==')')top--;
    			else top++;
    		}
    	}
    	
    	return left+top;
    }
}
