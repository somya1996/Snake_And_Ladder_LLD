package org.example.models;

import java.util.List;

public abstract class Cell extends BaseModel{
    private CellType type;
    public Cell(CellType type) {
        this.type = type;
    }

    public CellType getType(){
        return type;
    }
}
