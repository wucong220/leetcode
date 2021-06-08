package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P850RectangleAreaII {
	int[] segmentTree;
	int[] lazy;
	int[] hash;
	int treesize;

	int rangeQuery(int ql, int qr, int l, int r, int pos) {
		if (ql > qr) {
			return 0;
		}

		if (lazy[pos] != 0) {
			segmentTree[pos] += lazy[pos];
			if (l < r) {
				lazy[pos * 2 + 1] += lazy[pos];
				lazy[pos * 2 + 2] += lazy[pos];
			}
			lazy[pos] = 0;
		}

		// zero overlap
		if (ql > r || qr < l) {
			return 0;
		}
		
		// 查询的线段被全覆盖
		if (segmentTree[pos] > 0) {
			return hash[r + 1] - hash[l];
		} else {
			if(l==r)return 0;
			//查询的线段部分被覆盖
			int mid = (l + r) / 2;
			return rangeQuery(ql, qr, l, mid, pos * 2 + 1) + rangeQuery(ql, qr, mid + 1, r, pos * 2 + 2);
		}
	}

	void rangeUpdate(int ql, int qr, int delta, int l, int r, int pos) {
		if (ql > qr)
			return;

		if (lazy[pos] != 0) {
			segmentTree[pos] += lazy[pos];
			if (l < r) {
				lazy[pos * 2 + 1] += lazy[pos];
				lazy[pos * 2 + 2] += lazy[pos];
			}
			lazy[pos] = 0;
		}

		// zero overlap
		if (ql > r || qr < l) {
			return;
		}

		// total overlap
		if (ql <= l && r <= qr) {
			segmentTree[pos] += delta;
			if (l < r) {
				lazy[pos * 2 + 1] += delta;
				lazy[pos * 2 + 2] += delta;
			}
			return;
		}
		
		//partial overlap
		int mid = (l+r)/2;
		rangeUpdate(ql, qr, delta, l, mid, pos*2+1);
		rangeUpdate(ql, qr, delta, mid+1,r, pos*2+2);
		segmentTree[pos] = Math.min(segmentTree[pos*2+1], segmentTree[pos*2+2]);
		return;
	}
	private int[] unique(int[] array){
		List<Integer> l = new ArrayList<>();
		for(int i=0;i<array.length;i++){
			if(i>0&&array[i]==array[i-1])continue;
			l.add(array[i]);
		}
		int[] ret = new int[l.size()];
		for(int i=0;i<l.size();i++){
			ret[i] = l.get(i);
		}
		return ret;
	}
	

	public int rectangleArea(int[][] rectangles) {
		segmentTree = new int[rectangles.length * 8]; // 线段树
		lazy = new int[rectangles.length * 8]; // 懒惰树
		int[][] sides = new int[rectangles.length*2][4]; //边集
		hash = new int[rectangles.length * 2]; // 离散树
		int ret =0;
		for (int i = 0; i < rectangles.length; i++) {
			hash[i*2] = rectangles[i][0];
			hash[i*2+1] = rectangles[i][2];
			sides[i*2][0] = sides[i*2+1][0] = rectangles[i][0];
			sides[i*2][1] = sides[i*2+1][1] = rectangles[i][2];
			sides[i*2][2] = rectangles[i][1];
			sides[i*2+1][2] = rectangles[i][3];
			sides[i*2][3] = 1;
			sides[i*2+1][3] = -1;
		}
		Arrays.sort(sides,(a,b)->a[2]-b[2]);
		Arrays.sort(hash);
		hash = unique(hash);
		Map<Integer,Integer> map  = new HashMap<>();
		for(int i=0;i<hash.length;i++){
			map.put(hash[i], i);
		}
		
		treesize=hash.length-1;
		
		
		for (int i = 0; i < rectangles.length * 2; i++) {
			if(i>0){
				long sum = rangeQuery(0,treesize-1, 0, treesize-1, 0);
				ret += sum*(sides[i][2]- sides[i-1][2])%(1000000000+7);
			}
			rangeUpdate(map.get(sides[i][0]), map.get(sides[i][1])-1,sides[i][3], 0,  treesize-1, 0);
		}

		return ret;
	}
	
	public static void main(String[] args) {
		int[][] rectangles = new int[][]{{25,20,70,27},{68,80,79,100},{68,80,79,100}};
		System.out.println(new P850RectangleAreaII().rectangleArea(rectangles));
	}
}
