package com.example.excersice4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ArrayList<String> urlLink;
    private int index;
    private MyDatabaseHelper myDB;
    private Button addLink, reload, openCamera;
    private EditText url_link;
    private static final String REGEX_SPLIT_IMG_URL = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpeg|jpg|gif|png)";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openCamera = findViewById(R.id.camera);
        imageView = findViewById(R.id.imageView);
        myDB = new MyDatabaseHelper(MainActivity.this);
        urlLink = new ArrayList<>();
        storeDataInArrays();

        url_link = findViewById(R.id.get_url);
        addLink = findViewById(R.id.btn_add);
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_link.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                if(url.matches(REGEX_SPLIT_IMG_URL)){
                    myDB.addUrl(url);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Invalid link", Toast.LENGTH_SHORT).show();
                }
            }
        });
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddImage.class);
                startActivity(intent);
            }
        });
    }


    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() >0){
            while (cursor.moveToNext()){
                urlLink.add(cursor.getString(0));
            }
        }
    }

    private void loadImage() {
        Glide.with(MainActivity.this)
                .load(urlLink.get(index))
                .centerCrop()
                .into(imageView);
    }

    public void forwardImage(View view){
        index++;
        if(index>=urlLink.size()){
            index = 0;
        }
        loadImage();
    }
    public void backwardImage(View view){
        index--;
        if(index<=-1){
            index = urlLink.size()-1;
        }
        loadImage();
    }
}