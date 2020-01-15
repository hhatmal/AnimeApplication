package com.example.gmodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectGenreActivity extends AppCompatActivity {
    private Button button;
    private HashMap<String, Integer> genreMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                ArrayList<Integer> genreIds = new ArrayList<Integer>();

                for(int i = 1; i < 13; i++){
                    // button names convention: button1, button2, button3
                    // will use an existing map to map their contents with a value to be used with the api
                    int id = getResources().getIdentifier("button"+i, "id", getPackageName());
                    CheckBox checkBox = (CheckBox) findViewById(id);

                    if(checkBox.isChecked()) {
                        if(genreMap == null)
                            createGenreMap();

                        int genreId = genreMap.get(checkBox.getText().toString());
                        genreIds.add(genreId);
                    }
                }

                Intent intent = new Intent(SelectGenreActivity.this, DisplayShowActivity.class);

                if(genreIds != null) {
                    Bundle b = new Bundle();
                    b.putIntegerArrayList("arr", genreIds);
                    intent.putExtras(b);
                }

                startActivity(intent);
            }
        });
    }

    // value represents genre parameter for api
    private void createGenreMap(){
        genreMap = new HashMap<>();

        genreMap.put("Action", 1);
        genreMap.put("Adventure", 2);
        genreMap.put("Cars", 3);
        genreMap.put("Comedy", 4);
        genreMap.put("Dementia", 5);
        genreMap.put("Demons", 6);
        genreMap.put("Mystery", 7);
        genreMap.put("Drama", 8);
        genreMap.put("Fantasy", 10);
        genreMap.put("Game", 11);
        genreMap.put("Historical", 13);
        genreMap.put("Horror", 14);
    }
}
