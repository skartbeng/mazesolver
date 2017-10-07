package com.karthi.algo.maze;

/**
 * Created by karthi on 04/10/17.
 */
public class Cell {
    private final int column;
    private final int row;
    private final char value;

    public Cell(int x, int y, char c) {

        this.column = x;
        this.row = y;
        value = c;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "column=" + column +
                ", row=" + row +
                '}';
    }

    public char getValue() {
        return value;
    }
}
