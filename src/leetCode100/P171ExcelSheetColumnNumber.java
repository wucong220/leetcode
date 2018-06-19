package leetCode100;

public class P171ExcelSheetColumnNumber {
	public static void main(String[] args) {
		System.out.println(titleToNumber("ZY"));
	}
	
    static public int titleToNumber(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;
        for(int i=0;i<ch.length;i++){
        	sum=sum*26+(ch[i]-'A'+1);
        }
    	return sum;
    }
}
