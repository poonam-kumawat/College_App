package com.example.college.canteen;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.college.R;

import java.util.List;
public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Context mContext;
    private List<FoodData> myFoodList;

    public MyAdapter( Context mContext,List<FoodData> myFoodList) {
        this.mContext=mContext;
        this.myFoodList = myFoodList;
    }


    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,int i)   {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_item,viewGroup,false);
        return  new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.imageView.setImageResource(myFoodList.get(i).getItemImage());
        foodViewHolder.mTitle.setText(myFoodList.get(i).getItemName());
        foodViewHolder.mPrice.setText(myFoodList.get(i).getItemPrice());

    }

    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
}

class  FoodViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView mTitle,mPrice;
    CardView mCardView;
    public FoodViewHolder( View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.ivImage);
        mTitle=itemView.findViewById(R.id.tvTitle);

        mPrice=itemView.findViewById(R.id.tvPrice);
        mCardView=itemView.findViewById(R.id.myCardView);
    }
}

