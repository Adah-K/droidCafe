package com.example.mydroidcaffev1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PastriesAdapter extends RecyclerView.Adapter<PastriesAdapter.ViewHolder> {

    private ArrayList<Pastries> pastriesData;
    private Context pastries_context;
    PastriesAdapter(ArrayList<Pastries> mPastriesData,Context context)
    {
        this.pastriesData= mPastriesData;
        this.pastries_context =context;
    }
    @NonNull
    @Override
    public PastriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(pastries_context).inflate(R.layout.pastries_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastriesAdapter.ViewHolder holder, int position) {
        Pastries currentPastries = pastriesData.get(position);
        holder.bindTo(currentPastries);

    }

    @Override
    public int getItemCount() {
        return pastriesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myPastriesImage;
        private TextView myPastriesTitle;
        private TextView myPastriesPrepTime;
        private TextView myPastriesDescription;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            myPastriesImage= itemView.findViewById(R.id.pastries_image);
            myPastriesTitle= itemView.findViewById(R.id.pastries_title);
            myPastriesPrepTime= itemView.findViewById(R.id.pastries_prep_time);
            myPastriesDescription= itemView.findViewById(R.id.pastries_description);

        }

        public void bindTo(Pastries currentPastries) {
            Glide.with(pastries_context).load(currentPastries.getPastriesImage()).into(myPastriesImage);
            myPastriesTitle.setText(currentPastries.getPastriesTitle());
            myPastriesPrepTime.setText(currentPastries.getPastriesPrepTime());
            myPastriesDescription.setText(currentPastries.getPastriesDescription());


        }
    }
}
