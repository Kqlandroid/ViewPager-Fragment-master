package test.view.com.test;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.view.com.test.base.BaseActivity;
import test.view.com.test.base.BaseFragmentPagerAdapter;
import test.view.com.test.fragment.FragmentFour;
import test.view.com.test.fragment.FragmentOne;
import test.view.com.test.fragment.FragmentThree;
import test.view.com.test.fragment.FragmentTwo;

public class MainActivity extends BaseActivity {
    private BaseFragmentPagerAdapter adapter;
    private List<Fragment> fragments;
    private TextView tvtiltle;
    private ViewPager viewPager;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        viewPager = findView(R.id.viewpager);
        tvtiltle = findView(R.id.title);
        tv1 = findView(R.id.tv1);
        tv2 = findView(R.id.tv2);
        tv3 = findView(R.id.tv3);
        tv4 = findView(R.id.tv4);
    }

    @Override
    public void initListener() {
        setOnclick(tv1);
        setOnclick(tv2);
        setOnclick(tv3);
        setOnclick(tv4);
    }

    @Override
    public void initData() {
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        FragmentOne one = new FragmentOne();
        FragmentTwo two = new FragmentTwo();
        FragmentThree three = new FragmentThree();
        FragmentFour four = new FragmentFour();
        fragments.add(one);
        fragments.add(two);
        fragments.add(three);
        fragments.add(four);

        adapter = new BaseFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int currentIndex;
            public void onPageSelected(int position) {
                resetTabBtn();
                ColorStateList cs = MainActivity.this.getResources().getColorStateList(R.color.colorAccent);
                switch (position) {
                    case 0:
                        tvtiltle.setText("消息");
                        tv1.setTextColor(cs);
                        break;
                    case 1:
                        tvtiltle.setText("通讯录");
                        tv2.setTextColor(cs);
                        break;
                    case 2:
                        tvtiltle.setText("发现");
                        tv3.setTextColor(cs);
                        break;
                    case 3:
                        tvtiltle.setText("我");
                        tv4.setTextColor(cs);
                        break;
                }
                currentIndex = position;
            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void resetTabBtn() {
        ColorStateList cs = this.getResources().getColorStateList(R.color.gray);
        tv1.setTextColor(cs);
        tv2.setTextColor(cs);
        tv3.setTextColor(cs);
        tv4.setTextColor(cs);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.tv1:
                viewPager.setCurrentItem(0);
                tvtiltle.setText("消息");
                tv1.setTextColor(Color.parseColor("#D2216D"));
                break;
            case R.id.tv2:
                viewPager.setCurrentItem(1);
                tvtiltle.setText("通讯录");
                tv2.setTextColor(Color.parseColor("#D2216D"));
                break;
            case R.id.tv3:
                viewPager.setCurrentItem(2);
                tvtiltle.setText("发现");
                tv3.setTextColor(Color.parseColor("#D2216D"));
                break;
            case R.id.tv4:
                viewPager.setCurrentItem(3);
                tvtiltle.setText("我");
                tv4.setTextColor(Color.parseColor("#D2216D"));
                break;
        }
    }
}
