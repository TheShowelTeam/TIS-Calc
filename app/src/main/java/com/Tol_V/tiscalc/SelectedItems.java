package com.Tol_V.tiscalc;

import java.util.ArrayList;

public class SelectedItems {
    private static SelectedItems instance;

    public static SelectedItems getInstance() {
        if (instance == null){
            instance = new SelectedItems();
        }

        return instance;
    }

    ArrayList<Item> items;

    {
        items = new ArrayList<Item>();
    }

}
