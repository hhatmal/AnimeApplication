package com.example.gmodapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DisplayShowActivity extends AppCompatActivity {
    private ArrayList<Integer> genreIds;
    private List<Results> responseBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_show);

        Bundle b = this.getIntent().getExtras();
        genreIds = b.getIntegerArrayList("arr");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.jikan.moe/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        String genreIdsString = "";
        for(int i = 0; i < genreIds.size(); i++) {
            genreIdsString += genreIds.get(i);
            if (i != genreIds.size() - 1)
                genreIdsString += ",";
        }

        Call<SearchResponse> call = jsonPlaceHolderApi.getResponse(genreIdsString);

        try {
            call.enqueue(new Callback<SearchResponse>() {
                @Override
                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                    if (!response.isSuccessful())
                        System.out.println("not success");
                    else {
                        System.out.println("Success");
                        responseBody = response.body().getResults();
                        initRecyclerView();
                       // Intent intent = new Intent(DisplayShowActivity.this, InformationActivity.class);

                        //Bundle b = new Bundle();
                        //intent.putExtra("showInfo", (Serializable) responseBody.get(0));
                        //startActivity(intent);
                    }

                }

                @Override
                public void onFailure(Call<SearchResponse> call, Throwable t) {
                    System.out.println("fail");
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, responseBody);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
