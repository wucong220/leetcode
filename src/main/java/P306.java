
public class P306 {
    public boolean isAdditiveNumber(String num) {
        long a1,a2,a3;
    	for(int i=0;i<num.length()/2;i++){
    		a1 = Long.parseLong(num.substring(0,i+1));
    		for(int j=i+1;j<num.length();j++){
    			if(num.charAt(i+1)=='0')break;
    			else{
    				a2=Long.parseLong(num.substring(i+1,j+1));
    			}
    			for(int k=j+1;k<num.length();k++){
    				if(num.charAt(j+1)=='0')break;
    				else{
    					a3=Long.parseLong(num.substring(j+1,k+1));
    					if(a1+a2==a3){
    						if(isAdditiveNumber(num, a2, a3, k+1))return true;
    					}
    					else if(a1+a2<a3){
    						break;
    					}
    				}
    			}
    		}
    		
    	}
    	
    	return false;
    }
    
    public boolean isAdditiveNumber(String num,Long pre1,Long pre2,int index) {
    	if(index==num.length())return true;
    	long curr = pre1+pre2;
        String curr_str = String.valueOf(curr);
        int len = curr_str.length();
        if(num.substring(index).startsWith(curr_str)){
        	return isAdditiveNumber(num,pre2,curr,index+len);
        }
        else
    	return false;
    }
    public static void main(String[] args) {
		
    	System.out.println(new P306().isAdditiveNumber("12012122436"));
	}
}
