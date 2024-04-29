public class Main {
    public static int minOperations(int[] nums, int k) {
        int finalXor = 0,count = 0;
        for (int n : nums) finalXor = finalXor ^ n;
        while (k > 0 || finalXor > 0) {
            if ((k % 2) != (finalXor % 2)) count++;
            k /= 2;
            finalXor /= 2;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        int k = 1;
        System.out.println(minOperations(nums,k));
    }
}