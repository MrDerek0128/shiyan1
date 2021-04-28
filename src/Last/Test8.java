package Last;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        System.out.println("请输入顶点个数");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] graph = new int[num+1][num+1];
        int[] dist = new int[num+1];
        int[] pre = new int[num+1];
        System.out.println("请输入图的路径");
        Scanner scanner1 = new Scanner(System.in);
        for (int i = 0; i < num; i++) {
            String line = scanner1.nextLine();
            String[] s = line.split(",");
            for (int j = 0; j < num; j++) {
                graph[i+1][j+1] = Integer.parseInt(s[j]);
            }
        }
        Solution.findShortestPath(graph,1,dist,pre);
    }
}
