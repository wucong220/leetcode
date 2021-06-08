package com.wu;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/4/17 18:34
 */
public class CN1825 {
    class MKAverage {
        long sum=0;
        int m =0;
        int k = 0;
        List<int[]> list = new LinkedList<>();
        TreeSet<int[]> k1 = new TreeSet<>(Comparator.comparing(a->((int[])a)[0]).thenComparing(b->((int[])b)[1]));
        TreeSet<int[]> k2 = new TreeSet<>(k1.comparator().reversed());
        TreeSet<int[]> mid = new TreeSet<>(k1.comparator());
        long k1Sum = 0;
        long k2Sum = 0;
        int ctr=0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            int[] curr = {num, ctr++};
            sum += num;
            list.add(curr);

            if(list.size()>m) {
                int[] remove = list.remove(0);
                sum -= remove[0];
                mid.remove(remove);
                if (k1.remove(remove)){
                    k1Sum-=remove[0];
                    int[] pollFirst = mid.pollFirst();
                    k1.add(pollFirst);
                    k1Sum+=pollFirst[0];
                }
                else if(k2.remove(remove)){
                    k2Sum-=remove[0];
                    int[] pollLast = mid.pollLast();
                    k2.add(pollLast);
                    k2Sum+=pollLast[0];
                }
            }
            k1Sum += num;
            k1.add(curr);
            k2Sum += num;
            k2.add(curr);

            if (k1.size() > k) {
                int[] last = k1.pollLast();
                k1Sum -= last[0];
                int[] last1 = k2.pollLast();
                k2Sum -= last1[0];
                if(list.size()>2*k) {
                    if (last[0] == curr[0]) {
                        mid.add(last1);
                    }
                    else mid.add(last);
                }
            }

        }

        public int calculateMKAverage() {
            if(list.size()<m)return -1;
            return (int) ((sum-k1Sum-k2Sum)/(m-2*k));
        }
    }

    public static void main(String[] args) {
        MKAverage mkAverage = new CN1825().new MKAverage(3, 1);
        mkAverage.addElement(3716);
        mkAverage.addElement(51094);
        mkAverage.addElement(56724);
        mkAverage.addElement(79619);
        int i = mkAverage.calculateMKAverage();
        System.out.println(i);
    }
    /*
    ["MKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement","addElement","calculateMKAverage","addElement"]
[[3,1],[3716],[51094],[],[56724],[79619],[],[99914],[277],[],[91205]]
*/
}
