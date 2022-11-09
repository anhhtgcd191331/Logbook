package com.example.excersice4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class AddImage extends AppCompatActivity {

    private Button capture, addPicture, seeAll;
    private ImageView displayImage;
    private EditText nameImage, placeImage;
    MyDatabaseHelper myDB;
    Bitmap imageDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_image);
        capture = findViewById(R.id.capture_image);
        displayImage = findViewById(R.id.display);
        nameImage = findViewById(R.id.name_picture);
        placeImage = findViewById(R.id.place);
        addPicture = findViewById(R.id.add_image);
        seeAll = findViewById(R.id.see_all);
        myDB = new MyDatabaseHelper(this);
        if(ContextCompat.checkSelfPermission(AddImage.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AddImage.this, new String[]{
                    Manifest.permission.CAMERA
            },100);
        }
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }
        });
        addPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameImage.getText().toString().trim();
                String place = placeImage.getText().toString().trim();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                imageDB.compress(Bitmap.CompressFormat.JPEG,0,byteArray);
                byte[] img = byteArray.toByteArray();
                myDB.addFile(name,place,img);
            }
        });
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddImage.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            imageDB = (Bitmap) data.getExtras().get("data");
            displayImage.setImageBitmap(imageDB);
        }
    }
}