package com.example.team;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practic.R;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activtiy_menu);
    }
    public void main(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void aboutUs(View view) {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
        finish();
    }
    public void feedback(View view) {
        Intent intent = new Intent(getApplicationContext(), FeedbackActivity.class);
        startActivity(intent);
        finish();
    }
    public void rewards(View view) {
        Intent intent = new Intent(getApplicationContext(), RewardActivity.class);
        startActivity(intent);
        finish();
    }
    public void publications(View view) {
        Intent intent = new Intent(getApplicationContext(), PublicationActivity.class);
        startActivity(intent);
        finish();
    }
    public void houses(View view) {
        Intent intent = new Intent(getApplicationContext(), CountryHousesActivity.class);
        startActivity(intent);
        finish();
    }
    public void services(View view) {
        Intent intent = new Intent(getApplicationContext(), ServicesActivity.class);
        startActivity(intent);
        finish();
    }
    public void media(View view) {
        Intent intent = new Intent(getApplicationContext(), MediafileActivity.class);
        startActivity(intent);
        finish();
    }
}