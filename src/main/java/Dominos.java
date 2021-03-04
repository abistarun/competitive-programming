/*
https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
*/
public class Dominos {
    public int minDominoRotations(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        for(int d=1;d<=6; d++) {
            int cnt = 0;
            int i=0;
            for(i=0; i<A.length; i++) {
                if (A[i] == d)
                    continue;
                if (B[i] == d)
                    cnt++;
                else
                    break;
            }
            if(i==A.length && cnt<min)
                min = cnt;

            cnt = 0;
            i=0;
            for(i=0; i<A.length; i++) {
                if (B[i] == d)
                    continue;
                if (A[i] == d)
                    cnt++;
                else
                    break;
            }
            if(i==A.length && cnt<min)
                min = cnt;

        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}