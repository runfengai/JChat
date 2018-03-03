package com.jarry.jchat.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * 提供给索引fragment
 * Created by Jarry on 2018/3/2.
 */

public class IndexFrag implements Serializable {
    private String title;
    private String description;
    private Drawable img;

    public IndexFrag(String title, String description, Drawable img) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
