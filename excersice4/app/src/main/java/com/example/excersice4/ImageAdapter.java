package com.example.excersice4;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyViewHolder>{
    private Context context;
    private Activity activity;
    private List<Image> imageList;
//    byte[] image_file;
    ImageAdapter(Activity activity, Context context,List<Image> imageList ){
        this.activity = activity;
        this.context = context;
        this.imageList = imageList;
    }
    @NonNull
    @Override
    public ImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Image image = imageList.get(position);
        holder.image_id_txt.setText(String.valueOf(image.getId()));
        holder.name_image_txt.setText(String.valueOf(image.getName()));
        holder.place_image_txt.setText(String.valueOf(image.getPlace()));
        holder.image_file.setImageBitmap(BitmapFactory.decodeByteArray(image.getImage(),0,image.getImage().length));
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView image_id_txt, name_image_txt, place_image_txt;
        ImageView image_file;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image_id_txt = itemView.findViewById(R.id.id_file);
            name_image_txt = itemView.findViewById(R.id.name_image_txt);
            place_image_txt = itemView.findViewById(R.id.place_image_txt);
            image_file = itemView.findViewById(R.id.display_image_txt);


        }

    }
}
