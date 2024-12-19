package org.example.models;

public class Snake extends Cell{
    private int endPosition;

    public Snake(int endPosition){
        super(CellType.SNAKE);
        this.endPosition = endPosition;
    }

    public int getEndPosition(){
        return endPosition;
    }
}
