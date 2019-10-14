package com.adsloadmanager.android.ui.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.adsloadmanager.android.R;
import com.adsloadmanager.android.models.ContentItem;
import com.adsloadmanager.android.models.ImageViewItem;
import com.adsloadmanager.android.ui.adapters.ContentRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Wan Clem
 **/

public class MainActivity extends AppCompatActivity {

    private static int[] imageIds = new int[]{
            R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve, R.drawable.thirteen
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView contentRecyclerView = findViewById(R.id.content_recycler_view);
        contentRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        contentRecyclerView.setAdapter(new ContentRecyclerViewAdapter(this, generateOneThousandImages()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Generate 1000 random images
     **/
    private List<ContentItem> generateOneThousandImages() {
        List<ContentItem> contentItems = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            contentItems.add(new ImageViewItem(imageIds[new Random().nextInt(imageIds.length)]));
        }
        return contentItems;
    }

}
