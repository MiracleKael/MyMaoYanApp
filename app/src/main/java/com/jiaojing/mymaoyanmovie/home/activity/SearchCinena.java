package com.jiaojing.mymaoyanmovie.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jiaojing.mymaoyanmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchCinena extends Activity {

    @Bind(R.id.et_search)
    EditText etSearch;
    @Bind(R.id.search_cancle)
    TextView searchCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_cinena);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {
        searchCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
