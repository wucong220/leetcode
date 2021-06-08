package com.wu;

import java.util.HashMap;
import java.util.Map;

class Trie {
    private final TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        root.children=new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (curr.children == null) {
                curr.children = new HashMap<>();
            }
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
            if(curr.children==null)
            curr.children = new HashMap<>();
            curr.val=c;
            if(i==charArray.length-1){
                curr.finish=true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            curr = curr.children.get(c);
            if(curr==null)return false;
            if(i==charArray.length-1){
                return curr.finish;
            }
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] charArray = prefix.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            curr = curr.children.get(c);
            if(curr==null)return false;
        }
        return true;
    }
}

class TrieNode{
    char val;
    boolean finish;
    Map<Character,TrieNode> children;
}
