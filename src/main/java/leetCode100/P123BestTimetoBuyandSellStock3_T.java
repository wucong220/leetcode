package leetCode100;

public class P123BestTimetoBuyandSellStock3_T {
	
	//Time Limit Exceeded↓
    public int maxProfit1(int[] prices,int start,int end) {
        Integer maxprofit=null;
        int smallest=Integer.MAX_VALUE;
        for(int i =start;i<end;i++){
        		if(prices[i]<smallest){
        			smallest = prices[i];
        		}
        		else{
        			if(maxprofit==null){
        				maxprofit = prices[i]-smallest;
        			}
        			else
        			maxprofit = Math.max(prices[i]-smallest, maxprofit);
        		}
        }
        if(maxprofit==null)return 0;
    	return maxprofit;
    }
    public int maxProfit1(int[] prices) {
    	int max=0;
    	for(int i =0;i< prices.length;i++){
    		max=Math.max(max,maxProfit1(prices,0,i)+maxProfit1(prices,i,prices.length));
    	}
    	return max;
    }
    //
    
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    
    
    
    public static void main(String[] args) {
    	System.out.println();
	}
}
