package contest;

public class P844BackspaceStringCompare {
    static public boolean backspaceCompare(String S, String T) {
    	StringBuilder sb1=new StringBuilder();
    	StringBuilder sb2=new StringBuilder();
    	int pos=0;
    	for(int i=0;i<S.length();i++){
    		if(S.charAt(i)=='#'){
    			if(pos>0){
    				sb1.delete(pos-1, pos);
    				pos--;
    			}
    		}
    		else{
    			sb1.append(S.charAt(i));
    			pos++;
    		}
    	}
    	pos=0;
    	for(int i=0;i<T.length();i++){
    		if(T.charAt(i)=='#'){
    			if(pos>0){
    				sb2.delete(pos-1, pos);
    				pos--;
    			}
    		}
    		else{
    			sb2.append(T.charAt(i));
    			pos++;
    		}
    	}
    	return sb1.toString().equals(sb2.toString());
    }
    
    public static void main(String[] args) {
    	String S = "ab#c", T = "ad#c";
    	System.out.println(backspaceCompare(S, T));
	}
}
