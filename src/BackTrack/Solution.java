package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public List<List<String>> nQueen(int n) {
        List<List<String>> res = new  ArrayList<List<String>>();
        HashSet<Integer> column = new HashSet<>();
        HashSet<Integer> diagonal1 = new HashSet<>();
        HashSet<Integer> diagonal2 = new HashSet<>();
        int[] queens = new int[n];
        Arrays.fill(queens,-1);
        backTrack(res,queens,n,0,column,diagonal1,diagonal2);
        return res;
    }

    public void backTrack (List<List<String>> res, int[] queens, int n, int row, HashSet<Integer> column, HashSet<Integer> diagonal1, HashSet<Integer> diagonal2) {
        if (n==row) {
            res.add(record(queens,n));
        } else {
            for (int i = 0; i < n; i++) {
                if (column.contains(i)) {
                    continue;
                }
                int pend1 = row - i;
                if (diagonal1.contains(pend1)) {
                    continue;
                }
                int pend2 = row + i;
                if (diagonal2.contains(pend2)) {
                    continue;
                }
                queens[row] = i;
                column.add(i);
                diagonal1.add(pend1);
                diagonal2.add(pend2);
                backTrack(res,queens,n,row+1,column,diagonal1,diagonal2);
                queens[row] = -1;
                column.remove(i);
                diagonal1.remove(pend1);
                diagonal2.remove(pend2);
            }
        }
    }

    public List<String> record(int[] queens, int n) {
        List<String> record = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queens[i]] = 'Q';
            record.add(new String(chars));
        }
        return record;
    }

    public void backTrack2(int p, int target, List<Integer> list, int[] pend, int sum, int[] flag) {
        if (p == list.size()) {
            if (sum == target) {
                for (int i = 0; i < pend.length; i++) {
                    if (pend[i] == 1) {
                        System.out.print(list.get(i)+" ");
                    }
                }
                System.out.println(" ");
                flag[0]++;
            }
        } else {
            sum += list.get(p);
            pend[p] = 1;
            backTrack2(p+1,target,list,pend,sum,flag);
            sum -= list.get(p);
            pend[p] = 0;
            backTrack2(p+1,target,list,pend,sum,flag);
        }
    }
}
