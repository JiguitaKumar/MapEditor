package org.codeforall.ooptimus;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid(30, 20, 40);
        Save save = new Save(grid);
        Load load = new Load(grid);
        Cursor cursor = new Cursor(grid, save, load);

    }
}
