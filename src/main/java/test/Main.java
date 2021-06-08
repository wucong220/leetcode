package test;

import java.util.Scanner;

public class Main {
	static void fuck(long value) {
		StringBuilder sb = new StringBuilder();
		while (value > 0) {
			if (value % 2 == 0) {
				sb.insert(0, '2');
				value = (value - 2) / 2;
			} else {
				sb.insert(0, '1');
				value = (value - 1) / 2;
			}
		}
		System.out.println(sb);
	}

	static void fuck4(int cn,int sn,int[] parent) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<parent.length){
			
		}
		
		
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sb = s.nextLine();
		String[] argss=sb.split(" ");
		sb = s.nextLine();
		String[] argsss = sb.split(" ");
		int[] parent = new int[argss.length];
		for(int i=0;i< argss.length;i++){
			parent[i] = Integer.parseInt(argsss[i]);
		}
		fuck4(Integer.parseInt(argss[0]),Integer.parseInt(argss[1]),parent);
	}
}
