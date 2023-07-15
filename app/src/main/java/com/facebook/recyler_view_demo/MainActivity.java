package com.facebook.recyler_view_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    List<Item> items = new ArrayList<Item>();
    MyAdapter adapter;
    private int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3,R.drawable.image4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.edittext_name);
        button=findViewById(R.id.button_add);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        NestedScrollView nestedScrollView = findViewById(R.id.nestedscrollview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string=editText.getText().toString();
                if (!string.isEmpty()) {
                    int nextImage = imageResources[items.size() % imageResources.length];
                    items.add(new Item(string, nextImage));
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    nestedScrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            nestedScrollView.fullScroll(View.FOCUS_DOWN);
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Enter the Name" , Toast.LENGTH_SHORT).show();
                }
            }
        });
        adapter = new MyAdapter(getApplicationContext(), items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}