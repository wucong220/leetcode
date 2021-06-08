package array;

import java.util.ArrayList;

import DataStructure.TreeNode;

public class GetLeastNumbers_Solution {
	void quickSelect(int[] input,int low,int high,int k,ArrayList<Integer> list){
		if(low>high)return;
		int l = low;
		int h = high;
		int key = input[low];
		while(l<h){
			while(l<h&&input[h]>=key)h--;
			if(l<h)input[l] = input[h];
			while(l<h&&input[l]<=key)l++;
			if(l<h)input[h] = input[l];
		}
		input[l] = key;
		if(l-low+1==k){
			for(int i=low;i<=l;i++){
				list.add(input[i]);
			}
		}
		else if(l-low+1>k){
			quickSelect(input, low,l-1, k, list);
		}
		else {
			quickSelect(input,l+1,high,k-(l-low+1),list);
			for(int i=low;i<=l;i++){
				list.add(input[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
	
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> list = new ArrayList<>();
    	quickSelect(input, 0, input.length-1, k, list);
    	return list;
    }
    


}
