package org.codeforall.ooptimus;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {
    private Grid grid;
    private Save saveFile;
    private Load loadFile;
    private Rectangle cursor;

    public Cursor(Grid grid, Save saveFile, Load loadFile) {
        this.grid = grid;
        this.saveFile = saveFile;
        this.loadFile = loadFile;
        createCursor();
        init();
    }

    private void createCursor() {
        cursor = new Rectangle(grid.PADDING, grid.PADDING, grid.getCellSize(), grid.getCellSize());
        cursor.setColor(Color.BLUE);
        cursor.fill();
    }

    public void init() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(space);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(clear);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(load);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (cursor.getY() == 10) {
                    break;
                } else {
                    cursor.translate(0, -grid.getCellSize());
                    break;
                }

            case KeyboardEvent.KEY_DOWN:
                if (cursor.getY() == (10 + grid.getCellSize() * (grid.getRow() - 1))) {
                    break;
                } else {
                    cursor.translate(0, grid.getCellSize());
                    break;
                }

            case KeyboardEvent.KEY_LEFT:
                if (cursor.getX() == 10) {
                    break;
                } else {
                    cursor.translate(-grid.getCellSize(), 0);
                    break;
                }

            case KeyboardEvent.KEY_RIGHT:
                if (cursor.getX() == (10 + grid.getCellSize() * (grid.getCol() - 1))) {
                    break;
                } else {
                    cursor.translate(grid.getCellSize(), 0);
                    break;
                }

            case KeyboardEvent.KEY_SPACE:
                for (int i = 0; i < grid.squareList.size(); i++) {
                    if (grid.squareList.get(i).getX() == cursor.getX() &&
                            grid.squareList.get(i).getY() == cursor.getY()) {
                        if (!grid.squareList.get(i).isFilled()) {
                            grid.squareList.get(i).setColor(Color.BLACK);
                            grid.squareList.get(i).fill();
                        } else {
                            grid.squareList.get(i).setColor(Color.BLACK);
                            grid.squareList.get(i).draw();
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_C:
                for (Rectangle square : grid.squareList) {
                    square.setColor(Color.BLACK);
                    square.draw();
                }
                break;

            case KeyboardEvent.KEY_S:
                saveFile.saveInfo();
                break;

            case KeyboardEvent.KEY_L:
                loadFile.loadFileAndPaint();
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
