/*
https://practice.geeksforgeeks.org/problems/rotation4723
*/
public class Rotation {
    int findKRotation(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i])
                return i;
        }
        return 0;
    }
}