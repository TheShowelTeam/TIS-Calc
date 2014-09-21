package com.Tol_V.tiscalc;

public class FinalItem extends Item {

    private String comment;
    private int count;
    private int fullPrice;

    {
        comment = "";
        count = 1;
        fullPrice = calcFullPrice();
    }

    private int calcFullPrice(){
        return count * price;
    }

    public FinalItem(Item item, String comment, int count){
        super(item);
        this.comment = comment;
        this.count = count;
        this.fullPrice = calcFullPrice();
    }

    public FinalItem(FinalItem rhs){
        super(rhs);
        this.comment = rhs.getComment();
        this.count = rhs.getCount();
        this.fullPrice = rhs.getFullPrice();
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
            this.comment += "||";
            this.comment += newComment;
        }
    }

    public void recountFinalPrice(){
        this.fullPrice = calcFullPrice();
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
