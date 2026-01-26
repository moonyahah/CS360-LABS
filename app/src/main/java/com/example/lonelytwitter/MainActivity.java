package com.example.lonelytwitter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImportantTweet t1=new ImportantTweet("");
        NormalTweet t2=new NormalTweet("this is a normal tweet");
        ArrayList<Tweet> tweetList = new ArrayList<>();
        tweetList.add(t1);
        tweetList.add(t2);
        HappyMood m1 = new HappyMood();
        SadMood m2 = new SadMood();
        ArrayList<Mood> moodList = new ArrayList<>();
        moodList.add(m1);
        moodList.add(m2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}