package leetCode100;

public class P190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	
        for(int i=0;i<16;i++){
        	//不同        	
        	if((((n>>>i)^(n>>>(31-i)))&1)==1){
        		 n^=(1<<i);   //和1按位与就是取反，和0按位与就是不变
        		 n^=(1<<(31-i));
        	};
        }
        return n;
    }
    
    public static void main(String[] args) {
		System.out.println(new P190ReverseBits().reverseBits(43261596));
	}
}
