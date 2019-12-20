package com.example.leetcode.No127_word_ladder;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        wordList.remove(beginWord);

        int count = 1;
//        LinkedList<String> queue = new LinkedList<>();
//        queue.add(beginWord);
        HashSet<String> waitForCheck = new HashSet<>();
        waitForCheck.add(beginWord);
        HashSet<String> unUsedWords = new HashSet<>(wordList);

        while (waitForCheck.size() != 0) {
            HashSet<String> newWait = new HashSet<>();
            HashSet<String> newUnUse = new HashSet<>();
            for (String waitStr : waitForCheck) {
                //拿s去list中找
                Iterator<String> iterator = unUsedWords.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    if (checkWord(waitStr, word)) {
                        if (word.equals(endWord)) {
                            return count+1;
                        }
                        //两个单词查一个字母
                        newWait.add(word);
                        iterator.remove();
                    }
                }
            }
            count++;
            waitForCheck = newWait;
        }
        return 0;
    }


    public static boolean checkWord(String word, String word2) {
        if (word.length() != word2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word2.charAt(i)) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }
}