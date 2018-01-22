package com.solutions.p208;

import java.util.HashMap;

public class Trie {

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode ptr = root;
        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1)
                ptr.addNode(word.charAt(i), true);
            else
                ptr.addNode(word.charAt(i), false);

            ptr = ptr.next(word.charAt(i));
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode ptr = walkToNode(word);
        return ptr != null && ptr.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return walkToNode(prefix) != null;
    }

    private TrieNode walkToNode(String prefix) {
        TrieNode ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            ptr = ptr.next(prefix.charAt(i));
            if (ptr == null) {
                break;
            }
        }
        return ptr;
    }

    class TrieNode {
        private boolean isEndOfWord;
        private char nodeChar;
        private TrieNode[] children = new TrieNode[26];

        public TrieNode(char c) {
            nodeChar = c;
        }

        public void addNode(char c, boolean isEnd) {
            if (childAt(c) == null)
                setChild(c, new TrieNode(c));

            if (isEnd) {
                childAt(c).setAsEnd();
            }
        }

        public TrieNode next(char c) {
            return childAt(c);
        }

        public void setAsEnd() {
            isEndOfWord = true;
        }

        private TrieNode childAt(char c) {
            return children[c - 'a'];
        }

        private void setChild(char c, TrieNode node){
            children[c - 'a'] = node;
        }
    }
}
