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
    //宣告圖片陣列，將自行放入的圖片資源名稱放進此圖片陣列
    int images[]={R.drawable.baseball, R.drawable.basketball, R.drawable.tennis};

    //宣告字串陣列，配合圖片名稱，自行輸入字串到陣列之中
    String avatar[]={"棒球","籃球","網球"};

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
        return avatar.length;
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
            holder.text = (TextView)convertView.findViewById(R.id.tv_name);
            holder.icon = (ImageView)convertView.findViewById(R.id.imag_icon);
            holder.arrow = (ImageView)convertView.findViewById(R.id.img_arrow);
            convertView.setTag(holder); //儲存一列畫面中的三個元件
        } else {
            //取出之前儲存的一列畫面的三個元件
            holder = (ViewHolder) convertView.getTag();
        }

        //設定此列三個元件中要顯示的資料
        holder.text.setText(avatar[position]);
        holder.icon.setImageResource(images[position]);

        //在箭頭的元件中夾帶此元件在列表中的位置資訊
        holder.arrow.setTag(position);

        //可設定箭頭的ImageView元件是否要監聽按下事件
        holder.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos=(Integer)v.getTag();
                Toast.makeText(context, "前往:" + avatar[pos], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(context, Main2Activity.class);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    //myAdapter類別內的自訂類別ViewHolder
    static class ViewHolder {
        TextView text;
        ImageView icon;
        ImageView arrow;
    }
}
