package com.wu;

import java.util.HashMap;
import java.util.Map;

public class CN146LRU {

}


class LRUCache {
    class LRUNode{
        int key;
        int val;
        LRUNode pre;
        LRUNode next;
    }

    Map<Integer,LRUNode> map = new HashMap<>();
    LRUNode head = new LRUNode();
    LRUNode tail = new LRUNode();
    int capacity ;
    int size=0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head.next = tail;
    }

    public int get(int key) {
        LRUNode lruNode = map.get(key);
        if(lruNode==null)return -1;
        moveToTheHead(lruNode);
        return lruNode.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            LRUNode lruNode = map.get(key);
            lruNode.val = value;
            moveToTheHead(lruNode);
        }
        else{
            LRUNode lruNode = new LRUNode();
            lruNode.val = value;
            lruNode.key = key;
            lruNode.next = head.next;
            lruNode.pre = head;
            lruNode.pre.next = lruNode;
            lruNode.next.pre = lruNode;
            map.put(key,lruNode);
            size++;
            if(size>capacity){
                LRUNode lrnu = tail.pre;
                lrnu.next.pre = lrnu.pre;
                lrnu.pre.next = lrnu.next;
                map.remove(lrnu.key);
            }
        }
    }

    private void moveToTheHead(LRUNode curr){
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
        curr.next = head.next;
        curr.pre = head;
        curr.next.pre = curr;
        curr.pre.next = curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

