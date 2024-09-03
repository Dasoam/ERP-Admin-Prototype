package com.dadash.erpadmin;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etTitle, etMessage, etPostedBy;
    private Button btnPost;

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firestore
        db = FirebaseFirestore.getInstance();

        etTitle = findViewById(R.id.etTitle);
        etMessage = findViewById(R.id.etMessage);
        etPostedBy = findViewById(R.id.etPostedBy);
        btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(v -> postMessage());
    }

    private void postMessage() {
        String title = etTitle.getText().toString();
        String message = etMessage.getText().toString();
        String postedBy = etPostedBy.getText().toString();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(message) || TextUtils.isEmpty(postedBy)) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new post
        Map<String, Object> post = new HashMap<>();
        post.put("title", title);
        post.put("message", message);
        post.put("postedBy", postedBy);
        post.put("timestamp", System.currentTimeMillis());

        // Save the post to Firestore
        db.collection("eventsMessages")
                .add(post)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(MainActivity.this, "Message posted successfully", Toast.LENGTH_SHORT).show();
                    etTitle.setText("");
                    etMessage.setText("");
                    etPostedBy.setText("");
                })
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, "Error posting message", Toast.LENGTH_SHORT).show());
    }
}
