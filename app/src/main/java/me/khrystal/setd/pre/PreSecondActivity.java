package me.khrystal.setd.pre;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.kogitune.activity_transition.ActivityTransition;
import com.kogitune.activity_transition.ExitActivityTransition;

import me.khrystal.setd.R;

public class PreSecondActivity extends AppCompatActivity {

    /**
     * 退出动画对象
     */
    private ExitActivityTransition exitTransition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_second);

        // TODO: 16/6/24 从上一个activity接收共享元素的view 至该activity共享元素的view
        ActivityTransition.with(getIntent()).to(findViewById(R.id.second_image)).start(savedInstanceState);
        exitTransition = ActivityTransition.with(getIntent()).to(findViewById(R.id.second_image)).start(savedInstanceState);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        exitTransition.exit(this);
    }
}
