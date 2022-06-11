package com.example.imageshop.model;

import java.util.List;

public class ImageResponse {
    private int code;
    private List<ImageModel> data;

    public List<ImageModel> getData() {
        return data;
    }

    public void setData(List<ImageModel> data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
