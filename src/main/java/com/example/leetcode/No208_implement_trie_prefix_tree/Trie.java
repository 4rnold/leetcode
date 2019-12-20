package com.example.leetcode.No208_implement_trie_prefix_tree;

class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        System.out.println(trie.search("abcd"));
        System.out.println(trie.startsWith("ab"));
    }
    TrieNode trieNode = null;

    /** Initialize your data structure here. */
    public Trie() {
        trieNode = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode[] children = node.getChildren();
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode(c);
            }
            node = children[c - 'a'];
        }
        node.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = trieNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode[] children = node.getChildren();
            if (children[c - 'a'] != null) {
                node = children[c - 'a'];
            } else {
                return false;
            }
        }
        if (node.isEnd() == true) {
            return true;
        } else {
            return false;
        }
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = trieNode;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            TrieNode[] children = node.getChildren();
            TrieNode child = children[c - 'a'];
            if (child != null) {
                node = child;
            } else {
                return false;
            }
        }
        return true;
    }

    static class TrieNode {
        private static int SIZE = 26;
        TrieNode[] children;
        char val;
        boolean isEnd = false;

        public TrieNode() {
            children = new TrieNode[SIZE];
        }

        public TrieNode(char val) {
            this();
            this.val = val;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void setChildren(TrieNode[] children) {
            this.children = children;
        }

        public char getVal() {
            return val;
        }

        public void setVal(char val) {
            this.val = val;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd(boolean end) {
            isEnd = end;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */