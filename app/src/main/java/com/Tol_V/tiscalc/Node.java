package com.Tol_V.tiscalc;


public class Node {
    private Node parent;
    private String name;
    private String picturePath;
    private NodeType type;

    {
        parent = null;
        name = "";
        picturePath = "";
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

    public Node(Node t){
        this.parent = t.getParent();
        this.name = t.getName();
        this.picturePath = t.getPicturePath();
        this.type = t.getType();
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
        return "Type: " + type  + ". Name: " + name;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Node)){
            return false;
        }

        if (object == this){
            return true;
        }

        Node rhs = (Node)object;
        return rhs.getType() == this.type &&
                rhs.getName().equals(this.name) &&
                rhs.getParent() == this.parent &&
                rhs.getPicturePath().equals(this.picturePath);
    }
}
