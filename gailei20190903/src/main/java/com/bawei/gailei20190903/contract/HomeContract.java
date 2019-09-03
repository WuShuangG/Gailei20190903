package com.bawei.gailei20190903.contract;


/**
 * author: 盖磊
 * data: 2019/9/3 09:9:25
 * function:
 */
public interface HomeContract {

    interface IView{
        void onDataSuccess(Object obj);
        void onDataError(String msg);
    }



    interface IModel{
        interface IHomeModel extends IView{}
        void getHomeModel(String path,IHomeModel iHomeModel);

    }


    interface IPresenter{
        void setPath(String path);
        void dettachView();
    }


}
