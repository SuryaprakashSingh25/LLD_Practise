package snakeAndLadder;

import snakeAndLadder.enums.Color;

public class Player {
    private String name;
    private Color color;
    private int position;

    public Player(String name,Color color){
        this.name=name;
        this.color=color;
        this.position=0;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int pos){
        this.position=pos;
    }

    public String getName(){
        return name;
    }

}
