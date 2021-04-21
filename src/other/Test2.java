package other;

import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        System.out.println("实验2：请输入整数个数");
        Scanner scanner = new Scanner(System.in);
        int count;
        count = scanner.nextInt();
        int[] nums = new int[count];
        System.out.println("请输入数组内容");
        Scanner scanner1 = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int[] res = new int[]{0, 0};
        Solution.maxCountNum(nums, res, 0, nums.length - 1);
        System.out.println(res[0] + " " + res[1]);
    }
}
