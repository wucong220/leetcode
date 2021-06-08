package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InversePairs {
	   void update(int[] bitTree,int index,int value){
	        while(index<bitTree.length){
	            bitTree[index]+=value;
	            index += lastBit(index);
	        }
	    }
	    
	    int query(int[] bitTree,int index){
	        int sum = 0;
	        while(index>0){
	            sum+=bitTree[index];
	            index -=lastBit(index);
	        }
	        return sum;
	    }
	    
	    
	    int lastBit(int n){
	        return n&(-n);
	    }
	    
	    public int InversePairs(int [] array) {
	        int[] bitTree = new int[array.length+1];
	        int[] sorted = array.clone();
	        Map<Integer,Integer> num_index = new HashMap<>();
	        Arrays.sort(sorted);
	        reverse(array);
	        for(int i=0;i<sorted.length;i++){
	        	num_index.put(sorted[i],i+1);
	        }
	        int ret = 0;
	        
	        for(int i=0;i<array.length;i++){
	        	if(i>0)
	        	ret += query(bitTree,num_index.get(array[i])-1);
	        	update(bitTree, num_index.get(array[i]), 1);
	        }
	        
	        
	        return ret;
	    }
	    
	    void reverse(int[] array){
	    	int start = 0;
	    	int end = array.length-1;
	    	while(start<end){
	    		array[start] = array[start]^array[end];
	    		array[end] = array[start]^array[end];
	    		array[start] = array[start]^array[end];
	    		start++;end--;
	    	}
	    }
	    
	    public static void main(String[] args) {
			System.out.println(new InversePairs().InversePairs(new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575}));
		}
}
