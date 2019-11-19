package com.example.stust.myapplication;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_name;
    private Button btn_download;

    // 訊息框元件
    ProgressDialog dialog;

    int UPDATE_DIALOG = 0;      //自訂訊息碼-進度
    int max = 100;              //ProgressDialog 進度最大值
    int currentProgress = 0;    //ProgressDialog 目前進度值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_name = (TextView)findViewById(R.id.tv_name);
        btn_download = (Button)findViewById(R.id.btn_download);

        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentProgress = 0;    //設定進度條起始值
                dialog = new ProgressDialog(MainActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);    //進度條樣式-水平直線
                dialog.setMessage("下載中...");
                dialog.setMax(max);
                dialog.setCancelable(false);                                    //對話視窗不可按返回取消
                dialog.show();

                UpdateThread thread = new UpdateThread();
                thread.start();
            }
        });
    }

    class UpdateThread extends Thread{
        @Override
        public void run() {
            while (currentProgress < max) {
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                currentProgress++;  //每執行一次 +1

                // 產生對話框訊息
                Message msg = handler.obtainMessage();
                msg.what = UPDATE_DIALOG;
                msg.arg1 = currentProgress;
                handler.sendMessage(msg);
            }
            super.run();
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == UPDATE_DIALOG)
                if (msg.arg1 == max) {
                    //表示進度達到100，則關閉對話框
                    dialog.dismiss();
                }
                else {
                    //更新對話框的進度數值
                    dialog.setProgress(msg.arg1);
                }
            super.handleMessage(msg);
        }
    };
}
