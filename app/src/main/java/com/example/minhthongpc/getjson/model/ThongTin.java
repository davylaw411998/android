package com.example.minhthongpc.getjson.model;

import java.util.ArrayList;

public class ThongTin extends ArrayList<ThongTin> {
    private String image;
    private String desc;

    public ThongTin(String image, String desc) {
        this.image = image;
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
