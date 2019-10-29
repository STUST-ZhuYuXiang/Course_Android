package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list_ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_ball = (ListView)findViewById(R.id.list_ball);

        //宣告自定義橋接器
        myAdapter adapter = new myAdapter(this);

        //將 ListView 橋接設成定義的
        list_ball.setAdapter(adapter);
        list_ball.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "第 "+ (position+1) +" 個選項備按下", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
