package com.example.esercitazione3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int dimArray;
    private float ranNumber;
    private float total = 0;

    Random rd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChartView pieChartView = this.findViewById(R.id.piechart);
        dimArray = 2 + rd.nextInt() % 7;

        Float[] percent = new Float[dimArray *2];
        Integer[] colors = new Integer[dimArray *2];
        for(int i= 0; i<dimArray; i++){
            percent[i] = rd.nextFloat() * 100;
            total += percent[i];
        }
        for(int i= 0; i<dimArray; i++){
            percent[i] = percent[i] / total / 2 * 100;
        }
        for(int i= dimArray; i<dimArray * 2; i++){
            percent[i] = percent[dimArray-(i%dimArray)-1];
        }
        for(int i=0; i<dimArray * 2 ; i++){
            colors[i] = rd.nextInt();
        }

        pieChartView.setPercent(Arrays.asList(percent));
        pieChartView.setSegmentColor(Arrays.asList(colors));

        pieChartView.setRadius(300);
        pieChartView.setStrokeColor(Color.BLACK);
        pieChartView.setStrokeWidth(4);
    }
}