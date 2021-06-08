package contest;

import java.util.ArrayList;
import java.util.List;

public class P916 {
	public static void main(String[] args) {
		String[] A = new String[]{"amazon","apple","facebook","google","leetcode"};
		String[] B = {"e","oo"};
		System.out.println(new P916().wordSubsets(A, B));
	}
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ret = new ArrayList<>();
        int[] template = null;
        for(String str:B){
        	int[] temp = new int[26];
        	for(char ch:str.toCharArray()){
        		temp[ch-'a']++;
        	}
        	if(template==null)template=temp;
        	else {
        		for(int i=0;i<26;i++){
        			if(template[i]<temp[i]){
        				template[i]=temp[i];
        			}
        		}
        	}
        }
        
        for(String str:A){
        	int[] temp = new int[26];
        	for(char ch:str.toCharArray()){
        		temp[ch-'a']++;
        	}
        	boolean flag = true;
        	for(int i=0;i<26;i++){
        		if(temp[i]<template[i]){
        			flag=false;
        			break;
        		}
        	}
        	if(flag)ret.add(str);
        }
        
    	return ret;
    }
}
