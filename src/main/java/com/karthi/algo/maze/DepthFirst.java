package com.karthi.algo.maze;

import java.util.Arrays;
import java.util.List;


public class DepthFirst {

    public static boolean searchPath(char[][] maze, int x, int y, List<Cell> path) {

        if (maze[y][x] == 'E') {
            path.add(new Cell(x,y,maze[y][x]));
            return true;
        }

        if (maze[y][x] == ' '||maze[y][x] == 'S') {
            maze[y][x] = '.';

            int dx = -1;
            int dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(new Cell(x,y, maze[y][x]));
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(new Cell(x,y, maze[y][x]));
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(new Cell(x,y, maze[y][x]));
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(maze, x + dx, y + dy, path)) {
                path.add(new Cell(x,y, maze[y][x]));
                return true;
            }
        }
        return false;
    }

    public static char[][] deepCopy(char[][] original) {

        char[][] copy = new char[original.length][original[0].length];
        for (int i = 0; i < copy.length; i++)
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        return copy;
    }
}
