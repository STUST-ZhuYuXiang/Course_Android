package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_title;
    private TextView tv_show;
    private ListView lv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_title = (TextView)findViewById(R.id.tv_title);
        tv_show = (TextView)findViewById(R.id.tv_show);
        lv_data = (ListView)findViewById(R.id.lv_data);

        //宣告 myAdapter 類別的物件
        final myAdapter adapter = new myAdapter(this);

        //將 ListView 橋接 宣告的物件資料
        lv_data.setAdapter(adapter);
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv_show.setText("打電話給:"+adapter.name[position]+"\n電話是:"+adapter.phone[position]);
            }
        });
    }
}
