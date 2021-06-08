package leetCode800;

import java.util.Arrays;

public class P887 {
    static public int superEggDrop(int K, int N) {
    	int[][] d = new int[K+1][N+1];
    	for(int i=1;i<=K;i++){
    		for(int j=1;j<=N;j++){
    			if(i==1){
    				d[i][j]=j;
    			}
    			else if(j==1){
    				d[i][j]=1;
    			}
    			else {
    				int l=1;
    				int r=j+1;
    				while(l<r){
    					int mid = l+(r-l)/2;
    					if(d[i-1][mid-1]>=d[i][j-mid]){
    						r=mid;
    					}
    					else{
    						l=mid+1;
    					}
    				}
    				d[i][j]=1+Math.min(Math.max(d[i-1][l-1], d[i][j-l]), Math.max(d[i-1][(l-1)-1], d[i][j-(l-1)]));
    			}
    		}
    	} 	
    	return d[K][N];
    }
    public static void main(String[] args) {
    	System.out.println(superEggDrop(2, 100));
    	
//    	int i=0;
//    	int[] array = new int[]{1,2};
//    	
//    	array[++i]=--i;
//    	System.out.println(Arrays.toString(array));
//    	new T().print();
	}
}

class F{
	String str = "aaa";
}

class T extends F{
	
	public void print(){
		System.out.println(this.str);
	}
}
