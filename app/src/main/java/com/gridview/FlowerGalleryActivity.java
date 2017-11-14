package com.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.R;

import java.util.ArrayList;

import com.gridview.adapter.FlowerAdapter;
import com.gridview.dataset.Flower;

public class FlowerGalleryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<Flower> mFlowerDataSet = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);


        //Prepare DataSet
        mFlowerDataSet = prepareDataSet();

        //Initialize Grid View for programming
        GridView gridview = (GridView) findViewById(R.id.gridView);

        //Connect DataSet to Adapter
        FlowerAdapter flowerAdapter = new FlowerAdapter(this, mFlowerDataSet);

        //Now Connect Adapter To GridView
        gridview.setAdapter(flowerAdapter);

        //Add Listener For Grid View Item Click
        gridview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        //Show Name Of The Flower
        Toast.makeText(FlowerGalleryActivity.this, mFlowerDataSet.get(position).getFlowerName(),
                Toast.LENGTH_SHORT).show();
    }


    //Creating Data Set By Adding 6 flower objects
    private ArrayList<Flower> prepareDataSet() {

        ArrayList<Flower> flowerData = new ArrayList<>();

        Flower flower;

        //1st Item
        flower = new Flower();
        flower.setFlowerName("USZ TU Dresden");
        flower.setPhotoPath(R.drawable.volleyball);
        flowerData.add(flower);

        //2nd Item
        flower = new Flower();
        flower.setFlowerName("Find Events");
        flower.setPhotoPath(R.drawable.volleyball);
        flowerData.add(flower);


        //3rd Item
        flower = new Flower();
        flower.setFlowerName("Find Sport Partner");
        flower.setPhotoPath(R.drawable.volleyball);
        flowerData.add(flower);


        //4th Item
        flower = new Flower();
        flower.setFlowerName("Invitations");
        flower.setPhotoPath(R.drawable.volleyball);
        flowerData.add(flower);

        return flowerData;

    }
}
