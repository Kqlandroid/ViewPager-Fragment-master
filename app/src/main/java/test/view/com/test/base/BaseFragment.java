package test.view.com.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 孔庆林 on 2017/3/30.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private SparseArray<View> mViews;
    private boolean isVisiable = false;
    private boolean isInitView = false;
    private boolean isFirstlad = false;
    private View convertView;
    public abstract int getLayoutId();
    public abstract void initViews();
    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View v);
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViews = new SparseArray<>();
        convertView = inflater.inflate(getLayoutId(),container,false);
        initViews();
        isInitView = true;
        lazylad();
        return convertView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       if (isVisibleToUser){
           isVisiable = true;
           lazylad();
       }else {
           //设置不可见
           isVisiable = false;
       }
    }
    @Override
    public void onClick(View view){
        processClick(view);
    }
    //懒加载
    private void lazylad(){
        if (!isFirstlad || !isVisiable || !isInitView){
           //如果不是第一次加载，不是课件的，不是初始化View，则不加载数据
            return;
        }
        initListener();
        initData();
        //设置已经不是第一次加载
        isFirstlad = false;
    }
    public <E extends View> E finview(int viewId){
        if (convertView != null){
            E view=(E) mViews.get(viewId);
            if (view==null){
                mViews.put(viewId,view);
                return view;
            }
        }
        return null;
    }
    public <E extends View> void setOnClick(E view){
        view.setOnClickListener(this);
    }
}
