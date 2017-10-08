package com.satkuru.algo.maze;


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
    public char getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (column != cell.column) return false;
        if (row != cell.row) return false;
        return value == cell.value;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + (int) value;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "column=" + column +
                ", row=" + row +
                ", value=" + value +
                '}';
    }
}
