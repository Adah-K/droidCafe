package com.example.mydroidcaffev1;

public class Pastries {

    private final int pastriesImage;
    private String pastriesDescription;
    private String pastriesPrepTime;
    private String pastriesTitle;
    //Create a recipe for the recipe data model and pass the parameters: recipeImage, recipeTitle, recipeDescription

    Pastries(int pastriesImage, String pastriesTitle, String pastriesPrepTime,String pastriesDescription) {
        this.pastriesImage = pastriesImage;
        this.pastriesTitle = pastriesTitle;
        this.pastriesPrepTime = pastriesPrepTime;
        this.pastriesDescription = pastriesDescription;

    }

    //Create getters to return the specific objects
    public int getPastriesImage() {
        return pastriesImage;
    }

    public String getPastriesTitle() {
        return pastriesTitle;
    }

    public String getPastriesPrepTime(){return pastriesPrepTime;}
    public String getPastriesDescription() {
        return pastriesDescription;
    }

}

