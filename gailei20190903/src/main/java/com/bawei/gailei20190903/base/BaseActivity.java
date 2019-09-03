package com.bawei.gailei20190903.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bawei.gailei20190903.R;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:23
 * function:
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initData();
}
