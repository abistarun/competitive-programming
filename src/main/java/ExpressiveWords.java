import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExpressiveWords {
    public Map<Integer, Integer> fillCountFor(String str) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        for(int i=0; i<str.length(); i++) {
            int cnt = 1;
            int ind = i;
            while (i+1<str.length() && str.charAt(i) == str.charAt(i+1)) {
                cnt++;
                i++;
            }
            countMap.put(ind, cnt);
        }
        return countMap;
    }

    public int expressiveWords(String S, String[] words) {
        Map<Integer, Integer> sMap = fillCountFor(S);
        int cnt = 0;
        for (int i=0; i<words.length; i++) {
            Map<Integer, Integer> wMap = fillCountFor(words[i]);
            Iterator<Map.Entry<Integer, Integer>> sit = sMap.entrySet().iterator();
            Iterator<Map.Entry<Integer, Integer>> wit = wMap.entrySet().iterator();

            int isPresent = 1;
            while(sit.hasNext() && wit.hasNext()) {
                Map.Entry<Integer, Integer> sEntry = sit.next();
                Map.Entry<Integer, Integer> wEntry = wit.next();

                char sCh = S.charAt(sEntry.getKey());
                char wCh = words[i].charAt(wEntry.getKey());

                int c1 = sEntry.getValue();
                int c2 = wEntry.getValue();

                if (sCh!=wCh) {
                    isPresent = 0;
                    break;
                }
                if (c1 < 3 && c1 != c2 || c1 < c2) {
                    isPresent = 0;
                    break;
                }
            }
            if(isPresent>=1 && !sit.hasNext() && !wit.hasNext())
                cnt++;

        }
        return cnt;
    }
}