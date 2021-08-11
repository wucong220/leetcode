package com.wu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuc006
 * @date 2021/7/22 9:07
 */
public class CN138 {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        Map<Node,Node> nodeNode =  new HashMap<>();

        private Node copyRandomList(Node head) {
            if(head!=null){
                Node node = nodeNode.get(head);
                if(node!=null){
                    return node;
                }
                else{
                    Node temp = new Node(head.val);
                    nodeNode.put(head,temp);
                    temp.next = copyRandomList(head.next);
                    temp.random = copyRandomList(head.random);
                    return temp;
                }
            }
            return null;
        }
    }
}
