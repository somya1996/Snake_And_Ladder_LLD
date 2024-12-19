package org.example.models;

public class Ladder extends Cell{
    private int endPosition;

    public Ladder(int endPosition){
        super(CellType.LADDER);
        this.endPosition = endPosition;
    }

    public int getEndPosition(){
        return endPosition;
    }
}
