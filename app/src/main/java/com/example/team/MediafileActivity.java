package com.example.team;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practic.R;

public class MediafileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediafile);
    }

    public void reward(View view) {
        Intent intent = new Intent(getApplicationContext(), RewardActivity.class);
        startActivity(intent);
        finish();
    }
    public void publication(View view) {
        Intent intent = new Intent(getApplicationContext(), PublicationActivity.class);
        startActivity(intent);
        finish();
    }
    public void feedback(View view) {
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        startActivity(intent);
        finish();
    }
    public void menu(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
        startActivity(intent);
        finish();
    }
}