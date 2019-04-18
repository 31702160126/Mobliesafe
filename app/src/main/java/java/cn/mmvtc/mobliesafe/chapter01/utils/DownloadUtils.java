package java.cn.mmvtc.mobliesafe.chapter01.utils;

import java.cn.mmvtc.mobliesafe.chapter02.dialog.InterPasswordDialog;
import java.io.File;
import java.lang.annotation.Target;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2019/4/18.
 */

public class DownloadUtils {
    public void downapk(String url, String targerFile , final InterPasswordDialog.MyCallBack myCallBack){
        HttpUtils httpUtils = new httpUtils();
        httpUtils.download(url,targerFile, new RequestCallBack<File>(){
            public void onSuccess(ResponseInfo<File> arg0){
                myCallBack.onSuccess(arg0);
            }

            public void onFailure (HttpException arg0, String arg1){
                myCallBack.onFailure(arg0, arg1);
            }
            public void onLoading(long total, long current, boolean isUploading){
                super.onLoading(total,current,isUploading);
                myCallBack.onLoadding(total,current,isUploading);
            }
            });
    }
}
interface MyCallBack{
    void onSucess(ResponInfo<File> arg0);
    void onFailure(HttpException arg0 ,String arg1);
    void onLoadding(long total, long current, boolean isUploading);
}
