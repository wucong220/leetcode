package contest;

public class P884 {
    public String decodeAtIndex(String S, int K) {
        int lenth = 0;
    	for(int i=0;i<S.length();i++){
    		char c;
        	if((c=S.charAt(i))>='0'&&c<='9'){
        		lenth*=(c-'0');
        	}
        	else{
        		lenth++;
        	}
        	if(lenth>=K)break;
        }
    	
    	if(lenth<K){
    		K=K%lenth;
    	}
    	
    	for(int i=0;i<S.length();i++){
    		
        }
    	
    	return null;
    }
}
