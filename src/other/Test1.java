package other;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        System.out.println("实验1：请输入整数个数");
        Scanner scanner = new Scanner(System.in);
        int count;
        count=scanner.nextInt();
        int[] nums = new int[count];
        System.out.println("请输入数组内容");
        Scanner scanner1 = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] res = Solution.MaximumSubarrayDP(nums);
        System.out.println("最大字段和：" + res[0]);
        System.out.println("起始下标：" + res[1] + "  中止下标：" + res[2]);
    }
}
