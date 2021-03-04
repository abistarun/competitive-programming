/*
https://leetcode.com/problems/rotated-digits/submissions/
*/
import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber {
    private Map<Character, Character> mapping = new HashMap<>();

    public int rotatedDigits(int N) {
        mapping.put('2', '5');
        mapping.put('5', '2');
        mapping.put('6', '9');
        mapping.put('9', '6');
        mapping.put('0', '0');
        mapping.put('8', '8');
        mapping.put('1', '1');

        int ans = 0;
        for(int i=0; i<=N; i++) {
            String num = i+"";
            boolean isBad = false;
            StringBuilder builder = new StringBuilder();
            for(int j=0; j<num.length(); j++) {
                char ch = num.charAt(j);

                if(mapping.containsKey(ch))
                    builder.append(mapping.get(ch));
                else {
                    isBad = true;
                    break;
                }
            }
            if(!isBad) {
                int newNum = Integer.parseInt(builder.toString());
                if(newNum!=i) {
                    ans++;
                }
            }
        }
        return ans;
    }
}