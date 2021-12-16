package com.example.homework21android1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homework21android1.R;
import com.example.homework21android1.SecondActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imImage;
    TextView tvText;
    Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imImage = findViewById(R.id.im_image);
        tvText = findViewById(R.id.tv_text);
        btnAdd = findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String getData = intent.getStringExtra("Key");
        String image = intent.getStringExtra("image");
        tvText.setText(getData);
        if (image != null){
            imImage.setImageURI(Uri.parse(image));
        }
    }

}


