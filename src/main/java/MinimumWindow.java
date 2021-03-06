/*
https://leetcode.com/problems/minimum-window-substring/submissions/
*/
import java.util.HashSet;
import java.util.Set;

public class MinimumWindow {
    public String minWindow(String s, String t) {
        if (s.contains(t))
            return t;
        if (s.length() < t.length())
            return "";
        int start = -1, end = 0, i = 0;
        String result = "";
        while (start <= end && start < s.length() && end <= s.length()) {
            end = start + 1;
            Set<Integer> charsFound = new HashSet<>();
            String tt = t;
            while (charsFound.size() != t.length() && end < s.length()) {
                char curr = s.charAt(end);
                if (tt.contains(curr + "")) {
                    charsFound.add(end);
                    tt = tt.replaceFirst(curr + "", "");
                }
                end++;
            }
            end--;

            start = end;
            charsFound = new HashSet<>();
            tt = t;
            while (charsFound.size() != t.length() && start >= 0) {
                char curr = s.charAt(start);
                if (tt.contains(curr + "")) {
                    charsFound.add(start);
                    tt = tt.replaceFirst(curr + "", "");
                }
                start--;
            }
            start++;

            if (charsFound.size() == t.length()) {
                String cResult = s.substring(start, end + 1);
                if (result.length() == 0)
                    result = cResult;
                else if (cResult.length() < result.length())
                    result = cResult;
            }
            if (end >= s.length() - 1)
                break;
        }
        return result;
    }
}