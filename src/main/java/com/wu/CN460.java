package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/5/19 11:41
 */
public class CN460 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
    }
}

class LFUCache {
    class Node{
        public int key;
        public int val;
        public int count;
        public long epoch;
    }

    TreeSet<Node> cache = new TreeSet<>(Comparator.comparing(a->((Node)a).count).thenComparing(a->((Node)a).epoch));
    Map<Integer,Node>  map = new HashMap<>();

    int cap;
    int epoch;

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node!=null){
            cache.remove(node);
            node.epoch = epoch++;
            node.count++;
            cache.add(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(cache.size()<=0) return;
        Node node = map.get(key);
        if(node!=null){
            cache.remove(node);
            node.epoch = epoch++;
            node.count++;
            node.val=value;
            cache.add(node);
        }else{
            if(cache.size()==cap){
                map.remove(cache.pollFirst().key);
            }
            node  = new Node();
            node.val = value;
            node.epoch=epoch++;
            node.count=1;
            node.key = key;
            map.put(key,node);
            cache.add(node);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
