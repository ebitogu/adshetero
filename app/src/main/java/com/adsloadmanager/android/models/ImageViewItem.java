package com.adsloadmanager.android.models;

public class ImageViewItem extends ContentItem {

    private int resId;

    public ImageViewItem(int resId) {
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }

}
