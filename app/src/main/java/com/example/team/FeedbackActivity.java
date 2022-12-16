package com.example.team;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practic.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class FeedbackActivity extends AppCompatActivity {

    private EditText name, phoneNumber, feedback;
    private TextView Com, Coop, Nick;
    private ImageView Star;
    public Integer Index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        Com = findViewById(R.id.com);
        Coop = findViewById(R.id.coop);
        Nick = findViewById(R.id.Nick);
        Index = 1;

        feedback();
    }
    public void menu(View view) {
        Intent intent = new Intent(getApplicationContext(), ActivityMenu.class);
        startActivity(intent);
        finish();
    }
    public void send(View view) {
        name = (EditText) findViewById(R.id.personName);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        feedback = (EditText) findViewById(R.id.yourFeedback);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        HashMap<String, Object> user = new HashMap<>();
        user.put("name", name.getText().toString());
        user.put("phoneNumber", phoneNumber.getText().toString());
        user.put("feedback", feedback.getText().toString());

        database.collection("users")
                .add(user)
                .addOnSuccessListener(documentReference -> {
                    name.setText("");
                    phoneNumber.setText("");
                    feedback.setText("");
                    showToast("Данные отправлены");
                }).addOnFailureListener(exception -> showToast(exception.getMessage()));
    }
    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void left(View view){
        if (Index > 1) Index --;
        feedback();
    }
    public void right(View view){
       if (Index < 3) Index ++;
        feedback();
    }

    public void feedback(){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection("1")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        Integer count = 0;
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                count++;
                                    Com.setText(document.getString("Comment"));
                                    Coop.setText(document.getString("cooperation"));
                                    Nick.setText(document.getString("Name"));
                                    if(Index == count) break;
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}