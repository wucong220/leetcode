package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51NQueens {
	static public boolean fillOne(List<List<String>> ret,char[][] qi_pan, boolean[] zuo_xie, boolean[] you_xie, boolean[] heng,
			boolean[] shu,int left) {
		if(left==0)return true;
		int n = qi_pan.length;
		int i = n-left;
		{
			for (int j = 0; j < n; j++) {
				if (heng[i] != true && shu[j] != true && zuo_xie[i + j] != true && you_xie[n - 1-i + j] != true
						&& qi_pan[i][j] != 'Q') {
					heng[i] = true;
					shu[j] = true;
					zuo_xie[i + j] = true;
					you_xie[n - 1-i + j] = true;
					qi_pan[i][j] = 'Q';
					if(left==1){
						List<String> ls = new ArrayList<String>(n);
						for (int k = 0; k < qi_pan.length; k++) {
							ls.add(String.valueOf(qi_pan[k]));
							System.out.println(Arrays.toString(qi_pan[k]));
							
						}
						ret.add(ls);
					}
					else{
						fillOne(ret,qi_pan, zuo_xie, you_xie, heng, shu,left-1);
					}
					heng[i] = false;
					shu[j] = false;
					zuo_xie[i + j] = false;
					you_xie[n -1- i + j] = false;
					qi_pan[i][j] = '.';
					
				}
			}
		}
		return false;
	}

	static public List<List<String>> solveNQueens(int n) {
		List<List<String>> ret = new ArrayList<>();
		boolean[] zuo_xie = new boolean[2 * n - 1];
		boolean[] you_xie = new boolean[2 * n - 1];
		boolean[] heng = new boolean[n];
		boolean[] shu = new boolean[n];
		char[][] qi_pan = new char[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(qi_pan[i], '.');
		}

//		for (int i = 0; i < n; i++) {
			int i=0;
			for (int j = 0; j < n; j++) {
				if (heng[i] != true && shu[j] != true && zuo_xie[i + j] != true && you_xie[n -1 - i + j] != true
						&& qi_pan[i][j] != 'Q') {
					heng[i] = true;
					shu[j] = true;
					zuo_xie[i + j] = true;
					you_xie[n -1-i + j] = true;
					qi_pan[i][j] = 'Q';
//					if(fillOne( ret,qi_pan, zuo_xie, you_xie, heng, shu,n-1)){
//						List<String> ls = new ArrayList<String>(n);
//						for (int k = 0; k < qi_pan.length; k++) {
//							ls.add(String.valueOf(qi_pan[k]));
//							System.out.println(Arrays.toString(qi_pan[k]));
//							Arrays.fill(qi_pan[k],'.');
//						}
//						ret.add(ls);
//						System.out.println("__________________");
//						Arrays.fill(shu, false);
//						Arrays.fill(heng, false);
//						Arrays.fill(zuo_xie, false);
//						Arrays.fill(you_xie, false);
//					}
//					else{
					fillOne( ret,qi_pan, zuo_xie, you_xie, heng, shu,n-1);
					{
						heng[i] = false;
						shu[j] = false;
						zuo_xie[i + j] = false;
						you_xie[n -1- i + j] = false;
						qi_pan[i][j] = '.';
					}
				}
			}
//		}

		return ret;
	}

	public static void main(String[] args) {
		System.out.println(solveNQueens(5));
	}
}
