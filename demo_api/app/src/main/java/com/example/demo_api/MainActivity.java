package com.example.demo_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private Button button;
    TextView textView;
    JsonArray detaiList = new JsonArray();
    String userId ="wm123";
    JsonObject mainOject = new JsonObject();
    JsonObject name1 = new JsonObject();
    JsonObject name2 = new JsonObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.response);
        Button button = findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPost();
            }
        });
    }
    private void UploadPost(){
        mainOject.addProperty("usedId", "1234");
        name1.addProperty("name", "Android Conference");
//        name2.addProperty("name", "Client Meeting");
        detaiList.add(name1);
        mainOject.add("detailList", detaiList);



//        detaiList.add(name2);

        textView.setText("");
//        ApiInterface apiInterface = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        ApiInterface  apiInterface = ApiClient.getClient().create(ApiInterface.class);
        System.out.println("aa");
        System.out.println("b");
        System.out.println("3");
        System.out.println("5");
        Call<Cloud> call = apiInterface.getUserInformation("{\n" +
                "  \"userId\": \"123\",\n" +
                "  \"detailList\": [\n" +
                "    {\n" +
                "      \"name\": \"tienanh\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
        call.enqueue(new Callback<Cloud>() {
            @Override
            public void onResponse(Call<Cloud> call, Response<Cloud> response) {
                if(response.isSuccessful()){
                    System.out.println("----ta----");
                    System.out.println(response);
                    System.out.println("----ta----");
                    textView.setText("Localhost Connect onResponse:" + response.code());
                    Log.e(TAG, "Localhost Connect onResponse:" + response.code());
                    Log.e(TAG, "onResponse:name: " + response.body().getUploadResponseCon());
                    Log.e(TAG, "onResponse:name: " + response.body().getUserId());
                    Log.e(TAG, "onResponse:name: " + response.body().getNumber());
                    Log.e(TAG, "onResponse:name: " + response.body().getNames());
                    Log.e(TAG, "onResponse:name: " + response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<Cloud> call, Throwable t) {
                textView.setText("Error found is " + t.getMessage());
                Log.e(TAG, "onFailure" + t.getMessage());
            }
        });

    }
}