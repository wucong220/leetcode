package leetCode100;

import java.util.Arrays;

public class P165CompareVersionNumbers {
	public static void main(String[] args) {
		System.out.println(compareVersion("1.0","1"));
		System.out.println(Arrays.toString("0.1".split("\\.")));
	}
	
    static public int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\.");
    	String[] v2 = version2.split("\\.");
    	for (int i = 0; i < v2.length||i<v1.length; i++) {
			if((i<v1.length?Integer.parseInt(v1[i]):0)>(i<v2.length?Integer.parseInt(v2[i]):0))return 1;
			else if((i<v1.length?Integer.parseInt(v1[i]):0)<(i<v2.length?Integer.parseInt(v2[i]):0))return -1;
		}
    	return 0;

    }
}
