package com.bawei.gailei20190903.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.gailei20190903.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * author: 盖磊
 * data: 2019/9/3 10:10:17
 * function:
 */
public class ListAdapter extends BaseAdapter {

    private List<ShopBean.DataInfo> list;
    private Context context;

    public ListAdapter(List<ShopBean.DataInfo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = View.inflate(context, R.layout.item_list,null);
            holder = new ViewHolder();
            holder.iv = convertView.findViewById(R.id.iv);
            holder.tv1 = convertView.findViewById(R.id.tv1);
            holder.tv2 = convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context).load(list.get(position).getGoods_thumb()).into(holder.iv);
        holder.tv1.setText(list.get(position).getGoods_name());
        holder.tv2.setText(list.get(position).getCurrency_price());



        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView tv1,tv2;
    }
}
