package graph;

import java.util.*;

public class Store {
    static class Node{
        int val;
        int in;
        int out;
        ArrayList<Node> nexts = new ArrayList<>();
        ArrayList<Edge> edges = new ArrayList<>();
        Node(int val){
            this.val = val;
        }
    }
    static class Edge{
        Node from;
        Node to;
        int weight;
    }

    static class Graph{
        HashMap<Integer, Node> nodes = new HashMap<>(); // 0 - > node(0)
        HashSet<Edge> edges = new HashSet<>();
    }
    public static Graph createGraph(Integer[][] arr){
        Graph graph = new Graph();
        Map<Node,Integer> map = new HashMap<>();
        Set<Map.Entry<Node, Integer>> entries = map.entrySet();
        for (Integer[] integers : arr) {
            int u = integers[0];
            int v = integers[1];
            if (!graph.nodes.containsKey(u)) {
                graph.nodes.put(u,new Node(u));
            }

            if (!graph.nodes.containsKey(v))
                graph.nodes.put(v,new Node(v));

            Node fromNode = graph.nodes.get(u);
            Node toNode = graph.nodes.get(v);
            fromNode.out++;
            toNode.in++;
            fromNode.nexts.add(toNode);
            Edge edge = new Edge();
            edge.from = fromNode;
            edge.to = toNode;
            fromNode.edges.add(edge);
            graph.edges.add(edge);
        }
        return graph;
    }



    //*************临接矩阵***********************//
    static class Juzhen{
        static final int N = 100;
        int[][] node = new int[N][N];
    }
    //*************临接矩阵***********************//


    //*************临接表***********************//
    static class Biao{
        static final int N = 100;
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    }
    //*************临接表***********************//


}
