package com.example.college.canteen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.college.R;

import java.util.ArrayList;
import java.util.List;

public class Canteen extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen);
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        getSupportActionBar().setTitle("Canteen");

        myFoodList=new ArrayList<>();
        GridLayoutManager gridLayoutManager=new GridLayoutManager(Canteen.this,1 ) ;
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mFoodData=new FoodData( "VADA PAV","Rs.10",R.drawable.image4);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "MANCHURIAN","RS.20",R.drawable.manch);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "COLD COFFEE","RS.25",R.drawable.image3 );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "SANDWICH","Rs.30",R.drawable.sand );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "MILKSHAKE","Rs.15",R.drawable.milkshake);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( " MASALA DOSA","Rs.25",R.drawable.dosa );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "FRANKIE","Rs.20",R.drawable.image8 );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "IDLI","Rs.20",R.drawable.image10 );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "NOODLE","Rs.20",R.drawable.image11 );
        myFoodList.add(mFoodData);
        mFoodData=new FoodData( "SAMOSA","Rs.10",R.drawable.samosas );
        myFoodList.add(mFoodData);


        MyAdapter myAdapter=new MyAdapter(Canteen.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);

    }
}