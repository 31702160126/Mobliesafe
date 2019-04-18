package java.cn.mmvtc.mobliesafe.chapter01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import junit.runner.Version;

import mmvtc.mobliesafe.R;

/**
 * Created by Administrator on 2019/4/18.
 */

public class SplashActivity extends Activity{
    private TextView mVersionTV;
    private String mVersion; //本地版本号

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        mVersion = myUtils.getVersion(getApplicationContext());
        mVersionTV = (TextView) findViewById(R.id.tv_splash_version);
        mVersionTV.setText("版本号"+mVersion); // 本地版本号
        final VersionUpdateUtils updateUtils=new VersionUpdateUtils
                (mVersion,this);
    new Thread(){
        public void run(){
            updateUtils.getCloudVersion();
        }
    }.start();
    }
}
