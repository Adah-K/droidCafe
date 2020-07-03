package com.example.mydroidcaffev1;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeData;
    private Context myContext;

    RecipeAdapter(ArrayList<Recipe> mRecipeData,Context context)
    {
        this.recipeData = mRecipeData;
        this.myContext = context;
    }


    //Implement on createViewHolder for creating view holder objects
    //View group it will be added after being bound to the adapter position
    //view type of the group and the view holder is returned
    //The view is then bound to the data.
 //CREATING A VIEW HOLDER
    //@params parent viewGroup of the view object will be added after it is bound to that adapter position
    //@params viewType of the new view
    //@params returns the newly created viewHolder

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create a new view holder
        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
    //Get the current view object and populate it using its position
        Recipe currentRecipe = recipeData.get(position);
        holder.bindTo(currentRecipe);
    }

    @Override
    //Returns the size of the data set
    public int getItemCount() {
        return recipeData.size();
    }
    //Step 2: Create the view holder class that represents each and every row in the recyclerView
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;
        public ViewHolder(@NonNull View itemView) {
            //Declare private member variables that the viewHolders will hold
            super(itemView);
            myRecipeImage= itemView.findViewById(R.id.recipe_image);
            myRecipeTitle= itemView.findViewById(R.id.recipe_title);
            myRecipeDescription= itemView.findViewById(R.id.recipe_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if (dessertPosition == 0){
                        Intent donutIntent = new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else {
                        Toast.makeText(myContext,"create an activity for the dessert", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        //Create method to bind the current view to the data(title,image,description)
        public void bindTo(Recipe currentRecipe) {
            //populate the view with the data
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
