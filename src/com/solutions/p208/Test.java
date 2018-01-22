package com.solutions.p208;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("word");
        trie.insert("any");
        trie.insert("anywhere");
        System.out.println(trie.search("word"));
        System.out.println(trie.search("wor"));
        System.out.println(trie.search("words"));
        System.out.println(trie.startsWith("an"));
    }
}
