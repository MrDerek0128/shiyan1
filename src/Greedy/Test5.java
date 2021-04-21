package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        int num;
        System.out.println("请输入活动数量");
        Scanner scanner1 = new Scanner(System.in);
        num = scanner1.nextInt();
        ArrayList<Activity> activities = Solution.getActivities(num);
        ArrayList<Activity> res = Solution.getRes(activities);
        System.out.println("被选中的活动为");
        for (Activity activity:res) {
            System.out.println(activity.name+" "+activity.start+" "+activity.end);
        }
    }
}
