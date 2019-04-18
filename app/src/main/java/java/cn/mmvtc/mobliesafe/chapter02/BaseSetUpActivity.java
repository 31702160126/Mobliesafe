package java.cn.mmvtc.mobliesafe.chapter02;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Administrator on 2019/4/3.
 * 功能：手势识别器父类，其他的类可以继承该类
 * abstract抽象类的声明，BaseSetUpActivity借口
 */

public abstract class BaseSetUpActivity extends Activity {
    public SharedPreferences sp;
    private GestureDetector mGestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getSharedPreferences("config",MODE_PRIVATE);
        //1.手势识别器初始化
        mGestureDetector=new GestureDetector(this,new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if(Math.abs(velocityX)<200) {
                    Toast.makeText(getApplicationContext(),"无效动作，移动太慢",Toast.LENGTH_SHORT);
                    return true;
                }
                if ((e2.getRawX() - e1.getRawX())>200) {
                    //由左向右滑动，显示上一个界面
                    showPre();
                    overridePendingTransition(android.R.anim.pre_in, android.R.anim.pre_out);
                    return true;
                }
                if ((e1.getRawX()-e2.getRawX())>200){
                    showNext();
                    overridePendingTransition(android.R.anim.next_in, android.R.anim.next_out);
                    return true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }
        });
        }
    public abstract void showNext();
    public abstract void showPre();
//用手术识别器去识别事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //分析手势事件,做屏幕触摸才会发生调用手势识别器
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}

