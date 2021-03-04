/*
https://leetcode.com/problems/decode-string/submissions/
*/

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        Deque<Integer> countStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();

        String num = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                strStack.push(ch + "");
            } else if (ch >= '0' && ch <= '9') {
                num += ch;
            } else if (ch == '[') {
                countStack.push(Integer.parseInt(num));
                strStack.push(ch + "");
                num = "";
            } else if (ch == ']') {
                String curr = strStack.pop();
                StringBuilder rep = new StringBuilder();
                while (!curr.equals("[")) {
                    rep.append(curr);
                    curr = strStack.pop();
                }
                String ans = "";
                // rep.reverse();
                int n = countStack.pop();
                for (int j = 0; j < n; j++) {
                    ans += rep.toString();
                }
                strStack.push(ans);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!strStack.isEmpty()) {
            result.append(strStack.pop());

        }
        result.reverse();
        return result.toString();
    }
}