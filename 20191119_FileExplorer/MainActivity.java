package com.example.stust.myapplication;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private EditText edt_name;
    private Button btn_end, btn_clear;

    private String sname, msg;
    private SharedPreferences preferences;  //資料處理物件

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView)findViewById(R.id.tv_name);
        edt_name = (EditText)findViewById(R.id.edt_name);
        btn_end = (Button)findViewById(R.id.btn_end);
        btn_clear = (Button)findViewById(R.id.btn_clear);

        btn_end.setOnClickListener(listener);
        btn_clear.setOnClickListener(listener);

        preferences = getSharedPreferences("proFile", MODE_PRIVATE);    //建立儲存檔
        sname = preferences.getString("name", "");  //讀取資料

        //如果未建立資料，就顯示輸入欄位
        if (sname.equals("")) {
            tv_name.setVisibility(TextView.VISIBLE);
            edt_name.setVisibility(TextView.VISIBLE);
            btn_clear.setVisibility(TextView.INVISIBLE);

            msg = "歡迎使用本應用程式!\n你尚未建立基本資料，請輸入姓名!";
        }
        else
            msg = "親愛的" + sname + "，你好!\n歡迎再次使用本應用程式!";

        //對話視窗
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("歡迎使用本軟體")
                .setMessage(msg)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    Button.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //判斷按下哪個按鈕
            switch (v.getId()) {
                case R.id.btn_end:
                    finish();
                    break;
                case R.id.btn_clear:
                    if (!sname.equals("")) {
                        preferences.edit()
                                .clear()
                                .commit();

                        Toast.makeText(getApplicationContext(), "所有資料已被清除!", Toast.LENGTH_SHORT);
                    }
                    btn_clear.setVisibility(Button.INVISIBLE);
                    break;
            }
        }
    };

    //結束應用程式時觸發
    @Override
    protected void onStop() {
        super.onStop();

        //如果值是空的，就將輸入的值存進資料檔
        if (sname.equals("")) {
            preferences.edit()
                    .putString("name", edt_name.getText().toString())
                    .commit();
        }
    }
}