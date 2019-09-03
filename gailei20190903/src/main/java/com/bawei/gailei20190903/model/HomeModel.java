package com.bawei.gailei20190903.model;

import com.bawei.gailei20190903.app.App;
import com.bawei.gailei20190903.contract.HomeContract;
import com.bawei.gailei20190903.utils.NetUtils;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:34
 * function:
 */
public class HomeModel implements HomeContract.IModel {



    @Override
    public void getHomeModel(String path, final IHomeModel iHomeModel) {
        boolean netWork = NetUtils.isNetWork(App.ofContext);
        if (netWork){
            new NetUtils().getJson(path, new NetUtils.CallBackT() {
                @Override
                public void onSuccess(Object obj) {
                    iHomeModel.onDataSuccess(obj);
                }

                @Override
                public void onError(String msg) {
                    iHomeModel.onDataError(msg);
                }
            });
        }else {

        }
    }
}
