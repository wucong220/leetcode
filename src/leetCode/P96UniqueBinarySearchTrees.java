package leetCode;

import java.util.ArrayList;
import java.util.List;

public class P96UniqueBinarySearchTrees {
	
	//超时
	static public int numTrees1(int n) {
		return numTrees1(1, n);
	}

	static public int numTrees1(int m, int n) {
		
		int ret=0;
		if(m==n){return 1;}
		if(m+1==n){
			return 2;
		}
		for (int i = m; i <= n; i++) {
			int lSubtrees = 0;
			int rSubtrees = 0;
			if (i > m) {
				lSubtrees = numTrees1(m, i - 1);
			}
			if (i < n) {
				rSubtrees = numTrees1(i + 1, n);
			}
            
			if(i<n&&i>m){
				ret+= lSubtrees*rSubtrees;
			}
			else if(i==n){
				ret+=lSubtrees;
			}	
			else if(i==m){
				ret+=rSubtrees;
			}
			
		}
		return ret;
	};
	
	
	static public int numTrees(int n) {
		
		int[] d = new int[n+1];
		for(int i=0;i<n;i++){
			if(i==0)d[i]=0;
			else if(i==1)d[i]=1;
			else if(i==2)d[i]=2;
			else{
				d[i]=
				
			}
		}
		
		
		return numTrees1(1, n);
	}
	
	public static void main(String[] args) {
		System.out.println(numTrees1(4));
	}
}
