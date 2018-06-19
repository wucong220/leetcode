package leetCode100;

public class P168ExcelSheetColumnTitle {
    static public String convertToTitle(int n) {
    	StringBuilder sb = new StringBuilder();
    	while(n>0){
    		int temp = n;
    		n=n/26;
    		if(temp%26==0){
    			n=n-1;
    			sb.insert(0, 'Z');
    		}
    		else{
    			sb.insert(0, (char)('A'+(temp%26)-1));
    		}
    	}
    	
    	return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(convertToTitle(27));
	}
}
