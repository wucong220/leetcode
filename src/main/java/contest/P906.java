package contest;

public class P906 {
    public static void main(String[] args) {
    	int ret =superpalindromesInRange("4", "1000");
    	System.out.println(ret);
    	Map
    }
    
	static public int superpalindromesInRange(String L, String R) {
        int l = Integer.parseInt(L);
        int r = Integer.parseInt(R);
        
        int count=0;
        for(long i=(long) Math.sqrt(l);i*i<r;i++){
        	if(isPalinedrome(String.valueOf(i))&&isPalinedrome(String.valueOf(i*i))){
        		count++;
        	}
        }
       return count;
    }
    
    static public boolean isPalinedrome(String n){
    	char[] ch = n.toCharArray();
    	int left=0;
    	int right = n.length()-1;
    	while(left<right){
    		if(ch[left]!=ch[right])return false;
    		left++;
    		right--;
    	}
    	return true;
    }
}
