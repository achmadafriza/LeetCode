package com.practice.interview.trie;

import java.util.HashMap;
import java.util.Map;

public class S211 {
    class WordDictionary {
        private class Node {
            Node[] children;
            String value;

            public Node() {
                this.children = new Node[26];
                this.value = null;
            }

            public Node(String value) {
                this.children = new Node[26];
                this.value = value;
            }

            public void insert(String word, int i) {
                if (i > word.length()) {
                    return;
                }

                if (i == word.length()) {
                    this.value = word;

                    return;
                }

                if (this.children[word.charAt(i) - 'a'] == null) {
                    this.children[word.charAt(i) - 'a'] = new Node();
                }

                this.children[word.charAt(i) - 'a'].insert(word, i + 1);
            }

            public boolean search(String word, int i) {
                if (this.value != null && i == word.length()) {
                    return true;
                }

                if (i >= word.length()) {
                    return false;
                }

                if (word.charAt(i) == '.') {
                    boolean found = false;
                    for (int j = 0; j < this.children.length && !found; j++) {
                        if (this.children[j] != null) {
                            found = this.children[j].search(word, i + 1);
                        }
                    }

                    return found;
                }

                Node child = this.children[word.charAt(i) - 'a'];
                if (child == null) {
                    return false;
                }

                return child.search(word, i + 1);
            }
        }

        private Node node;

        public WordDictionary() {
            this.node = new Node();
        }

        public void addWord(String word) {
            node.insert(word, 0);
        }

        public boolean search(String word) {
            return node.search(word, 0);
        }
    }

}
