public class Main {
    public static int solve(int[][] matrix,int i,int j,int[][] dp) {
        if(j>=matrix.length||j<0)return Integer.MAX_VALUE;
        if(i>=matrix.length)return 0;
        if(dp[i][j]!=1e9) return dp[i][j];
        int op1=solve(matrix,i+1,j-1,dp);
        int op2=solve(matrix,i+1,j,dp);
        int op3=solve(matrix,i+1,j+1,dp);
        return dp[i][j]=matrix[i][j]+Math.min(op1,Math.min(op2,op3));
    }
    public static int minFallingPathSum(int[][] matrix) {
        int ans=Integer.MAX_VALUE;
        int n=matrix.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n+1;++i) for(int j=0;j<n+1;++j) dp[i][j]=(int)1e9;
        for(int i=0;i<matrix.length;++i) ans=Math.min(ans,solve(matrix,0,i,dp));
        return ans;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
    }
}