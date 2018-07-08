package contest;

public class P867PrimePalindrome {
    public int primePalindrome(int N) {
        for(int i=N;;i++){
        	if(isPalindrome(i)&&isPrime(i)){
        		return i;
        	}
        }
    }
    
    private boolean isPalindrome(int N){
    	long reverse=0;
    	int temp = N;
    	while(N/10>0){
    		reverse = reverse*10 + N%10; 
    		N=N/10;
    	}
    	reverse = reverse*10 + N%10;  //加上最高位
    	
    	if(reverse==temp)return true;
    	
    	return false;
    }
    
    private boolean isPrime(int N){
    	if(N==1)return false;
    	for(int i=2;i<=Math.sqrt(N);i++){
    		if(N%i==0)return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	//System.out.println(new P867PrimePalindrome().primePalindrome(9989900));
    	System.out.println(100_000_0000);
	}
}
