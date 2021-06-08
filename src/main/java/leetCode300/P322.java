package leetCode300;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P322 {
	public static void main(String[] args) {
		System.out.println(new P322().coinChange(new int[]{2}, 3));
	}
	
	public int coinChange(int[] coins, int amount){
		if(amount==0)return 0;
		Arrays.sort(coins);
		return coinChange(coins,amount,coins.length-1);
	}
	
   
    public int coinChange(int[] coins, int amount,int n) {
    	if(amount==0)return 0;
    	if(n==0){
    		if(amount==coins[0])return 1;
    		else if(amount<coins[0]) return -1;
    	}
    	if(n==-1)return -1;
    	int offset = amount%coins[n];
    	int count = amount/coins[n];
    	int offcount = -1;
    	while(-1==(offcount=coinChange(coins,offset,n-1))&&count>=0){
    		count--;
    		offset+=coins[n];
    	}
    	return offcount==-1?-1:offcount+count;
    }
}
