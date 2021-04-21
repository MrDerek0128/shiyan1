package BackTrack;

import java.util.List;

public class Test7 {
    public static void main(String[] args) {
        List<List<String>> res = new Solution().nQueen(8);
        for (List<String> re : res) {
            for (String s : re) {
                System.out.println(s);
            }
            System.out.println(" ");
        }
        System.out.println(res.size());
    }
}
