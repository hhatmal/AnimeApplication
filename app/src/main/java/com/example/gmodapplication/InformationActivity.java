package com.example.gmodapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class InformationActivity extends AppCompatActivity {
    private Results showInfo;
    private ImageView imageView;
    private TextView titleView;
    private TextView synopsisView;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Bundle bundle = getIntent().getExtras();
        Intent i = getIntent();
        showInfo = (Results) i.getSerializableExtra("showInfo");

        // set background
        imageView = (ImageView)findViewById(R.id.imageView);
        loadImageFromUrl(showInfo.getImage_url());

        // set title
        int id = getResources().getIdentifier("title", "id", getPackageName());
        titleView = (TextView) findViewById(id);
        titleView.setText(showInfo.getTitle());

        // set synopsis
        id = getResources().getIdentifier("synopsis", "id", getPackageName());
        synopsisView = (TextView) findViewById(id);
        synopsisView.setText(showInfo.getSynopsis());
    }

    private void loadImageFromUrl(String url){
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView, new com.squareup.picasso.Callback(){
                    @Override
                   public void onSuccess(){

                   }

                    @Override
                    public void onError() {

                    }
                });
    }
}
