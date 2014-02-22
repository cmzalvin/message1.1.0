package com.alvin.mes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private EditText edittext=null;
    private EditText numbertext;
    private EditText contenttext;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //找到文本输入框,按钮
        numbertext=(EditText)this.findViewById(R.id.number2);
        contenttext=(EditText)this.findViewById(R.id.content);
        Button button2=(Button)this.findViewById(R.id.button2);
        //处理按钮的点击事件，内部类
        button2.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v) {
    			//得到电话号码和内容框中的内容
    			String number=numbertext.getText().toString();
    			String content=contenttext.getText().toString();
    			//创建一个消息管理器对象
    			android.telephony.SmsManager manager=android.telephony.SmsManager.getDefault();
    			//短信的字数限制，把很长的短信分成几条短信发送
    			ArrayList<String> texts=manager.divideMessage(content);
    			//对arrayList进行一次遍历
    			for(String text:texts){
    				manager.sendTextMessage(number, null, text, null,null);
    			}
    			Toast.makeText(getApplicationContext(), R.string.sucess, Toast.LENGTH_SHORT).show();
    			contenttext.setText(null);
    		}
        });
    }
}
