package contest;

public class P856ScoreofParentheses {
	static private boolean isBalancedParentheses(String S){
		int top = -1;
		for(int i=0;i<S.length();i++){
			if(S.charAt(i)=='(')top++;
			else top--;
			
			if(top<-1)return false;
		}
		if(top==-1)return true;
		else return false;
	}
	
    static public int scoreOfParentheses(String S) {
        if(S.length()==0)return 0;
        if(S.equals("()"))return 1;
        
        int ret =0;
        String lower = S.substring(1,S.length()-1);
        if(isBalancedParentheses(lower)){
        	ret = scoreOfParentheses(lower)*2;
        }
        else{
        	int top = -1;
        	int index = -1;
        	for(int i=0;i<S.length();i++){
        		if(S.charAt(i)=='(')top++;
        		else top--;
        		
        		if(top==-1){index=i+1;break;}
        	}
        	ret = scoreOfParentheses(S.substring(0,index))+scoreOfParentheses(S.substring(index));
        }
        return ret;
    }
    public static void main(String[] args) {
		System.out.println(scoreOfParentheses("()()"));
	}
}
