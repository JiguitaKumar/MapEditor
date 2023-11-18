package org.codeforall.ooptimus;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class Save {

    private FileOutputStream saveFile;
    private String path = "resources/saveFile.txt";
    private Grid grid;


    public Save(Grid grid){
        this.grid = grid;
    }

    public void saveInfo(){
        try {
            saveFile = new FileOutputStream(path);

            LinkedList<Boolean> isPainted = new LinkedList<>();
            for(int i = 0; i < grid.squareList.size(); i++) {
                isPainted.add(grid.squareList.get(i).isFilled());
            }

            byte[] buffer = isPainted.toString().getBytes();
            saveFile.write(buffer);

            saveFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
