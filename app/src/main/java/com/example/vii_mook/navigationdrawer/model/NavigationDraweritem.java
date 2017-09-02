package com.example.vii_mook.navigationdrawer.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.vii_mook.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vii-mook on 9/2/2017 AD.
 */

public class NavigationDraweritem {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDraweritem> getData() {
        List<NavigationDraweritem> dataList = new ArrayList<>();

        int[] imageIds = getImages();
        String[] titles = getTitles();

        for (int i = 0;i < titles.length; i++) {
            NavigationDraweritem navigationDraweritem = new NavigationDraweritem();
            navigationDraweritem.setTitle(titles[i]);
            navigationDraweritem.setImageId(imageIds[i]);
            dataList.add(navigationDraweritem);
        }
        return dataList;
    }
    private static int[] getImages() {
        return new int[]{
                R.drawable.ic_birds, R.drawable.ic_animal,
                R.drawable.ic_forest, R.drawable.ic_ocean,
                R.drawable.ic_planet, R.drawable.ic_landscape};
    }

    public static String[] getTitles() {
        return new String[]{
                "Birds", "Animals", "Forest", "Ocean", "Planet", "Lanscape"
        };
    }
    public int getImageId() {

        return imageId;
    }

}
