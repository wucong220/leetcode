package leetCode200;

public class P233 {
    public int countDigitOne(int n) {
    	int n1=n;
    	int c10=1;
    	while(n1/10>0){
    		n1=n1/10;
    		c10*=10;
    	}
    	if(c10==1)return 1;
    	int lower = countDigitOne(n%c10);
    	if(n1>1)
    	return lower*(n1-1)+c10+countDigitOne(c10-1);
    	else
    		return n%c10+1+countDigitOne(c10-1);
    }
    
    public static void main(String[] args) {
		System.out.println(new P233().countDigitOne(13));
	}
    
}
