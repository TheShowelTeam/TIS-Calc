package com.Tol_V.tiscalc;

public class FinalItem extends Item {

    private String comment;
    private int count;
    private int fullPrice;

    {
        comment = "";
        count = 1;
        fullPrice = calcFinalPrice();
    }

    private int calcFinalPrice(){
        return count * price;
    }

    public FinalItem(Item item, String comment, int count){
        super(item);
        this.comment = comment;
        this.count = count;
    }

    public String getComment(){
        return comment;
    }

    public int getCount(){ return count;}

    public int getFullPrice(){ return fullPrice; }

    public void setCount(int newCount){
        this.count = newCount;
    }

    public void setComment(String newComment){
        if (newComment != null){
            this.comment = newComment;
        }
    }

    public String toString(){
        return super.toString() + ". Comment: " + comment +
                ". Count: " + count + ". Full price: " + fullPrice;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
}
