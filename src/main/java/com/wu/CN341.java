package com.wu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CN341 {
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
    public class NestedIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> flatList = new ArrayList<>();
            flattenList(nestedList,flatList);
            iterator=flatList.iterator();
        }

        private void flattenList(List<NestedInteger> nestedList, List<Integer> flatList){
            for(int i=0;i<nestedList.size();i++){
                NestedInteger nestedInteger = nestedList.get(i);
                if(nestedInteger.isInteger()){
                    flatList.add(nestedInteger.getInteger());
                }
                else{
                    flattenList(nestedInteger.getList(), flatList);
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}


 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
 interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
