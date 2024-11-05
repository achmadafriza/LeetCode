package com.practice.interview.trie;

import java.util.*;

public class S212 {
    public static class Trie {
        private char c;
        private boolean isWord;
        private String word;

        private Trie[] children;

        public Trie() {
            this.isWord = false;
            this.children = new Trie[26];
        }

        public Trie(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new Trie[26];
        }

        public void insert(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    curr.children[s.charAt(i) - 'a'] = new Trie(s.charAt(i));
                }

                curr = curr.children[s.charAt(i) - 'a'];
            }

            curr.isWord = true;
            curr.word = s;
        }

        public boolean search(String s) {
            Trie curr = this;
            for (int i = 0; i < s.length(); i++) {
                if (curr.children[s.charAt(i) - 'a'] == null) {
                    return false;
                }

                curr = curr.children[s.charAt(i) - 'a'];
            }

            return curr.isWord;
        }
    }

    public void recursive(int row, int col, char[][] board, Set<String> result, Trie curr) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        if (board[row][col] == '#') {
            return;
        }

        Trie next = curr.children[board[row][col] - 'a'];
        if (next == null) {
            return;
        } else if (next.isWord){
            result.add(next.word);
        }

        char temp = board[row][col];

        board[row][col] = '#';
        recursive(row - 1, col, board, result, next);
        recursive(row + 1, col, board, result, next);
        recursive(row, col - 1, board, result, next);
        recursive(row, col + 1, board, result, next);
        board[row][col] = temp;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie parent = new Trie();
        for (String s : words) {
            parent.insert(s);
        }

        Set<String> result = new HashSet<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                recursive(row, col, board, result, parent);
            }
        }

        return new ArrayList<>(result);
    }
}
