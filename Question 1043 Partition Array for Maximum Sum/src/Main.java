import java.util.Arrays;

public class Main {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length,K = k + 1;
        int[] dp = new int[k + 1];
        Arrays.fill(dp, 0);
        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);
            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start % K] = Math.max(dp[start % K], dp[(i + 1) % K] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr,k));
    }
}