package org.example;

import java.util.Scanner;

public class MoveBall {
    int[][] grid;
    int gridSize;
    MoveBall(){
        this.grid = new int[5][5];
    }
    MoveBall(int size){
        this.grid = new int[size][size];
    }
    MoveBall(int[][] grid){
        this.grid = grid;
    }

    void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 to move ball");
        System.out.println("enter 2 to terminate");
        String input = sc.nextLine();
        if(input.equals("1")){
            System.out.println(changeBallPosition());
        }
        else if(input.equals("2")){
            System.exit(0);
        }
        else{
            System.out.println("not proper input\n");
        }
    }

    MoveBall createGrid(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the grid size");
        gridSize = sc.nextInt();
        return new MoveBall(gridSize);
    }
    MoveBall changeBallPosition(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ball position");
        int ballPosition = sc.nextInt();
        for(int i = 0 ; i < grid.length ; i++){
            grid[grid.length-1][i] = 0;
        }
        grid[grid.length-1][ballPosition] = 1;
        return new MoveBall(grid);
    }
    public String toString(){
        String res = "";
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                res += grid[i][j]+" ";
            }
            res+="\n";
        }
        return res;
    }

    public static void main(String[] args) {
        MoveBall obj = new MoveBall();
        obj = obj.createGrid();
        while (true){
            obj.getInput();
        }
    }

}
