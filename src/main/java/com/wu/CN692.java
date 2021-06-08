package com.wu;

import java.util.*;

public class CN692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String,Integer> freq = new HashMap<>();
            for (String word : words) {
                freq.merge(word,1,Integer::sum);
            }
            Comparator<Object> comparator = Comparator.comparing(key1 -> freq.get(key1)).thenComparing(Comparator.comparing(a->(String)a).reversed());
            PriorityQueue<String> pq  = new PriorityQueue<>(comparator);
            for (String key : freq.keySet()) {
                if(pq.size()<k){
                    pq.offer(key);
                }
                else{
                    String peek = pq.peek();
                    if(comparator.compare(key,peek)>0){
                        pq.poll();
                        pq.offer(key);
                    }
                }
            }
            List<String> strings = new LinkedList<>(pq);
            while(!pq.isEmpty()) {
                strings.add(0,pq.poll());
            }

            return strings;
        }
    }

    public static void main(String[] args) {
        RunUtil.run(RunUtil.toArray(
                "[glarko,zlfiwwb,nsfspyox,pwqvwmlgri,qggx,qrkgmliewc,zskaqzwo,zskaqzwo,ijy,htpvnmozay,jqrlad,ccjel,qrkgmliewc,qkjzgws,fqizrrnmif,jqrlad,nbuorw,qrkgmliewc,htpvnmozay,nftk,glarko,hdemkfr,axyak,hdemkfr,nsfspyox,nsfspyox,qrkgmliewc,nftk,nftk,ccjel,qrkgmliewc,ocgjsu,ijy,glarko,nbuorw,nsfspyox,qkjzgws,qkjzgws,fqizrrnmif,pwqvwmlgri,nftk,qrkgmliewc,jqrlad,nftk,zskaqzwo,glarko,nsfspyox,zlfiwwb,hwlvqgkdbo,htpvnmozay,nsfspyox,zskaqzwo,htpvnmozay,zskaqzwo,nbuorw,qkjzgws,zlfiwwb,pwqvwmlgri,zskaqzwo,qengse,glarko,qkjzgws,pwqvwmlgri,fqizrrnmif,nbuorw,nftk,ijy,hdemkfr,nftk,qkjzgws,jqrlad,nftk,ccjel,qggx,ijy,qengse,nftk,htpvnmozay,qengse,eonrg,qengse,fqizrrnmif,hwlvqgkdbo,qengse,qengse,qggx,qkjzgws,qggx,pwqvwmlgri,htpvnmozay,qrkgmliewc,qengse,fqizrrnmif,qkjzgws,qengse,nftk,htpvnmozay,qggx,zlfiwwb,bwp,ocgjsu,qrkgmliewc,ccjel,hdemkfr,nsfspyox,hdemkfr,qggx,zlfiwwb,nsfspyox,ijy,qkjzgws,fqizrrnmif,qkjzgws,qrkgmliewc,glarko,hdemkfr,pwqvwmlgri]"),14);
        System.out.println("i".compareTo("love"));
    }
}
