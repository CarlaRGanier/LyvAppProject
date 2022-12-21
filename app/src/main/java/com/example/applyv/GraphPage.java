package com.example.applyv;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applyv.ui.api.ApiHelper;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraphPage  extends AppCompatActivity {

    ArrayList barArrayList;
    public static ArrayList<Integer> allergensCounterList;

    public void resetArrayData(){
        allergensCounterList.add(0, 0);
        allergensCounterList.add(1,0);
        allergensCounterList.add(2, 0);
        allergensCounterList.add(3, 0);
        allergensCounterList.add(4,0);
        allergensCounterList.add(5,0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graph_activity);

        //Creating the chart
        BarChart barChart = findViewById(R.id.barchart);
        resetArrayData();
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Allergies");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        //BarDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        //barChart.setDescription().setEnable(True);


        Button cakeButton = (Button) findViewById(R.id.buttonCake);
        cakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //API
                ApiHelper apiHelper = new ApiHelper();
                apiHelper.getFoodInfo();
                allergensCounterList.add(0, 1);
                allergensCounterList.add(1, 1);
                allergensCounterList.add(4, 1);
                getData();
            }
        });

        Button nemsButton = (Button) findViewById(R.id.buttonNems);
        nemsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //API
                ApiHelper apiHelper = new ApiHelper();
                apiHelper.getFoodInfo();
                allergensCounterList.add(0, 2);
                allergensCounterList.add(2, 1);
                allergensCounterList.add(3, 1);
                allergensCounterList.add(5, 1);
                getData();
            }
        });

        Button pizzaButton = (Button) findViewById(R.id.buttonPizza);
        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //API
                ApiHelper apiHelper = new ApiHelper();
                apiHelper.getFoodInfo();
                allergensCounterList.add(0, 3);
                allergensCounterList.add(1, 2);
                allergensCounterList.add(4, 2);
                getData();
            }
        });
    }

    private void getData(){

        barArrayList = new ArrayList<>();
        //Egg
        barArrayList.add(new BarEntry(2f, allergensCounterList.get(0)));
        //Gluten
        barArrayList.add(new BarEntry(3f, allergensCounterList.get(1)));
        //Nuts
        barArrayList.add(new BarEntry(4f, allergensCounterList.get(2)));
        //Grain
        barArrayList.add(new BarEntry(5f, allergensCounterList.get(3)));
        //Milk
        barArrayList.add(new BarEntry(6f, allergensCounterList.get(4)));
        //Seafood
        barArrayList.add(new BarEntry(7f, allergensCounterList.get(5)));
    }
}
