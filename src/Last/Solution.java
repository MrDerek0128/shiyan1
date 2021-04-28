package Last;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void findShortestPath (int[][] graph,int v,int[] dist,int[] pre) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.length, o2.length);
            }
        });
        Node node = new Node(v,0);
        priorityQueue.add(node);
        int n = pre.length-1;
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        while (!priorityQueue.isEmpty()) {
            node = priorityQueue.poll();
            System.out.println("ddd");
            if (dist[node.name] >= node.length) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " " + dist[i]);
                    if (graph[node.name][i] != -1 && node.length + graph[node.name][i] < dist[i]) {
                        dist[i] = node.length + graph[node.name][i];
                        System.out.println(dist[i]);
                        pre[i] = node.name;
                        Node node1 = new Node(i, dist[i]);
                        priorityQueue.add(node1);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(i+"的最短距离为:"+dist[i]+" 前驱点为："+pre[i]);
        }
    }

}
