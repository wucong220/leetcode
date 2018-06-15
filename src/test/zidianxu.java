package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zidianxu {
	
	
	public static void swap(char[] ch,int a,int b){
		char temp = ch[a];
		ch[a] = ch[b];
		ch[b] = temp;
	}
	
	static public void quickSort(char[] input,int start,int end){
		if(start>=end){
			return;
		}
		int i=start;
		int j=end;
		char key = input[i];
		while(i<j){
			while(input[j]>=key&&i<j)j--;
			if(i<j)input[i]=input[j];
			while(input[i]<=key&&i<j)i++;
			if(i<j)input[j]=input[i];
		}
		input[i] = key;
		quickSort(input,start,i-1);
		quickSort(input,i+1,end);
	}
	
	
	static public int nextPermutation(char[] nums) {
		int i;
		for ( i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				quickSort(nums,i,nums.length-1);
				break;
			}
		}
		if(i==0){
			return 1;
		}
		for(int j=i-1;j<nums.length;j++){
			if(nums[j]>nums[i-1]){
				char temp = nums[i-1];
				nums[i-1] = nums[j];
				nums[j] = temp;
				break;
			}
		}
		return -1;
	}
	
	public static void fuck(String s)
	{
		List<String> ret= new ArrayList<>();
		Map<Character,List<String>> cache = new HashMap<>();
		char[] origin = s.toCharArray();
		char[] ch = s.toCharArray();
		ret.add(String.valueOf(ch));
		Arrays.sort(ch);
		while(nextPermutation(ch)==-1)
		ret.add(String.valueOf(ch));
	}
	
	public static List<String> fuck(String s,int a){
		
		fuck(s.substring(1));
		
		return null;	
	}

	
	public static void main(String[] args) {
		fuck("abc");
	}
}
