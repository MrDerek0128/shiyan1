package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(10);
        int[] pend = new int[5];
        Arrays.fill(pend,0);
        int[] flag = {0};
        new Solution().backTrack2(0,9,list,pend,0,flag);
        if (flag[0]==0) {
            System.out.println("no solution");
        }
    }
}
