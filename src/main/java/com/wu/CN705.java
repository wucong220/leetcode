package com.wu;

public class CN705 {
    class MyHashSet {
        boolean keys[] = new boolean[1000001];
        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            keys[key]=true;
        }

        public void remove(int key) {
            keys[key]=  false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return keys[key];
        }
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
