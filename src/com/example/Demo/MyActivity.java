package com.example.Demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MyActivity" ;

    private static int ACTIVITY_REQUEST_CODE = 1988 ;

    Editable mPhoneNumText ;

    @InjectView(R.id.phone_num)
    EditText mPhoneNum;
    @InjectView(R.id.send_msg)
    Button mSendMsg;
    @InjectView(R.id.make_a_call)
    Button mMakeACall;
    @InjectView(R.id.call_recode)
    Button mCallRecode;
    @InjectView(R.id.confirm_wifi)
    Button mConfirmWifi;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.inject(this);

        bindListener();
    }

    /**
     * 注册监听器
     */
    private void bindListener() {
        mSendMsg.setOnClickListener(this);
        mMakeACall.setOnClickListener(this);
        mCallRecode.setOnClickListener(this);
        mConfirmWifi.setOnClickListener(this);
    }

    /**
     * <ol>
     *      <li>check whether phone num is null</li>
     *      <li>get the phone num</li>
     * </ol>
     */
    private boolean isPhoneNumNull(){
        mPhoneNumText = mPhoneNum.getText();
        if (TextUtils.isEmpty(mPhoneNumText)) {
            App.alert("请输入电话号码");
            return true;
        }
        return false ;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            //send a msg
            case R.id.send_msg:
                if (isPhoneNumNull()){
                    return ;
                };
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + mPhoneNumText));
                smsIntent.putExtra("sms_body", "");
                startActivity(smsIntent);
                break;
            //查看通话记录
            case R.id.make_a_call:
                if (isPhoneNumNull()){
                    return ;
                };
                Intent telIntent = new Intent(Intent.ACTION_DIAL);
                telIntent.setData(Uri.parse("tel:" + mPhoneNumText));
                startActivity(telIntent);
                break;
            case R.id.call_recode:
                Intent callRecodeIntent = new Intent(Intent.ACTION_CALL_BUTTON);
                startActivity(callRecodeIntent);
                break;
            case R.id.confirm_wifi:
                checkNetwork() ;
                break;
        }
    }

    private void checkNetwork(){
       class DialogLser implements DialogInterface.OnClickListener{
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                switch (which) {
                    //wifi
                    case DialogInterface.BUTTON_POSITIVE:
//                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        startActivityForResult(new Intent(Settings.ACTION_WIFI_SETTINGS), ACTIVITY_REQUEST_CODE);
                        break;

                    //mobile
                    case DialogInterface.BUTTON_NEUTRAL:
                        //无线和网络
//                    startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                        //移动网络设置
//                        startActivity(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS));
                        startActivityForResult(new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS),ACTIVITY_REQUEST_CODE);
                        break;
                    //取消操作
                    case  DialogInterface.BUTTON_NEGATIVE:
                        break;

                }
            }


        }
        DialogLser dialogLser = new DialogLser() ;
        if (NetworkStatus.isOnline()) {
            App.alert("网络连接可用");
        }
        else {
            new AlertDialog.Builder(this)
                    .setTitle("网络连接不可用")
                    .setMessage("开启以下网络，或取消操作")
                    .setNegativeButton("取消",dialogLser)
                    .setNeutralButton("手机网络",dialogLser)
                    .setPositiveButton("WIFI",dialogLser)
                    .create().show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_REQUEST_CODE) {
//            mConfirmWifi.performClick() ;
            mConfirmWifi.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mConfirmWifi.performClick() ;
                }
            },5*1000) ;
        }

    }
}
