package com.practice;


import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static  class MinPathDistance {
        String path;
        int minDistance;
        public MinPathDistance(String path, int minDistance) {
            this.path = path;
            this.minDistance = minDistance;
        }
    }

    static class Edge{
        int source;
        int nbr;
        int weight;
        public Edge(int source, int nbr, int weight) {
            this.source = source;
            this.nbr = nbr;
            this.weight = weight;
        }
    }

    static class Pair{
        Integer vertex;
        int wtn;

        public Pair(int vertex, int wtn) {
            this.vertex = vertex;
            this.wtn = wtn;
        }
    }


    public static void main(String[] args) {
        // [list,list2,list3,list4,list5,list6]
        // [0] -> [0,1,10] [0,3,40] -> list1
        // [1] -> [1,2,10] [1,0,10] -> list2

        // [0] -> emptylist
        // [1] => emptylist
        // [2] -> emptylist

        ArrayList<Edge> [] graph = new ArrayList[7];
        for (int i =0 ; i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));

        graph[2].add(new Edge(2,3,10));
        graph[2].add(new Edge(2,1,10));

        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,2));


        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));
        graph[4].add(new Edge(4,3,2));


        graph[5].add(new Edge(5,6,6));
        graph[5].add(new Edge(5,4,3));

        graph[6].add(new Edge(6,5,6));
        graph[6].add(new Edge(6,4,8));

        int source =0;
        int destination = 6;
        MinPathDistance minPathDistance = shortestPathUsingDijkstra(graph, source,destination);
        System.out.println("The Path is " + minPathDistance.path + " Distance is" + minPathDistance.minDistance);
    }

    private static MinPathDistance shortestPathUsingDijkstra(ArrayList<Edge>[] graph, int source, int destination) {
        boolean [] visited = new boolean[graph.length];
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((o1,o2)-> o1.wtn -o2.wtn);
        minHeap.offer(new Pair(source,0));
        MinPathDistance  minPathDistance = null;
        String totalPath = "";

    while(!minHeap.isEmpty()){
            //remove
            Pair top = minHeap.poll();
            // visited
            int currentVertex=top.vertex;
            visited[currentVertex]=true;
            System.out.println( "vertex " + currentVertex + "Weight till now " + top.wtn);
            totalPath= totalPath +top.vertex.toString();
            if(currentVertex==destination){
                minPathDistance= new MinPathDistance(totalPath, top.wtn);
                break;

            }
            // add
            for(Edge edge: graph[currentVertex]){
                if(!visited[edge.nbr]){
                    int wtn = top.wtn + edge.weight;
                    int vertx =edge.nbr;
                    Pair pair= new Pair(vertx,wtn);
                    minHeap.offer(pair);
                }
            }

        }
        return minPathDistance;
    }
}
