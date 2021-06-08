package contest;

import java.util.Arrays;

public class P861ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {
    	long count = 0;
    	int max = 0;
    	while(count<(1L<<(A.length+A[0].length))){
        	int[][] B =Arrays.copyOf(A, A.length);
        	for(int i = 0;i<B.length;i++){
        		B[i] = Arrays.copyOf(A[i],A[i].length);
        	}
        	
        	for(int i=0;i<A.length;i++){
        		if((count&(1<<i))>0){
        			filpRow(B,i);
        		}
        	}
        	for(int i=A.length;i<A.length+A[0].length;i++){
        		if((count&(1<<i))>0){
        			filpColumn(B, i-A.length);
        		}
        	}

        	max = Math.max(max, countSum(B));
        	count++;
    	}  	
		return max;
    }
    
    private int countSum(int[][] A){
    	int sum = 0;
    	for(int i=0;i<A.length;i++){
    		for(int j=0;j<A[0].length;j++){
    			sum+=A[i][j]*(1<<(A[0].length-1-j));
    		}
    	}
    	return sum;
    }
    
    private void filpRow(int[][] A,int row){
    	for(int i=0;i<A[0].length;i++){
    		A[row][i]=1-A[row][i];
    	}
    }
    
    private void filpColumn(int[][] A,int column){
    	for(int i=0;i<A.length;i++){
    		A[i][column]=1-A[i][column];
    	}
    }
    public static void main(String[] args) {
    	int[][] A = new int[][]{{1,1,1,1,0,1,1,1,0,1,0,0,1,0,0,1,1,0,1,1},{1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,1,1},{1,1,0,0,1,0,0,1,0,0,0,0,1,1,1,1,0,0,0,1},{0,1,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,0},{1,1,1,0,1,0,1,0,1,1,0,0,1,0,1,0,1,0,0,0},{0,1,0,0,0,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1},{1,1,1,1,0,0,0,0,1,1,1,1,0,1,0,1,1,0,0,1},{0,1,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1,1,1,1},{1,0,0,0,1,1,0,1,1,1,1,1,1,0,1,0,0,0,1,1},{1,0,1,1,1,0,1,0,0,0,1,1,0,1,1,1,1,0,0,1},{0,1,1,1,0,0,1,0,1,0,1,1,0,1,1,1,0,1,1,0},{0,0,1,1,0,1,0,1,0,1,0,0,0,0,1,1,0,1,1,0},{0,0,1,1,0,0,1,0,1,0,1,0,1,0,0,1,0,1,0,0},{1,1,1,1,1,1,1,0,1,0,1,0,0,1,0,0,1,0,1,0},{1,0,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,0,1,0},{1,1,1,1,1,0,0,0,1,0,0,0,1,1,0,1,0,1,1,0},{0,0,0,0,0,1,1,1,0,0,0,0,1,1,0,1,0,0,0,1},{1,0,0,1,0,1,0,1,1,0,1,1,0,0,0,1,1,0,1,1},{1,0,0,0,1,1,0,0,1,0,1,1,0,0,0,1,0,1,1,0},{1,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0}};
    	System.out.println((1L<<(40)));
    	System.out.println(new P861ScoreAfterFlippingMatrix().matrixScore(A));
    	System.out.println(Integer.MAX_VALUE);
	}
}
