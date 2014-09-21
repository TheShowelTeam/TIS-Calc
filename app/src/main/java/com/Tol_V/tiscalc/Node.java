package com.Tol_V.tiscalc;


public class Node {
    private Node parent;
    private String name;
    private String picturePath;
    private NodeType type;

    {
        parent = null;
        name = null;
        picturePath = null;
        type = null;
    }

    public Node(){}

    public Node(Node parent, String name, String pic, NodeType type){
        this.parent = parent;
        this.name = name;
        this.picturePath = pic;
        this.type = type;
    }

    public Node(String name, String pic, NodeType type){
        this.name = name;
        this.picturePath = pic;
        this.type = type;
    }

    //getters
    public Node getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public NodeType getType() {
        return type;
    }

    //setters
    public void setParent(Category parent){
        this.parent = parent;
    }

    @Override
    public String toString() {
        return type  + ": " + name;
    }
}
