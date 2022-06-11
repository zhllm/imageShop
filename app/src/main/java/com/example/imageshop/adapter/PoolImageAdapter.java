package com.example.imageshop.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.imageshop.R;
import com.example.imageshop.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class PoolImageAdapter extends RecyclerView.Adapter<PoolImageAdapter.PoolImageAdapterViewHolder> {
    private List<ImageModel> images = new ArrayList<>();
    private Context context;

    public PoolImageAdapter(Context context) {
        this.context = context;
    }

    public void setImages(List<ImageModel> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public PoolImageAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PoolImageAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.pool_iamge_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PoolImageAdapterViewHolder holder, int position) {
        ImageModel image = images.get(position);
        String desc = image.getDesc() != null ? image.getDesc() : "暂无描述";
        holder.textView.setText(desc);
        Glide.with(context)
                .load(image.getAddr())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        System.out.println("'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx'" + String.valueOf(images.size()));
        return images.size();
    }

    class PoolImageAdapterViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public PoolImageAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
