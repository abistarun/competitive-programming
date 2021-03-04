/*
https://leetcode.com/problems/long-pressed-name/submissions/
*/
public class LongPressedNames {
    public boolean isLongPressedName(String name, String typed) {
        int i=0, j=0;
        char[] nameC = name.toCharArray();
        char[] typedC = typed.toCharArray();

        while(i<name.length() && j<typed.length()) {
            if(nameC[i] == typedC[j]) {
                while(j<typed.length() && nameC[i] == typedC[j]) {
                    j++;
                    if(j<typedC.length && i+1<nameC.length && nameC[i+1] == typedC[j])
                        i++;
                }
                i++;
            } else
                return false;
        }
        while(j<typedC.length) {
            if(nameC[i-1]!=typedC[j])
                return false;
            j++;
        }
        return i == name.length();
    }
}