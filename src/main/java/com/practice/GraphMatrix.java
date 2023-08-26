package com.practice;

public class GraphMatrix {

    int[][] adjMatrix;
    int numVertices;

    GraphMatrix(int numVertices){
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source,int destination, int weight){

        adjMatrix[source][destination]=weight;
    }

    public int getEdge(int source,int destination){

        return  adjMatrix[source][destination];
    }

    public void printGraph(){
        for(int i =0 ;i<numVertices;i++){
            for(int j =0 ;j<numVertices;j++){
                System.out.println(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numberVertices=5;
        GraphMatrix graph = new GraphMatrix(numberVertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 5);
        graph.printGraph();

    }
}
