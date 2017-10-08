package com.satkuru.algo.maze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Maze
 * S - start point
 * E - end point
 * # - Wall
 * . - possible path
 */
public class Maze {


    private char[][] grid;//grid[row][col]

    private Cell startPoint=null;

    public char[][] getGrid() {
        return grid;
    }

    public Cell getStartPoint() {
        return startPoint;
    }

    public Maze(){

    }

    //a handy overloaded constructor to help with testing
    public Maze(char[][] grid,Cell startPoint) {
        this.grid = grid;
        this.startPoint = startPoint;
    }


    /**
     * Build the maze from a given input file.
     * Grid is flexible to allow various column and row sizes
     * @param inFileName
     */
    public void buildMaze(String inFileName) {
        int maxCol=0;
        int maxRow=0;
        Scanner inFile = null;
        try
        {
            inFile = new Scanner(new FileInputStream(inFileName));
        }
        catch (FileNotFoundException e)
        {
            System.out.printf("Cannot find '%s'.  Exiting...\n", inFileName);
            System.exit(1);
        }
        List<String> listInput = new ArrayList<>();
        if(inFile.hasNext()){
            String line = inFile.nextLine();
            maxCol=line.length();
            listInput.add(line);
        }else {
            throw new IllegalArgumentException("Input file doesn't contain valid maze to load");
        }

        while (inFile.hasNext()){
            listInput.add(inFile.nextLine());
        }

        maxRow=listInput.size();
        grid = new char[maxRow][maxCol];
        int col=0,row=0;
        for (String line:listInput) {
            for (int i = 0; i < maxCol; i++) {
                char cellValue = line.charAt(i);
                if(cellValue=='S'){
                    startPoint=new Cell(i,row,cellValue);
                }
                grid[row][i]=cellValue;
            }
            row++;
        }
        if(startPoint==null){
            throw new IllegalArgumentException("Input file does not contain a valid starting point");
        }
    }
    public void print() {
        System.out.println("Maze\n");
        for (int i=0;i<grid.length;i++ ) {
            for(int j=0;j<grid[i].length;j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public void solve() {
        final List<Cell> path = new ArrayList<Cell>();
        char[][] copy = DepthFirst.deepCopy(grid);
        DepthFirst.searchPath(copy, startPoint.getColumn(), startPoint.getRow(), path);

        //apply the path cell to the grid
        for (Cell cell:path) {
            grid[cell.getRow()][cell.getColumn()]=cell.getValue();
        }
        //re-mark the start cell
        grid[startPoint.getRow()][startPoint.getColumn()]=startPoint.getValue();
    }

    public static void main(String[] args) {
        String inputFile = args[0];
        Maze maze = new Maze();
        maze.buildMaze(inputFile);
        maze.print();
        maze.solve();
        maze.print();


    }
}
