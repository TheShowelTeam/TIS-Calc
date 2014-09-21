package com.Tol_V.tiscalc;

import android.util.Log;

import java.util.ArrayList;

public class SelectedItems {
    private static SelectedItems instance;

    public static SelectedItems getInstance() {
        if (instance == null){
            instance = new SelectedItems();
        }

        return instance;
    }

    private ArrayList<FinalItem> items;

    {
        items = new ArrayList<FinalItem>();
    }

    public void addFinalItem(FinalItem fi){

        //do not work

        if (items.contains(fi)){
            Log.d("testing contains() method: ", "found equal elements");
            int index = items.indexOf(fi);

            FinalItem tmp = items.get(index);
            tmp.setCount(tmp.getCount() + fi.getCount());
            tmp.setComment(fi.getComment());
        } else {
            items.add(fi);
        }
    }

    public FinalItem getFinalItem(int index){
        if (index > 0 && index < items.size()){
            return items.get(index);
        }
        return null;
    }

    public ArrayList<FinalItem> getItems(){
        return new ArrayList<FinalItem>(items);
    }

}
