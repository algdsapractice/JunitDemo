package com.practice;

import java.util.LinkedList;
import java.util.List;

public class GraphBFSImplementation {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    GraphBFSImplementation(int vertices){
        this.vertices=vertices;
        this.adjList = new LinkedList[vertices];
        for(int i=0; i<vertices;i++){
            adjList[i] = new LinkedList<>();
        }
    }


    public void addEdge(int source, int destination){
        adjList[source].add(destination);
    }

    public static void main(String[] args) {

        GraphBFSImplementation graph = new GraphBFSImplementation(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);

        graph.bfsTraverse(0);


    }

    private void bfsTraverse(int startVertex) {
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startVertex]=true;
        queue.add(startVertex);
        while (!queue.isEmpty()){
            int currentVertex = queue.poll();
            System.out.println(currentVertex);

            //1 -> new Linked
            for(int neighbour : adjList[currentVertex]){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
    }

}
