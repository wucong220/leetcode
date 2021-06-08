package com.wu;

public class FranwickTree {
	
	
	int lowBit(int n){
		return n&(-n);
	}
	
	void update(int[] sum,int i, int delta){
		while(i<sum.length){
			sum[i]+=delta;
			i+=lowBit(i);
		}
	}
	
	int query(int[] sum,int i){
		int s = 0;
		while(i>0){
			s+=sum[i];
			i-=lowBit(i);
		}
		return s;
	}
	/**
	 * 线段树树状数组区别
	 * 作者：闵梓轩
链接：https://www.zhihu.com/question/54746883/answer/151823936
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

假设数组长度为n。线段树和树状数组的基本功能都是在某一满足结合律的操作(比如加法，乘法，最大值，最小值)下，O(logn)的时间复杂度内修改单个元素并且维护区间信息。不同的是，树状数组只能维护前缀“操作和”(前缀和，前缀积，前缀最大最小)，而线段树可以维护区间操作和。但是某些操作是存在逆元的，这样就给人一种树状数组可以维护区间信息的错觉:维护区间和，模质数意义下的区间乘积，区间xor和。能这样做的本质是取右端点的前缀和，然后对左端点左边的前缀和的逆元做一次操作，所以树状数组的区间询问其实是在两次前缀和询问。所以我们能看到树状数组能维护一些操作的区间信息但维护不了另一些的:最大/最小值，模非质数意义下的乘法，原因在于这些操作不存在逆元，所以就没法用两个前缀和做。而线段树就不一样了，线段树直接维护的就是区间信息，所以一切满足结合律的操作都能维护区间和，并且lazy标记的存在还能使线段树能够支持区间修改，这点是树状数组做不到的。可以说树状数组能做的事情其实是线段树的一个子集，大多数情况下使用树状数组真的只是因为它好写并且常数小而已。不过随着zkw线段树的普及，树状数组仅有的两点优势也不复存在了……估计要成为时泪了吧。利益相关:弱省弱校弱菜，只能讨论一些基本功能，各位神犇就不要在这个回答下拿树状数组的高级用法说事了，因为我真的没学过……
	 */
}