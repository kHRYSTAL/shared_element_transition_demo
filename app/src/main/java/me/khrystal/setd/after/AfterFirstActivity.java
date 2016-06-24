package me.khrystal.setd.after;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.khrystal.setd.R;

public class AfterFirstActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> datalist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_first);

        initDataList();

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(AfterFirstActivity.this));
        SimpleAdapter adapter = new SimpleAdapter();
        mRecyclerView.setAdapter(adapter);

    }

    private void initDataList() {
        datalist = new ArrayList<>();
        for (int i=0; i < 30; i++) {
            datalist.add("第" + i + "个item");
        }
    }

    class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

        @Override
        public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SimpleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
        }

        @Override
        public void onBindViewHolder(SimpleViewHolder holder, int position) {
            holder.bind(datalist.get(position));
        }

        @Override
        public int getItemCount() {
            return datalist.size();
        }
    }


    class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView mTextView;
        public String text;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_text);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);
            itemView.setOnClickListener(this);
        }

        public void bind(String str) {
            if (TextUtils.isEmpty(str))
                text = str;
            mTextView.setText(str);

        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(AfterFirstActivity.this, AfterSecondActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(AfterFirstActivity.this,mImageView,"shareName").toBundle());
        }
    }
}
