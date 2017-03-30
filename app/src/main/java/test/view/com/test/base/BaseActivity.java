package test.view.com.test.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import test.view.com.test.R;

/**
 * Created by 孔庆林 on 2017/3/30.
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    private SparseArray<View> mViews;
    public abstract int getLayoutId();
    public abstract void initViews();
    public abstract void initListener();
    public abstract void initData();
    public abstract void processClick(View v);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mViews = new SparseArray<>();
        initViews();
        initListener();
        initData();
    }
    @Override
    public void onClick(View view){
        processClick(view);
    }
    public  <E extends View> E findView(int viewid){
        E view =(E)mViews.get(viewid);
        if(view==null){
            view=(E)findViewById(viewid);
            mViews.put(viewid,view);
        }
        return view;
    }
    public <E extends View> void setOnclick(E view){
        view.setOnClickListener(this);
    }
}
