package com.practice;

public class DFSTraversal {

    public static void main(String[] args) {
        int[][] maize = {
                {0,1,0,0,0,0,0},
                {0,1,0,0,1,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,1,1},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0}
        };
        String ans="";
        int row =0;
        int col =0;
        boolean[][] visited= new boolean[maize.length][maize[0].length];
        floodfill(maize,row,col,ans,visited);

    }

    private static void floodfill(int[][] maize, int row, int column, String ans, boolean[][] visited) {

        if(row>=maize.length || column>=maize[0].length || row<0 || column <0 || visited[row][column] || maize[row][column]==1){

            return;
        }


        if(row==maize.length-1 && column==maize[0].length-1){
            System.out.println(ans);
            return;
        }

        visited[row][column]=true;
        floodfill(maize,row-1,column,ans+"t",visited);
        floodfill(maize,row+1,column,ans+"d",visited);
        floodfill(maize,row,column-1,ans+"l",visited);
        floodfill(maize,row,column+1,ans+"r",visited);
        visited[row][column]=false;
    }


}
