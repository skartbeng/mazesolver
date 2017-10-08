package com.satkuru.algo.maze;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by karthi on 08/10/17.
 */
public class MazeTest {
    private String inputFilename = null;
    private  char[][] inputgrid = {
            {'#','#','#','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ','#'},
            {'#',' ','#',' ','#',' ','#'},
            {'#',' ','#','E','#',' ','#'},
            {'#',' ','#','#','#',' ','#'},
            {'#','S',' ',' ','#',' ','#'},
            {'#','#','#','#','#','#','#'}
    };//[row][col]

    private char[][] outputGrid = {
            {'#','#','#','#','#','#','#'},
            {'#','.','.','.',' ',' ','#'},
            {'#','.','#','.','#',' ','#'},
            {'#','.','#','E','#',' ','#'},
            {'#','.','#','#','#',' ','#'},
            {'#','S',' ',' ','#',' ','#'},
            {'#','#','#','#','#','#','#'}
    };//[row][col]


    char[][] largeGridIn = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','S','#',' ','#',' ','#',' ',' ',' ',' ',' ','#'},
            {'#',' ','#',' ',' ',' ','#',' ','#','#','#',' ','#'},
            {'#',' ',' ',' ','#','#','#',' ',' ',' ',' ',' ','#'},
            {'#',' ','#',' ',' ',' ',' ',' ','#','#','#',' ','#'},
            {'#',' ','#',' ','#','#','#',' ','#',' ',' ',' ','#'},
            {'#',' ','#',' ','#',' ',' ',' ','#','#','#',' ','#'},
            {'#',' ','#',' ','#','#','#',' ','#',' ','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','E','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#'}
    };

    char[][] largeGridOut = {
            {'#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','S','#',' ','#',' ','#',' ',' ',' ',' ',' ','#'},
            {'#','.','#',' ',' ',' ','#',' ','#','#','#',' ','#'},
            {'#','.','.','.','#','#','#','.','.','.','.','.','#'},
            {'#',' ','#','.','.','.','.','.','#','#','#','.','#'},
            {'#',' ','#',' ','#','#','#',' ','#',' ',' ','.','#'},
            {'#',' ','#',' ','#',' ',' ',' ','#','#','#','.','#'},
            {'#',' ','#',' ','#','#','#',' ','#',' ','#','.','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#','E','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#'}
    };
    @Before
    public void setup(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("input.txt").getFile());
        inputFilename = file.getAbsolutePath();
    }

    @Test
    public void canBuildFromFile(){

        Maze maze = new Maze();
        maze.buildMaze(inputFilename);
        Assert.assertArrayEquals(inputgrid,maze.getGrid());
        Assert.assertEquals(new Cell(1,5,'S'),maze.getStartPoint());

    }

    @Test
    public void canSolvePath(){
        Maze maze = new Maze();
        maze.buildMaze(inputFilename);
        maze.solve();
        Assert.assertArrayEquals(outputGrid,maze.getGrid());
    }

    @Test
    public void canHandleLargeGrid(){
        Maze maze = new Maze(largeGridIn,new Cell(1,1,'S'));
        Assert.assertArrayEquals(largeGridIn,maze.getGrid());
        Assert.assertEquals(new Cell(1,1,'S'),maze.getStartPoint());
        maze.solve();
        Assert.assertArrayEquals(largeGridOut,maze.getGrid());
    }

    //TODO
    //Add negative test cases to handle file input, multidimensional grid
}
