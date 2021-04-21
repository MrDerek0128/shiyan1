package Greedy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static ArrayList<Good> getGoods(int num) {
        ArrayList<Good> goods = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("请输入第"+(i+1)+"个商品的名称，重量及价格");
            Scanner scanner = new Scanner(System.in);
            goods.add(new Good(scanner.next(),scanner.nextInt(),scanner.nextInt()));
        }
        goods.sort(new Comparator<Good>() {
            @Override
            public int compare(Good o1, Good o2) {
                return o2.average.compareTo(o1.average);
            }
        });
        return goods;
    }

    public static ArrayList<Backpack> getBackpacks(int weight, ArrayList<Good> goods) {
        int w = 0;
        ArrayList<Backpack> backpacks = new ArrayList<>();
        for (Good good:goods) {
            float value;
            float percent;
            if (w+good.weight > weight) {
                value = (float) (weight-w)*good.average;
                percent = (float) (weight-w)/weight * 100;
            } else {
                value = good.price;
                w += good.weight;
                percent = (float) good.weight/weight * 100;
            }
            BigDecimal b = new BigDecimal(percent);
            percent = b.setScale(2, RoundingMode.HALF_UP).floatValue();
            backpacks.add(new Backpack(good.name,value,percent));
        }
        return backpacks;
    }

    public static ArrayList<Activity> getActivities(int num) {
        ArrayList<Activity> activities = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            System.out.println("请输入第"+(i+1)+"个活动的名称，开始时间及结束时间");
            Scanner scanner = new Scanner(System.in);
            activities.add(new Activity(scanner.next(), scanner.nextInt(), scanner.nextInt()));
        }
        activities.sort(new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o1.end.compareTo(o2.end);
            }
        });
        return activities;
    }

    public static ArrayList<Activity> getRes(ArrayList<Activity> activities) {
        ArrayList<Activity> res = new ArrayList<>();
        int now = 0;
        for (Activity activity:activities) {
            if (activity.start >= now) {
                res.add(activity);
                now = activity.end;
            }
        }
        return res;
    }
}
