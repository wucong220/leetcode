package contest;

public class P878NthMagicalNumber {
    public int nthMagicalNumber(int N, int A, int B) {
    	int Actr=0;
    	int Bctr=0;
    	int ctr = 0;
    	long AL=A;
    	long BL=B;
    	if(AL%BL==0)
    	return (int)(BL*N%(1000_000_000+7));
    	else if(BL%AL==0){
    		return (int)(AL*N%(1000_000_000+7));
    	}
    	
    	
    	while(ctr<N){
    		if(AL*(Actr+1)<BL*(Bctr+1)){
    			Actr++;
    		}
    		else if(AL*(Actr+1)>BL*(Bctr+1)){
    			Bctr++;
    		}else{
    			Actr++;
    			Bctr++;
    		}
    		ctr++;
    		
    	}
    	return (int)(Math.max((Actr)*AL,Bctr*BL)%(1000_000_000+7));
    }
	public static void main(String[] args) {
		System.out.println(new P878NthMagicalNumber().nthMagicalNumber(1000_000_000, 39999,40000));
		
	}
}
