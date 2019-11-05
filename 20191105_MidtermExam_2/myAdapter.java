package com.example.stust.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class myAdapter extends BaseAdapter {

    //宣告自定義的名稱以及電話號碼
    String[] name = new String[]{"王大明", "林聰明", "李小童", "林添財", "陳志明"};
    String[] phone = new String[]{"0911111111", "0922222222", "0933333333", "0944444444", "0955555555"};

    //宣告LayoutInflater物件，可將mylayout載入程式之中，並依據其佈局建立物件
    LayoutInflater mInflater;

    //宣告Context物件，可儲存由Activity傳遞過來的物件
    Context context;

    //建立此類別myAdapter的建構子，並設定需要傳遞Context參數
    //並將Context物件傳遞到此類別中，以做視窗相關處理
    public myAdapter(Context context) {
        this.context=context;
        mInflater = LayoutInflater.from(context);
    }

    //此方程式可回傳列表項目的個數
    @Override
    public int getCount() {
        return name.length;
    }

    /* getItem()與getItemId() 在此直接回傳此位置項目的位置，用來代表該選項的代號和物件，
     * 由於範例只需知道被按下哪個選項，因此只回傳選項位置資訊*/
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            // 將R.layout.mylayout佈局載入並實體化
            convertView = mInflater.inflate(R.layout.mylayout, null);
            holder = new ViewHolder();

            //連接mylayout的元件
            holder.tv_user_name = (TextView)convertView.findViewById(R.id.tv_user_name);
            holder.tv_user_phone = (TextView)convertView.findViewById(R.id.tv_user_phone);

            //儲存一列畫面中的元件
            convertView.setTag(holder);
        } else {
            //取出之前儲存的一列畫面的元件
            holder = (ViewHolder) convertView.getTag();
        }

        //設定此元件中要顯示的資料
        holder.tv_user_name.setText(name[position]);
        holder.tv_user_phone.setText(phone[position]);

        return convertView;
    }

    //myAdapter類別內的自訂類別ViewHolder
    static class ViewHolder {
        TextView tv_user_name;
        TextView tv_user_phone;
    }
}
