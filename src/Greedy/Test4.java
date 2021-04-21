package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        int num;
        System.out.println("请输入物品数量");
        Scanner scanner1 = new Scanner(System.in);
        num = scanner1.nextInt();
        ArrayList<Good> goods = Solution.getGoods(num);
        int weight;
        System.out.println("请输入背包承受重量");
        Scanner scanner2 = new Scanner(System.in);
        weight = scanner2.nextInt();
        ArrayList<Backpack> backpacks = Solution.getBackpacks(weight,goods);
        float total = 0;
        System.out.println("背包详情为");
        for (Backpack backpack:backpacks) {
            total += backpack.value;
            System.out.println(backpack.name+" "+backpack.value+" "+backpack.percent);
        }
        System.out.println("总价值为"+total);
    }
}
