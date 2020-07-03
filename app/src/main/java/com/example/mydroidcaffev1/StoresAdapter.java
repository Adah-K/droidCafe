package com.example.mydroidcaffev1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {

    private ArrayList<Stores> storesData;
    private Context store_context;
    StoresAdapter(ArrayList<Stores> mStoresData, Context context){
        this.storesData = mStoresData;
        this.store_context = context;
    }

    @NonNull
    @Override
    public StoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(store_context).inflate(R.layout.stores_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoresAdapter.ViewHolder holder, int position) {
        Stores currentStores = storesData.get(position);
        holder.bindTo(currentStores);
    }

    @Override
    public int getItemCount() {
        return storesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView myStoreImage;
        private TextView myStoreTitle;
        private TextView myStoreTime;
        private TextView myStoreDescription;
        private ImageButton likeButton;
        private ImageButton shareButton;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myStoreImage = itemView.findViewById(R.id.stores_image);
            myStoreTitle = itemView.findViewById(R.id.stores_name);
            myStoreTime = itemView.findViewById(R.id.store_open_time);
            myStoreDescription = itemView.findViewById(R.id.store_description);

            likeButton = itemView.findViewById(R.id.like_button);
            likeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    likeButton.setImageResource(R.drawable.ic_baseline_thumb_up_alt_24);
                }
            });


/*
            shareButton = itemView.findViewById(R.id.share_button);
            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT,"Check out this Bakery");
                    Intent chooser = Intent.createChooser(shareIntent,"Share Via");

                }
            });
            */


        }

        public void bindTo(Stores currentStores) {
            Glide.with(store_context).load(currentStores.getStoresImage()).into(myStoreImage);
            myStoreTitle.setText(currentStores.getStoresTitle());
            myStoreTime.setText(currentStores.getStoresTime());
            myStoreDescription.setText(currentStores.getStoresDescription());



        }
    }
}
