package com.example.temple_demo_assi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView textView, responseBody;
    String userId ="wm123";
    private static String json = "{\n" +
            "  \"userId\": \"wm123\",\n" +
            "  \"detailList\": [\n" +
            "    {\n" +
            "      \"name\": \"Client Meeting\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.response);
        responseBody = findViewById(R.id.responseBody);
        Button button = findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPost();
            }
        });
    }
    private void UploadPost(){
        APIInterface  apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);
        Call<Cloud> call = apiInterface.getUserInformation(json);
        call.enqueue(new Callback<Cloud>() {
            @Override
            public void onResponse(Call<Cloud> call, Response<Cloud> response) {
                if(response.isSuccessful()){
                    textView.setText("Localhost Connect onResponse:" + response.code());
                    responseBody.setText("{\n" +
                            "    \"uploadResponseCode\": \""+response.body().getUploadResponseCode()+"\",\n" +
                            "    \"userId\": \""+response.body().getUserId()+"\",\n" +
                            "    \"number\": "+response.body().getNumber()+",\n" +
                            "    \"names\": \""+response.body().names+"\",\n" +
                            "    \"message\": \""+response.body().getMessage()+"\"\n" +
                            "}");
                }
            }

            @Override
            public void onFailure(Call<Cloud> call, Throwable t) {
                textView.setText("Error found is " + t.getMessage());
            }
        });
    }
}