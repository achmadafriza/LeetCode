package com.practice.interview.trie;

import java.util.List;

public class S208 {
    static class Trie {
        private String key;
        private Trie[] children;
        private String value;

        public Trie() {
            this.key = "";
            this.children = new Trie[26];
            this.value = null;
        }

        public Trie(String key) {
            this.key = key;
            this.children = new Trie[26];
            this.value = null;
        }

        public Trie(String key, String value) {
            this.key = key;
            this.children = new Trie[26];
            this.value = value;
        }

        public void insert(String word) {
            Trie curr = this;
            for (int i = 1; i <= word.length(); i++) {
                String currKey = word.substring(0, i);
                if (curr.children[word.charAt(i - 1) - 'a'] == null) {
                    curr.children[word.charAt(i - 1) - 'a'] = new Trie(currKey);
                }

                curr = curr.children[word.charAt(i - 1) - 'a'];
            }

            curr.value = word;
        }

        public boolean search(String word) {
            Trie curr = this;
            for (int i = 0; i < word.length() && curr != null; i++) {
                curr = curr.children[word.charAt(i) - 'a'];
            }

            if (curr == null) {
                return false;
            }

            return curr.value != null;
        }

        public boolean startsWith(String prefix) {
            Trie curr = this;
            for (int i = 0; i < prefix.length() && curr != null; i++) {
                curr = curr.children[prefix.charAt(i) - 'a'];
            }

            return curr != null;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // return True
        trie.search("app");     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        trie.search("app");     // return True
    }
}
