package com.Tol_V.tiscalc;

public class Item extends Node{

    int price;

    {
        price = 0;
    }

    public Item(){
        super();
    }

    public Item(int price){
        super();
        this.price = price;
    }

    public Item(Node parent, String name, String pic, NodeType type, int price){
        super(parent, name, pic, type);
        this.price = price;
    }

    public Item(String name, String pic, NodeType type, int price){
        super(name, pic, type);
        this.price = price;
    }

    public Item(Item i){
        super(i);
        this.price = i.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + ". Price: " + price;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)){
            return false;
        }

        if (!(object instanceof Item)){
            return false;
        }

        if (this == object){
            return true;
        }

        Item rhs = (Item)object;

        return rhs.getPrice() == this.price;
    }
}
