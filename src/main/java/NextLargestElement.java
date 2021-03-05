/*
https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/
*/
public class NextLargestElement {
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] result = new long[n];
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
                result[i] = -1;
            }
        }
        return result;
    }
}