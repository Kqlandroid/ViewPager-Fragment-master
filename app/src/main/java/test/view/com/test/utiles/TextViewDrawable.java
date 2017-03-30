package test.view.com.test.utiles;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by 孔庆林 on 2017/3/16.
 * textview的文字和图片显示
 */

public class TextViewDrawable {
    //第三方登录图标显示向上
    public static Drawable getImgTop(Context context , int src){
        Drawable rightDrawable = context.getResources().getDrawable(src);
        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
        return rightDrawable;
    }
    //第三方登录图标显示向下
    public static Drawable getImgBottom(Context context , int src){
        Drawable rightDrawable = context.getResources().getDrawable(src);
        rightDrawable.setBounds(0, 0, rightDrawable.getMinimumWidth(), rightDrawable.getMinimumHeight());
        return rightDrawable;
    }
}
