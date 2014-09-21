package com.Tol_V.tiscalc;

import java.util.ArrayList;

public class NodesTree {
    private static NodesTree instance;
    public static NodesTree getInstance() {
        if (instance == null){
            instance = new NodesTree();
        }

        return instance;
    }

    private final Category root;
    private Category current;

    {
        root = new Category(null, "Root", null, NodeType.CATEGORY);
    }

    private NodesTree() {
        current = root;
        fillTree();
    }

    private void fillTree(){
        Node level1Cat1 = new Category("level1Cat1", null, NodeType.CATEGORY);
        Node level1Cat2 = new Category("level1Cat2", null, NodeType.CATEGORY);

        Node level1Item1 = new Item("level1Item1", null, NodeType.ITEM, 11);
        Node level2Cat1 = new Category("level2Cat1", null, NodeType.CATEGORY);
        Node level2Cat2 = new Category("level2Cat2", null, NodeType.CATEGORY);
        Node level2Cat3 = new Category("level2Cat3", null, NodeType.CATEGORY);

        Node level3Item1 = new Item("level3Item1", null, NodeType.ITEM, 31);
        Node level3Item2 = new Item("level3Item2", null, NodeType.ITEM, 32);
        Node level3Item3 = new Item("level3Item3", null, NodeType.ITEM, 33);
        Node level3Item4 = new Item("level3Item4", null, NodeType.ITEM, 34);

        addChildren(level1Cat1);

        setCurrent((Category)level1Cat1);

        addChildren(level2Cat1);

        setCurrent((Category)level2Cat1);

        addChildren(level3Item1);

        setCurrentUp();
        setCurrentUp();

        addChildren(level1Cat2);

        setCurrent((Category)level1Cat2);

        addChildren(level2Cat2);

        setCurrent((Category)level2Cat2);

        addChildren(level3Item2);
        addChildren(level3Item3);

        setCurrentUp();

        addChildren(level2Cat3);

        setCurrent((Category)level2Cat3);

        addChildren(level3Item4);

        setCurrentUp();
        setCurrentUp();

        addChildren(level1Item1);
    }

    private void addChildren(Node child){
        child.setParent(current);
        current.addChildren(child);
    }

    public boolean setCurrent(Category newCurrent){
        if (newCurrent != null && newCurrent.getParent() == current){
            current = newCurrent;
            return true;
        }
        return  false;
    }

    public boolean setCurrentUp(){
        if (current != root){
            current = (Category)current.getParent();
            return true;
        }
        return false;
    }

    public ArrayList<Node> getChildren(){
        return current.getChildren();
    }

    public String toString(){
        String msg = "Root: " + root + '\n';
        msg += "Current: " + current;

        ArrayList<Node> children = current.getChildren();

        for(Node tmp: children){
            msg += "\n----" + tmp;
        }

        return msg;
    }
}
