package contest;

public class P858MirrorReflection {
    static public int mirrorReflection(int p, int q) {
    	int flag = 1;//¬‰µ„‘⁄”“≤‡
    	int size = q;
    	while(true){
    		if(size%p==0){
    			if(flag==1){
    				if((size/p)%2==1){
    					return 1;
    				}
    				else{
    					return 0;
    				}
        		}
    			else{
    				if((size/p)%2==1){
    					return 2;
    				}
    			}
			}
    		flag =1 -flag;
    		size +=q;
    	}
    }
    public static void main(String[] args) {
		System.out.println(mirrorReflection(2, 1));
	}
}
