package com.wu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CN1600 {
    class ThroneInheritance {
        Node root;
        Map<String,Node> nameNodeMap = new HashMap<>();

        public ThroneInheritance(String kingName) {
            root = new Node();
            root.name=kingName;
            root.childs = new ArrayList<>();
            root.isAlive=true;
            nameNodeMap.put(kingName,root);
        }

        public void birth(String parentName, String childName) {
            Node parent = nameNodeMap.get(parentName);
            Node child = new Node();
            child.name= childName;
            child.isAlive = true;
            child.childs = new ArrayList<>();
            nameNodeMap.put(childName,child);
            parent.childs.add(child);
        }

        public void death(String name) {
            nameNodeMap.get(name).isAlive=false;
        }

        public List<String> getInheritanceOrder() {
            List<String> list = new ArrayList<>();
            centerOrderTraverse(root,list);
            return list;
        }

        private void centerOrderTraverse(Node root, List<String> list) {
            if(root==null)return;
            if(root.isAlive)list.add(root.name);

            for (Node child : root.childs) {
                centerOrderTraverse(child,list);
            }

        }
    }

    class Node{
        boolean isAlive;
        String name;
        List<Node> childs;
    }
/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
}
