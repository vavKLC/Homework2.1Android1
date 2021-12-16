package com.example.homework21android1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    ImageView imImageSecond;
    EditText etText;
    Button btnSecondAdd;
    String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
        listener();

    }


    private void initView() {
        imImageSecond= findViewById(R.id.im_SECONDimage);
        etText = findViewById(R.id.et_SECONDtittle);
        btnSecondAdd = findViewById(R.id.btn_SECONDadd);
    }

    private void listener() {
        imImageSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA_SECURE);
                startActivity(intent);
                resultLauncher.launch("image/*");

            }
        });

        btnSecondAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = etText.getText().toString();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra("Key", data);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
    }


    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri Uri) {
                    image = Uri.toString();
                    imImageSecond.setImageURI(Uri);
                }
            });

}
