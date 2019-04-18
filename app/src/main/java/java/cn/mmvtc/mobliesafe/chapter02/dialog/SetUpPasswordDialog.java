package java.cn.mmvtc.mobliesafe.chapter02.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cn.mmvtc.mobliesafe.R;


public class SetUpPasswordDialog extends Dialog implements View.OnClickListener{
    //标题栏
    private TextView mTitleTV;
    //首次输入密码框
    private EditText mFirstPWDER;
    //确认密码
    private EditText mAFFirmET;
    //回调接口
    private MyCallBack myCallBack;
    public SetUpPasswordDialog(Context context){
        super(context, R.style.dialog_custom);//引入自定义对话框样式
    }
    public void setCallBack(MyCallBack myCallBack){
        this.myCallBack = myCallBack;
    }
    protected  void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.setup_password_dialog);
        super.onCreate(savedInstanceState);
        initView();
    }
//初始化控件
    private void initView() {
        mTitleTV = (TextView) findViewById(R.id.tv_interpwd_title);
        mFirstPWDER  = (EditText) findViewById(R.id.et_firstpwd);
        mAFFirmET = (EditText) findViewById(R.id.et_affirm_password);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_cancle).setOnClickListener(this);
    }
    //设置对话框标题栏
    public void setTitle(String title){
        if (!TextUtils.isEmpty(title)){
            mTitleTV.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ok:
                myCallBack.ok();
                break;
            case R.id.btn_cancle:
                myCallBack.cancle();
                break;
        }
    }

    public EditText getmAFFirmET() {
        return mAFFirmET;
    }

    public void setmAFFirmET(EditText mAFFirmET) {
        this.mAFFirmET = mAFFirmET;
    }

    public EditText getmFirstPWDER() {
        return mFirstPWDER;
    }

    public void setmFirstPWDER(EditText mFirstPWDER) {
        this.mFirstPWDER = mFirstPWDER;
    }

    public interface MyCallBack{
        void ok();
        void cancle();
    }
}
