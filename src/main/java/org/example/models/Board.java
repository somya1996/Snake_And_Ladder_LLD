package org.example.models;

import java.util.List;
import java.util.Map;
import java.lang.IllegalArgumentException;

public class Board  extends BaseModel{
    private Cell[] cells;

    public Board(){
        cells = new Cell[100]; //10X10 board
        for(int i=0; i<100; i++){
            cells[i] = new EmptyCell();
        }

        //Initialise Snakes and Ladder
        cells[16] = new Snake(6); // Snake from 16 to 6
        cells[47] = new Snake(26); // Snake from 47 to 26
        cells[49] = new Ladder(99); // Ladder from 49 to 99
        cells[56] = new Ladder(73); // Ladder from 56 to 73
    }

    public Cell getCell(int position) {
        if (position < 0 || position > cells.length) { // Assuming boardSize is the size of your board
            throw new IllegalArgumentException("Position out of bounds: " + position);
        }
        return cells[position]; // Assuming cells is your array or list of cells
    }

}
