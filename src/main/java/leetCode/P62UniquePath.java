package leetCode;

public class P62UniquePath {
	
	static public long jieCheng(long n){
		long ret=1;
		while(n>0){
			ret*=(n--);
		}
		System.out.println(ret);
		return ret;
	}
	
	static public long jieCheng(long n,long m){
		long ret=1;
		while(n>m){
			ret*=(n--);
		}
		System.out.println(ret);
		return ret;
	}
	
	
	
    static public int uniquePaths(int m, int n) {
        long a = m-1;
        long b = n-1;
        if(a<b){
        	a=n-1;
        	b=m-1;
        }
        
    	return (int) (jieCheng(a+b,a)/jieCheng(b));
    	
    	
    }
    public static void main(String[] args) {
		System.out.println(jieCheng(36));
		System.out.println(uniquePaths(36,	 36));
	}
}
