package offer;

public class NumberOf1Between1AndN_Solution {
	
    static public int numberOf1Between1AndN_Solution(int n) {
        if(n==0)return 0;
        else if(n<10)return 1;
        
    	
    	//得到量级和最高位
    	int y=1,x=n;
    	while(x>=10){
    		x/=10;
    		y*=10;
    	}
    	if(x==1){
    		return n-y+1+numberOf1Between1AndN_Solution(y-1)+numberOf1Between1AndN_Solution(n%y);
    	}
    	else 
    		return y+ x*numberOf1Between1AndN_Solution(y-1)+numberOf1Between1AndN_Solution(n%y);
    }
    
    public static void main(String[] args) {
		System.out.println(numberOf1Between1AndN_Solution(9));
	}
}
