package com.example.imageshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.imageshop.adapter.PoolImageAdapter;
import com.example.imageshop.model.BaseResponse;
import com.example.imageshop.model.ImageModel;
import com.example.imageshop.model.ImageResponse;
import com.example.imageshop.net.NetRequest;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<ImageModel> images = new ArrayList<>();
    private PoolImageAdapter poolImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        poolImageAdapter = new PoolImageAdapter(this);
        recyclerView.setAdapter(poolImageAdapter);

        NetRequest.getFormRequest("http://api.beyourself1994.top:8112/api/images/list", null, new NetRequest.DataCallBack() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void requestSuccess(String result) throws Exception {
                System.out.println(result);
                ImageResponse response = new Gson().fromJson(result, ImageResponse.class);
                images = response.getData();
                poolImageAdapter.setImages(images);
                poolImageAdapter.notifyDataSetChanged();
            }

            @Override
            public void requestFailure(Request request, IOException e) {
                System.out.println("-------------------------error<<<<<<<<>>>>>>>>>");
                e.printStackTrace();
            }
        });
    }

    @JavascriptInterface
    public void jsCallAndroid() {
        System.out.println("js called java func");
    }
}