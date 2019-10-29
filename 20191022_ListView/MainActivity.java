package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_smartPhone;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_smartPhone = (ListView)findViewById(R.id.lv_smartPhone);
        btn_show = (Button)findViewById(R.id.btn_show);

        // 將 ListView 設定為單選模式
        lv_smartPhone.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //定義清單項目內容
        ArrayList <String> smartPhone = new ArrayList<String>();
        smartPhone.add("Android");
        smartPhone.add("IOS");
        smartPhone.add("Windows Phone");

        // 設置 ListView 的 Adapter，導入清單
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, smartPhone);
        lv_smartPhone.setAdapter(adapter);

        // 得到選取的項目位置，並用訊息顯示出來
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "選取：" + (lv_smartPhone.getCheckedItemPosition()+1), Toast.LENGTH_LONG).show();
            }
        });
    }
}
