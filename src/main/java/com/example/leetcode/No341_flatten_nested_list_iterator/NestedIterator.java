package com.example.leetcode.No341_flatten_nested_list_iterator;


import java.util.*;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    public static void main(String[] args) {
        NestedInteger nestedInteger = new MyNestedInteger(1, true, null);
        NestedInteger nestedInteger2 = new MyNestedInteger(1, true, null);
        ArrayList<NestedInteger> objects = new ArrayList<>();
        objects.add(nestedInteger);
        objects.add(nestedInteger2);
        MyNestedInteger myNestedInteger = new MyNestedInteger(null, false, objects);

        NestedInteger nestedInteger3 = new MyNestedInteger(1, true, null);
        NestedInteger nestedInteger4 = new MyNestedInteger(1, true, null);
        ArrayList<NestedInteger> objects2 = new ArrayList<>();
        objects2.add(nestedInteger3);
        objects2.add(nestedInteger4);
        MyNestedInteger myNestedInteger2 = new MyNestedInteger(null, false, objects2);

        NestedInteger nestedInteger6 = new MyNestedInteger(2, true, null);

        ArrayList<NestedInteger> objects7 = new ArrayList<>();
        objects7.add(myNestedInteger);
        objects7.add(nestedInteger6);
        objects7.add(myNestedInteger2);
        NestedIterator i = new NestedIterator(objects7);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    private List<NestedInteger> nestedList = null;

    private LinkedList<Integer> sizeList = new LinkedList<>();

    private LinkedList<Integer> idxList = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        if (nestedList != null) {
            sizeList.add(nestedList.size());
            idxList.add(-1);
        }
    }

    @Override
    public Integer next() {
        while (sizeList.getLast() - 1 == idxList.getLast()) {
            sizeList.pollLast();
            idxList.pollLast();
        }
        Integer last = idxList.pollLast();
        idxList.addLast(last + 1);

//        NestedInteger tmp = nestedList.get(idxList.getFirst());
        Iterator<Integer> idxIterator = idxList.iterator();
        Integer next = idxIterator.next();
        if (nestedList.size() == 0) {
            return null;
        }
        NestedInteger loopNestedInteger = nestedList.get(next);
        while (idxIterator.hasNext()) {
            Integer nextIdx = idxIterator.next();
            loopNestedInteger = loopNestedInteger.getList().get(nextIdx);
        }
        if (loopNestedInteger.isInteger()) {
            return loopNestedInteger.getInteger();
        } else {

            while (loopNestedInteger.isInteger() == false) {
                //不是int，就循环
                idxList.addLast(0);
                sizeList.addLast(loopNestedInteger.getList().size());
                loopNestedInteger = loopNestedInteger.getList().get(0);
            }
            return loopNestedInteger.getInteger();
        }
    }

    @Override
    public boolean hasNext() {
        if (nestedList == null || nestedList.size() == 0) {
            return false;
        }
        LinkedList<Integer> cloneSizeList = (LinkedList<Integer>) sizeList.clone();
        LinkedList<Integer> cloneidxList = (LinkedList<Integer>) idxList.clone();
        if (cloneidxList == null || cloneSizeList == null) {
            return false;
        }
        if (cloneidxList.size() == 0 || cloneSizeList.size() == 0) {
            return false;
        }

        while ((cloneidxList.size() != 0 || cloneSizeList.size() != 0) && cloneSizeList.getLast() - 1 == cloneidxList.getLast()) {
            cloneSizeList.pollLast();
            cloneidxList.pollLast();
        }

        Integer last = cloneidxList.pollLast();
        if (last == null) {
            return false;
        }
        cloneidxList.addLast(last + 1);

        Iterator<Integer> iterator = cloneidxList.iterator();
        Integer next = iterator.next();
        NestedInteger nestedInteger = nestedList.get(next);
        while (iterator.hasNext()) {
            Integer next1 = iterator.next();
            nestedInteger = nestedInteger.getList().get(next1);
        }

        return isEmpty(nestedInteger);

    }

    private boolean isEmpty(NestedInteger nestedInteger) {
        if (nestedInteger == null) {
            return false;
        }
        if (nestedInteger.isInteger() && nestedInteger.getInteger() == null) {
            return false;
        }
        if (nestedInteger.isInteger() == false && (nestedInteger.getList() == null || nestedInteger.getList().size() == 0)) {
            return false;
        }
        if (nestedInteger.isInteger() && nestedInteger.getInteger() != null) {
            return true;
        } else {
            return isEmpty(nestedInteger.getList().get(0));
        }
    }

    static class MyNestedInteger implements NestedInteger {

        Integer integer = 0;

        boolean isInteger = false;

        List<NestedInteger> list = new ArrayList<NestedInteger>();

        public MyNestedInteger(Integer integer, boolean isInteger, List<NestedInteger> list) {
            this.integer = integer;
            this.isInteger = isInteger;
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return isInteger;
        }

        @Override
        public Integer getInteger() {
            return integer;
        }

        @Override
        public List<NestedInteger> getList() {
            return list;
        }
    }

    static public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */