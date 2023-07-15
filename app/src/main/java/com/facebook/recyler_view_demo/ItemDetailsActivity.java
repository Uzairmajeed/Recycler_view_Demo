package com.facebook.recyler_view_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        // Get the extras from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image", 0);

        // Initialize views
        imageView = findViewById(R.id.imageView11);
        nameTextView = findViewById(R.id.textView11);

        // Display the name and image
        nameTextView.setText(name);
        imageView.setImageResource(image);
    }
}