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
        //�ҵ��ı������,��ť
        numbertext=(EditText)this.findViewById(R.id.number2);
        contenttext=(EditText)this.findViewById(R.id.content);
        Button button2=(Button)this.findViewById(R.id.button2);
        //����ť�ĵ���¼����ڲ���
        button2.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v) {
    			//�õ��绰��������ݿ��е�����
    			String number=numbertext.getText().toString();
    			String content=contenttext.getText().toString();
    			//����һ����Ϣ����������
    			android.telephony.SmsManager manager=android.telephony.SmsManager.getDefault();
    			//���ŵ��������ƣ��Ѻܳ��Ķ��ŷֳɼ������ŷ���
    			ArrayList<String> texts=manager.divideMessage(content);
    			//��arrayList����һ�α���
    			for(String text:texts){
    				manager.sendTextMessage(number, null, text, null,null);
    			}
    			Toast.makeText(getApplicationContext(), R.string.sucess, Toast.LENGTH_SHORT).show();
    			contenttext.setText(null);
    		}
        });
    }
}
