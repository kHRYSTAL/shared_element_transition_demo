package me.khrystal.setd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.khrystal.setd.after.AfterFirstActivity;
import me.khrystal.setd.pre.PreFirstActivity;
import me.khrystal.setd.pre.PreSecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_after_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AfterFirstActivity.class));
            }
        });

        findViewById(R.id.btn_pre_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PreFirstActivity.class));
            }
        });
    }
}
