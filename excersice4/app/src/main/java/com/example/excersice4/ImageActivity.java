package com.example.excersice4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MyDatabaseHelper myDB;
    List<Image> imageList = new ArrayList<>();
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        recyclerView = findViewById(R.id.recyclerView);
        myDB = new MyDatabaseHelper(ImageActivity.this);
        displayImageFile();

        imageAdapter = new ImageAdapter(ImageActivity.this,this,imageList);
        recyclerView.setAdapter(imageAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ImageActivity.this));
    }
    public void displayImageFile(){
        Cursor cursor = myDB.readAllDataFile();
        if(cursor.getCount() == 0){
            Toast.makeText(ImageActivity.this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                imageList.add(new Image(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getBlob(3)));
            }
        }
    }
}