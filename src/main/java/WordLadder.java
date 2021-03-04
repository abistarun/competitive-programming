/*
https://leetcode.com/problems/word-ladder/submissions/
*/

import java.util.*;

public class WordLadder {
    class Node {
        String word;
        int dist;

        Node(String word, int dist) {
            this.word = word;
            this.dist = dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr.word.equals(endWord))
                return curr.dist;

            for (String dWord : wordList) {
                int sCnt = 0;
                for (int i = 0; i < curr.word.length(); i++) {
                    if (dWord.charAt(i) != curr.word.charAt(i))
                        sCnt++;
                }
                if (sCnt == 1) {
                    if (!visited.contains(dWord)) {
                        queue.add(new Node(dWord, curr.dist + 1));
                        visited.add(dWord);
                    }
                }
            }
        }
        return 0;
    }
}