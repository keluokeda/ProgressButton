package com.ke.progressbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressButton progressButton = findViewById(R.id.btn);

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressButton.setProgressShow(!progressButton.isShowingProgress());
            }
        });

        findViewById(R.id.btn_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressButton.setProgressShow(!progressButton.isShowingProgress());
            }
        });

    }
}
