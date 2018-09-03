package leetCode200;

public class P223 {
	
	
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	if(E>=C||F>=D||G<=A||H<=B){
    			return (C-A)*(D-B)+(G-E)*(H-F);
    	}
    	else{
    		int ret=(C-A)*(D-B);
    		if(E<A){
    			ret+=(A-E)*(D-B);
    		}
    		if(F<B){
    			ret+=(B-F)*(G-E);
    		}
    		if(G>C){
    			ret+=(C-G)*(D-B);
    		}
    		if(H>D){
    			ret+=(H-D)*(G-E);
    		}
    		return ret;
    		
    	}
    }
}
