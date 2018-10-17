package com.example.anna.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anna.Interface.ItemClickListener;
import com.example.anna.R;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView food_name;
    public ImageView food_image;
    private ItemClickListener itemClickListener;



    public FoodViewHolder(View itemView){
        super(itemView);
        food_name = (TextView)itemView.findViewById(R.id.foodname);
        food_image = (ImageView)itemView.findViewById(R.id.foodimage);
        itemView.setOnClickListener(this);
    }
    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick (View view)
    {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
