package ca.cmpt213.web.model;

//Attributes and details of a Tokimon
public class Tokimon {

    private long id;

    private String name;
    private int weight;
    private int height;

    private int strength;
    private String color;
    private int fire;
    private int water;
    private int electric;
    private int ice;
    private int fly;


    public Tokimon(String name, int weight, int height, int strength, int fire, int water, int electric, int ice, int fly, String color){
        this.name = name;
        this.weight = weight;
        this.height = height;

        this.strength = strength;
        this.color = color;

        this.fire = fire;
        this.water = water;
        this.electric = electric;
        this.ice = ice;
        this.fly = fly;
    }

    public String getName(){
        return name;
    }
    public int getWeight(){
        return weight;
    }
    public int getHeight(){
        return height;
    }
    public String getColor() { return color;}

    public void setId(long tag){
        id = tag;
    }


    public void setHeight(int newHeight){
        this.height = newHeight;
    }

}
