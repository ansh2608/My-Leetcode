import java.util.Arrays;

public class Main {
    public static int numSquares(int n){
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=1;i<=n;i++){
            int min_val=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;j++) min_val=Math.min(min_val,dp[i-j*j]+1);
            dp[i]=min_val;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=12;
        System.out.println(numSquares(n));
    }
}