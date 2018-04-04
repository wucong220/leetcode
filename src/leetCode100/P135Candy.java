package leetCode100;

import java.util.Stack;

public class P135Candy {
	// 0ms
	//https://leetcode.com/problems/candy/discuss/42794/Simple-O(n)-Java-solution-with-comments
	/*public int candy(int[] ratings) {
	    int candies[] = new int[ratings.length];        
	    Arrays.fill(candies, 1);// Give each child 1 candy 
	    	
	    for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
	        if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
	    }
	     
	    for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
		    if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
	    }
	    
	    int sum = 0;        
	    for (int candy : candies)  
	    	sum += candy;        
	    return sum;
	}*/
	//30ms
	public static int candy(int[] ratings) {
			Stack<Integer> s = new Stack<Integer>();
			int sum = 0;
			int preCandy =0 ;
			for (int i = 0; i < ratings.length; i++) {
				if (s.isEmpty()) {
					s.push(ratings[i]);
				} else {
					int top = s.peek();
					if (top >= ratings[i])
						s.push(ratings[i]);
					else {
						int fucklittlesum =0;
						int count = 0;
						int candy = 1;
						int fuck = s.peek();
						while (!s.isEmpty()) {
							count++;
							int curr = s.pop();
							if (curr > fuck)
								candy++;
							else 
								candy=1;
							fuck = curr;
							fucklittlesum += candy;
						}
						if(candy<=preCandy)fucklittlesum+=preCandy-candy+1;
						if(count==1)preCandy = preCandy+1;
						else preCandy = 1;
						sum+=fucklittlesum;
						s.push(ratings[i]);
					}
				}
	//			System.out.println(sum);
			}
			
			
			if (!s.empty()) {
				int fucklittlesum =0;
				int count = 0;
				int candy = 1;
				int fuck = s.peek();
				while (!s.isEmpty()) {
					count++;
					int curr = s.pop();
					if (curr > fuck)
						candy++;
					else 
						candy=1;
					fuck = curr;
					fucklittlesum += candy;
				}
				if(candy<=preCandy)fucklittlesum+=preCandy-candy+1;
				sum+=fucklittlesum;
			}
			

	
			return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(candy(new int[]{1,2,2}));
	}
}
