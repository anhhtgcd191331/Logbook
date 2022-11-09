package com.example.excercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private static ArrayList<String> imageList;
    private int index;
    private Button addLink;
    private EditText url_link;
    private static final String REGEX_SPLIT_IMG_URL = "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpeg|jpg|gif|png)";
    static {
        imageList = new ArrayList<>();
        imageList.add("https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg");
        imageList.add("https://i.pinimg.com/236x/8f/33/30/8f3330d6163782b88b506d396f5d156f.jpg");
        imageList.add("https://i.pinimg.com/564x/2b/0f/7a/2b0f7a9533237b7e9b49f62ba73b95dc.jpg");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        url_link = findViewById(R.id.get_url);
        addLink = findViewById(R.id.btn_add);
        int sizeOld = imageList.size();
        addLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_link.getText().toString().trim();
                if(url.matches(REGEX_SPLIT_IMG_URL)){
                    imageList.add(url);
                    if(imageList.size() ==sizeOld){
                        Toast.makeText(MainActivity.this, "Add to failed", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Add to successfully", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "Invalid link", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void loadImage() {
        Glide.with(MainActivity.this)
                .load(imageList.get(index))
                .centerCrop()
                .into(imageView);
    }

    public void forwardImage(View view){
        index++;
        if(index>=imageList.size()){
            index = 0;
        }
        loadImage();
    }
    public void backwardImage(View view){
        index--;
        if(index<=-1){
            index = imageList.size()-1;
        }
        loadImage();
    }
}