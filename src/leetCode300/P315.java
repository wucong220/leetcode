package leetCode300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class P315 {
	private int lowBit(int n){
		return n&(-n);
	}
	private void update(int[] bitTree,int i,int v){
		while(i<bitTree.length){
			bitTree[i]+=v;
			i+=lowBit(i);
		}
	}
	private int query(int[] bitTree,int i){
		int sum =0;
		while(i>0){
			sum+=bitTree[i];
			i-=lowBit(i);
		}
		return sum;
	}
	
	
    public List<Integer> countSmaller(int[] nums) {
    	TreeSet<Integer> set = new TreeSet<>();
    	for(int i=0;i<nums.length;i++){
    		set.add(nums[i]);
    	}
    	List<Integer> list = new ArrayList<>(set);
    	HashMap<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<list.size();i++){
    		map.put(list.get(i), i+1);
    	}
    	
    	List<Integer> rank = new ArrayList<>();
    	for(int i=0;i<nums.length;i++){
    		rank.add(map.get(nums[i]));
    	}
    	Collections.reverse(rank);
    	int[] bitTree = new int[set.size()+1];
    	List<Integer> ret = new ArrayList<>();
    	for(int i=0;i<rank.size();i++){
    		int curr = rank.get(i);
    		ret.add(query(bitTree, curr-1));
    		update(bitTree, curr, 1);
    	}
    	Collections.reverse(ret);
    	return ret;
    }
    
    public static void main(String[] args) {
		List ret = new P315().countSmaller(new int[]{5,2,6,1});
		System.out.println(ret);
    }
}
