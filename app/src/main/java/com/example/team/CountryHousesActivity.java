package com.example.team;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practic.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class CountryHousesActivity extends AppCompatActivity {
    private EditText name, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_houses);
    }
    public void menu(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
        startActivity(intent);
        finish();
    }
    public void project(View view) {
        Intent intent = new Intent(getApplicationContext(), ProjectActivity.class);
        startActivity(intent);
        finish();
    }
    public void send(View view) {
        name = (EditText) findViewById(R.id.personName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put("name", name.getText().toString());
        user.put("phoneNumber", phoneNumber.getText().toString());
        database.collection("users")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    name.setText("");
                    phoneNumber.setText("");
                    showToast("Данные отправлены");
                }).addOnFailureListener(exception -> showToast(exception.getMessage()));
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}