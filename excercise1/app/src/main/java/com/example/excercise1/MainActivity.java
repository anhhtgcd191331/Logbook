package com.example.excercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private String[] imageList;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageList = getResources().getStringArray(R.array.images);

    }

    private void loadImage() {
        Glide.with(MainActivity.this)
                .load(imageList[index])
                .centerCrop()
                .into(imageView);
    }

    public void forwardImage(View view){
        index++;
        if(index>=imageList.length){
            index = 0;
        }
        loadImage();
    }
    public void backwardImage(View view){
        index--;
        if(index<=-1){
            index = imageList.length-1;
        }
        loadImage();
    }
}