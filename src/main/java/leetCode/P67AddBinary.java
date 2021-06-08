package leetCode;

public class P67AddBinary {
    static public String addBinary(String a, String b) {
    	int i=a.length()-1;
    	int j=b.length()-1;
    	int jw =0;
    	StringBuilder sb = new StringBuilder();
    	while(i>=0&&j>=0){
    		int bitA = a.charAt(i)-'0';
    		int bitB = b.charAt(j)-'0';
    		int bitC = (bitA+bitB+jw)%2;
    		jw = (bitA+bitB+jw)/2;
    		
    		sb.insert(0, (char)(bitC+'0'));
    		i--;j--;
    	}
    	
    	if(i>=0){
    		int bitA = a.charAt(i)-'0';
    		int bitC = (bitA+jw)%2;
    		jw = (bitA+jw)/2;
    		
    		sb.insert(0, (char)(bitC+'0'));
    		i--;
    	}
    	
    	if(j>=0){
    		int bitB = b.charAt(j)-'0';
    		int bitC = (bitB+jw)%2;
    		jw = (bitB+jw)/2;
    		
            sb.insert(0, (char)(bitC+'0'));
    		j--;
    	}
        
        if(jw==1){
            sb.insert(0, '1');
        }
        if(jw==2)sb.insert(0,"11");
        
        return sb.toString();
    }
    public static void main(String[] args) {
		System.out.println(addBinary("1", "111"));
	}
}
