package SnakeAndLadders.Entities;

public class Player {
    public String name;
    private int position;
    private int id;

    public Player(String name){
        this.name = name;
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public void setId(int id){
        this.id = id;
    }
}
