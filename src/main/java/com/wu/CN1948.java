package com.wu;

import java.util.*;

/**
 * @author wuc006
 * @date 2021/7/26 17:52
 */
public class CN1948 {
    class Solution {

        Map<String,Integer> map = new HashMap<>();
        Map<String,String> struct = new HashMap<>();
        List<List<String>> finalRet = new ArrayList<>();
        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            Map<String,List<String>> tree = new HashMap<>();
            Set<String> all = new HashSet<>();
            Set<String> child = new HashSet<>();
            for (List<String> path : paths) {
                final String pre = String.join("\\",path.subList(0,path.size()-1));
                final String after = String.join("\\",path.subList(0,path.size()));
                tree.putIfAbsent(pre,new ArrayList<>());
                tree.get(pre).add(after);
                all.add(after);
                all.add(pre);
                child.add(after);
            }

            all.removeAll(child);

            postOrderTraverse(tree, all.iterator().next());

            dfs(tree,all.iterator().next());

            return finalRet;
        }

        private void dfs(Map<String, List<String>> tree, String curr) {
            final String s = struct.get(curr);
            if(map.getOrDefault(s,0)>1){
                return;
            }
            if(curr.length()>0) finalRet.add(Arrays.asList(curr.split("\\\\")));
            final List<String> strings = tree.get(curr);
            if(strings==null)return;
            else{
                for (String child : strings) {
                    dfs(tree,child);
                }
            }
        }

        private String postOrderTraverse(Map<String, List<String>> tree, String curr) {
            List<String> strings = tree.get(curr);
            List<String> list = new ArrayList<>();
            if(strings==null)return curr.substring(curr.lastIndexOf("\\")+1);
            for (String string : strings) {
                String str = postOrderTraverse(tree, string);
                list.add(str);
            }
            list.sort(String::compareTo);
            final String join = String.join(",", list);
            map.merge(join,1,Integer::sum);
            struct.put(curr,join);
            return curr.substring(curr.lastIndexOf("\\")+1)+"("+join+")";
        }
    }

    public static void main(String[] args) {
         List<List<String>> lists = Arrays.asList(Arrays.asList("a"), Arrays.asList("c"), Arrays.asList("d"), Arrays.asList("a", "b"), Arrays.asList("c", "b"), Arrays.asList("d", "a"));
        RunUtil.run(lists);
    }
}
