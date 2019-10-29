package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_number;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_number = (TextView)findViewById(R.id.tv_number);
        btn_show = (Button)findViewById(R.id.btn_show);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("姓名：朱宇翔");
                tv_number.setText("學號：4A690101");
            }
        });
    }
}
