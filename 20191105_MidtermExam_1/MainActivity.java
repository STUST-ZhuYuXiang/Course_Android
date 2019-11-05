package com.example.stust.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private TextView tv_passwd;
    private TextView tv_show;
    private EditText ed_name;
    private EditText ed_passwd;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_passwd = (TextView)findViewById(R.id.tv_passwd);
        tv_show = (TextView)findViewById(R.id.tv_show);
        ed_name = (EditText)findViewById(R.id.ed_name);
        ed_passwd = (EditText)findViewById(R.id.ed_passwd);
        btn_show = (Button)findViewById(R.id.btn_show);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_show.setText("你輸入的帳號為:"+ed_name.getText()+"\n你輸入的密碼為:"+ed_passwd.getText());
            }
        });
    }
}
