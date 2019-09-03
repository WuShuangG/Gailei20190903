package com.bawei.gailei20190903.presenter;


import com.bawei.gailei20190903.contract.HomeContract;
import com.bawei.gailei20190903.utils.NetUtils;

/**
 * author: 盖磊
 * data: 2019/9/3 09:9:34
 * function:
 */
public class HomePresenter implements HomeContract.IPresenter {


    protected HomeContract.IView iHomeModel;

    public HomePresenter(HomeContract.IModel.IHomeModel iHomeModel) {
        this.iHomeModel = iHomeModel;
    }

    @Override
    public void setPath(String path) {
        NetUtils.getInstance().getJson(path, new NetUtils.CallBackT() {
            @Override
            public void onSuccess(Object obj) {
                iHomeModel.onDataSuccess(obj);
            }

            @Override
            public void onError(String msg) {
                iHomeModel.onDataError(msg);
            }
        });
    }

    @Override
    public void dettachView() {
        if (iHomeModel != null){
            iHomeModel = null;
        }
    }
}
