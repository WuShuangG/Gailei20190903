package com.bawei.gailei20190903.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bawei.gailei20190903.R;
import com.bawei.gailei20190903.app.Api;
import com.bawei.gailei20190903.contract.HomeContract;
import com.bawei.gailei20190903.presenter.HomePresenter;
import com.bawei.gailei20190903.utils.ListAdapter;
import com.bawei.gailei20190903.utils.NetUtils;
import com.bawei.gailei20190903.utils.ShopBean;
import com.bwei.xlistview.XlistView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.IModel.IHomeModel {

    private int page = 1;
    private HomePresenter presenter;
    private XlistView xl;
    private Handler handler = new Handler();
    private ListAdapter adapter;
    private int frist = 0;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("sp", Context.MODE_PRIVATE);
        //判断网络
        boolean netWork = NetUtils.isNetWork(this);
        if (netWork){
            //获取资源ID
            initView();

            initPresenter(page);
            //设置适配器
            setListener();
        }else {
            String json = sp.getString("json", "");
            getJson(json);
        }


    }

    private void initView() {
        xl = findViewById(R.id.xl);
    }

    private void setListener() {

        xl.setPullRefreshEnable(true);
        xl.setPullLoadEnable(true);

        xl.setXListViewListener(new XlistView.IXListViewListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        initPresenter(page);
                        adapter.notifyDataSetChanged();
                        xl.stopRefresh();
                    }
                },1500);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page ++;
                        initPresenter(page);
                        adapter.notifyDataSetChanged();
                        xl.stopRefresh();
                    }
                },1500);
            }
        });
    }

    private void initPresenter(int page) {
        String path = Api.PATH + page + Api.COUNT;
        presenter = new HomePresenter(this);
        presenter.setPath(path);
    }

    @Override
    public void onDataSuccess(Object obj) {
        String json = obj.toString();
        getJson(json);
    }

    private void getJson(String json) {
        Gson gson = new Gson();
        ShopBean shopBean = gson.fromJson(json, ShopBean.class);
        List<ShopBean.DataInfo> data = shopBean.getData();
        if (frist == 0){
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("json",json);
            editor.commit();
            frist ++;
        }

        adapter = new ListAdapter(data, MainActivity.this);
        xl.setAdapter(adapter);
    }

    @Override
    public void onDataError(String msg) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }


    //销毁资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dettachView();
    }
}
