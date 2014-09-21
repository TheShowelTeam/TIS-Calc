package com.Tol_V.tiscalc;

import java.util.ArrayList;

public class Category extends Node {

    ArrayList<Node> children;

    {
        children = new ArrayList<Node>();
    }

    public Category(){
        super();
    }

    public Category(String name, String pic, NodeType type){
        super(name, pic, type);
    }

    public Category(Node parent, String name, String pic, NodeType type){
        super(parent, name, pic, type);
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChildren(Node child){
        children.add(child);
    }

}
