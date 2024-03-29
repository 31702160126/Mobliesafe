package java.cn.mmvtc.mobliesafe.chapter02.dialog;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cn.mmvtc.mobliesafe.R;

public class InterPasswordDialog extends Dialog implements View.OnClickListener{
//    对话框标题
    private TextView mTitleTV;
    public EditText mFirstPWDET;
    public EditText mAffirmET;
//    输入密码文本框
    private EditText mInterET;
//    确认按钮
    private Button mOKBtn;
//        取消按钮
    private Button mCancleBtn;
    private MyCallBack myCallBack;
    private Context context;
    //构造方法，自定义对话框
    public InterPasswordDialog(Context context) {
        super(context,R.style.dialog_custom);
        this.context=context;
    }
    public void setCallBack(MyCallBack myCallBack){
        this.myCallBack=myCallBack;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.inter_password_dialog);
        super.onCreate(savedInstanceState);
       initView();
    }

    private void initView() {
        mTitleTV= (TextView) findViewById(R.id.tv_interpwd_title);
        mInterET= (EditText) findViewById(R.id.et_inter_password);
        mOKBtn= (Button) findViewById(R.id.btn_comfirm);
        mCancleBtn= (Button) findViewById(R.id.btn_dismiss);
        mOKBtn.setOnClickListener(this);
        mCancleBtn.setOnClickListener(this);


    }
    public void setTitle(String title){
        if(!TextUtils.isEmpty(title)){
            mTitleTV.setText(title);
        }
    }
    //获取输入密码判断，才能显示手机防盗主界面
    public String getPassword(){
        return mInterET.getText().toString();
    }
    //点击抽象的方法
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_comfirm:
                myCallBack.confirm();
                break;
            case R.id.btn_dismiss:
                myCallBack.cancle();
                break;
        }
    }
    //接口
    public interface MyCallBack{
        void confirm();//确认
        void cancle();//取消
    }
}
