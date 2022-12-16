package com.example.team;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practic.R;

public class PublicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publication);
    }
    public void menu(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
        startActivity(intent);
        finish();
    }
}