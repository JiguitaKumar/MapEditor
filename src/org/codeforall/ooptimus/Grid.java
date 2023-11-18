package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Grid {
    private Rectangle grid;
    private int col;
    private int row;
    private int cellSize;
    public int PADDING = 10;
    public LinkedList<Rectangle> squareList = new LinkedList<>();

    public Grid(int col, int row, int cellSize) {
        this.col = col;
        this.row = row;
        this.cellSize = cellSize;
        createGrid();
    }

    private void createGrid() {

        grid = new Rectangle(PADDING, PADDING, col * cellSize, row * cellSize);
        grid.setColor(Color.WHITE);
        grid.fill();

        for (int i = PADDING; i < (col * cellSize + PADDING); i += cellSize) {
            for (int j = PADDING; j < (row * cellSize + PADDING); j += cellSize) {
                Rectangle square = new Rectangle(i, j, cellSize, cellSize);
                squareList.add(square);
                square.draw();
            }
        }
    }

    public int getCol(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public int getCellSize(){
        return this.cellSize;
    }


}
