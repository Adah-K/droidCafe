package com.example.mydroidcaffev1;

public class Stores {
    private final int storeImage;
    private String storeTitle;
    private String storeTime;
    private String storeDescription;

    Stores(int storeImage, String storeTitle, String storeTime, String storeDescription){
        this.storeImage = storeImage;
        this.storeTitle = storeTitle;
        this.storeTime = storeTime;
        this.storeDescription = storeDescription;
    }
    public int getStoresImage() {return storeImage;}

    public String getStoresTitle() {return storeTitle;}

    public String getStoresTime() {return storeTime;}

    public String getStoresDescription() {return storeDescription;}


}
