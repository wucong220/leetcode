package com.wu;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author wuc006
 * @date 2021/2/26 9:48
 */
public class TrieTree {
    TrieNode root;

    public TrieTree(){
        root = new TrieNode();
    }

    public void insertSeq(char[] seq){
        TrieNode curr = root;
        for (int i = 0; i < seq.length; i++) {
            char c = seq[i];
            curr.next.putIfAbsent(c,new TrieNode());
            TrieNode nextNode = curr.next.get(c);
            if(i==seq.length-1){
                nextNode.isEnd=true;
            }
            curr = nextNode;
        }
    }

    private class TrieNode {
        char c;
        boolean isEnd;
        Map<Character,TrieNode> next;
    }
}
