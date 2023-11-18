package org.codeforall.ooptimus;


import org.academiadecodigo.simplegraphics.graphics.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Load {
    private FileReader loadFile;
    private BufferedReader bReader;
    private String path = "resources/saveFile.txt";
    private Grid grid;

    public Load(Grid grid){
        this.grid = grid;
    }

    public void loadFileAndPaint(){
        try {
            loadFile = new FileReader(path);
            bReader = new BufferedReader(loadFile);

            String line = "";
            String result = "";

            while((line = bReader.readLine()) != null){
                result += line;
            }

            result = result.replaceAll("[()\\[\\]]", "");
            String[] loadedInfo = result.split(", ");
            for(int i = 0; i < loadedInfo.length; i++){
                if(loadedInfo[i].equals("true")){
                    grid.squareList.get(i).setColor(Color.BLACK);
                    grid.squareList.get(i).fill();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
