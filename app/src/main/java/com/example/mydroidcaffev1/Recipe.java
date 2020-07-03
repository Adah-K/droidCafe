package com.example.mydroidcaffev1;

public class Recipe {
    //Declare private member variables to be used to refer to the data stored in the arrays.
    private final int recipeImage;
    private String recipeDescription;
    private String  recipeTitle;
    //Create a recipe for the recipe data model and pass the parameters: recipeImage, recipeTitle, recipeDescription

      Recipe(int recipeImage,String recipeTitle,String recipeDescription){
            this.recipeImage=recipeImage;
            this.recipeTitle=recipeTitle;
            this.recipeDescription=recipeDescription;
    }
    //Create getters to return the specific objects
    public int getRecipeImage()
    {
        return recipeImage;
    }
    public String getRecipeTitle()
    {
        return recipeTitle;
    }
    public String getRecipeDescription()
    {
        return recipeDescription;
    }


}
