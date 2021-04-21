package other;

import java.util.Arrays;

public class Solution {

//    public static int[] MaximumSubarrayDivide (int[] nums) {
//
//    }
//
//    public static other.DivideStatus getMaximum (int[] nums, int left, int right) {
//        if (left == right) {
//            return new other.DivideStatus(nums[left], nums[left], nums[left], nums[left], left, right);
//        }
//        int mid = (left + right) / 2;
//        other.DivideStatus LDS = getMaximum(nums, left ,mid);
//        other.DivideStatus RDS = getMaximum(nums, mid + 1, right);
//        return changeStatus(LDS,RDS);
//    }
//
//    public static other.DivideStatus changeStatus(other.DivideStatus l, other.DivideStatus r) {
//        int totalSum = l.totalSum + r.totalSum;
//        int leftSum = Math.max(l.maxSum, (l.totalSum+r.leftSum));
//        int rightSum = Math.max(r.maxSum, (l.rightSum + r.totalSum));
//        int midSum = l.rightSum + r.leftSum;
//        if (midSum > l.maxSum && midSum > r.maxSum) {
//            return new other.DivideStatus(totalSum, leftSum, rightSum, midSum);
//        }
//        if (l.maxSum > r.maxSum) {
//            return new other.DivideStatus(totalSum, leftSum, rightSum, l.maxSum, l.left, );
//        }
//    }



    public static int[] MaximumSubarrayDP (int[] nums){
        int length = nums.length;
        int largest = 0;
        int sum = nums[0];
        int left = 0;
        int right = 0;
        int flag = 0;
        for (int i = 1; i <= length; i++) {
            if (sum < 0) {
                flag = 0;
                sum = nums[i-1];
                continue;
            }
            sum = sum + nums[i-1];
            if (largest < sum) {
                if (flag == 0) {
                    left = i-1;
                    flag++;
                }
                right = i-1;
                largest = sum;
            }
        }
        return new int[]{largest,left,++right};
    }

    public static void longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int max = 0;
        int[][] dp = new int[m+1][n+1];
        int[][] type = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            char c1 = text1.charAt(i-1);
            for(int j = 1; j <= n; j++){
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    type[i][j]=1;
                }
                else{
                    if (dp[i-1][j]>dp[i][j-1]){
                        dp[i][j]=dp[i-1][j];
                        type[i][j]=2;
                    }else {
                        dp[i][j]=dp[i][j-1];
                        type[i][j]=3;
                    }
                }
            }
        }
        BA(m,n,text1,type);
    }

    public static void BA(int i,int j, String s, int[][] type) {
        if(i==0 || j==0){
            return ;
        }
        if (type[i][j]==1){
            BA(i-1,j-1,s,type);
            System.out.print(s.charAt(i-1));
        }
        else if (type[i][j]==2){
            BA(i-1,j,s,type);
        } else {
            BA(i,j-1,s,type);
        }
    }

    public static int[] split(int[] nums, int mid) {
        int[] save = new int[3];
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i]==nums[mid]) {
                save[0] = i;
                break;
            }
        }
        for (int i = nums.length-1; i >= 0; i--){
            System.out.println(nums[i]);
            if (nums[i]==nums[mid]) {
                save[1] = i;
                break;
            }
        }
        save[2] = save[1] - save[0] + 1;
        return save;
    }

    public static void maxCountNum(int[] nums, int[] res, int left, int right) {
        int mid = (left + right) / 2;
        int[] data = split(nums, mid);
        if (res[1] < data[2]) {
            res[1] = data[2];
            res[0] = nums[mid];
        }
        left = data[0];
        right = data[1];
        System.out.println(left+" "+right+" "+res[1]);
        if (left > res[1]) {
            maxCountNum(nums, res, 0, left);
        }
        if (nums.length - right > res[1]) {
            maxCountNum(Arrays.copyOfRange(nums,right,nums.length-1), res, 0, Arrays.copyOfRange(nums,right,nums.length-1).length);
        }
    }
}
