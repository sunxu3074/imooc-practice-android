package xyz.isunxu.imooc_practice_android;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerBringTabActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;

    private LinearLayout mLinearLayout_weixin;
    private LinearLayout mLinearLayout_friend;
    private LinearLayout mLinearLayout_address;
    private LinearLayout mLinearLayout_settings;

    private ImageButton mImageButton_weixin;
    private ImageButton mImageButton_friend;
    private ImageButton mImageButton_address;
    private ImageButton mImageButton_settings;

    private List<View> mViews = new ArrayList<>();


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_bring_tab);

        initViews();

        initData();

        initListeners();
    }


    private void initListeners() {

        mLinearLayout_weixin.setOnClickListener(this);
        mLinearLayout_friend.setOnClickListener(this);
        mLinearLayout_address.setOnClickListener(this);
        mLinearLayout_settings.setOnClickListener(this);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }


            @Override public void onPageSelected(int position) {
                Log.d("sunxu_log","position--->"+position);
                resetImageButton();

                //position = currentItem
                //int currentItem = mViewPager.getCurrentItem();
                switch (position) {
                    case 0:
                        mImageButton_weixin.setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        mImageButton_friend.setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        mImageButton_address.setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        mImageButton_settings.setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }
            }


            @Override public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initData() {

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        mViews.add(layoutInflater.inflate(R.layout.tab01, null, false));
        mViews.add(layoutInflater.inflate(R.layout.tab02, null, false));
        mViews.add(layoutInflater.inflate(R.layout.tab03, null, false));
        mViews.add(layoutInflater.inflate(R.layout.tab04, null, false));

        mViewPager.setAdapter(new PagerAdapter() {

            @Override public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(mViews.get(position));
            }


            @Override public Object instantiateItem(ViewGroup container, int position) {
                View view = mViews.get(position);
                container.addView(view);
                return view;
            }


            @Override public int getCount() {
                return mViews.size();
            }


            @Override public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });
    }


    private void initViews() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mLinearLayout_weixin = (LinearLayout) findViewById(R.id.ll_weixin);
        mLinearLayout_friend = (LinearLayout) findViewById(R.id.ll_friend);
        mLinearLayout_address = (LinearLayout) findViewById(R.id.ll_address);
        mLinearLayout_settings = (LinearLayout) findViewById(R.id.ll_settings);

        mImageButton_weixin = (ImageButton) findViewById(R.id.ib_weixin);
        mImageButton_friend = (ImageButton) findViewById(R.id.ib_friend);
        mImageButton_address = (ImageButton) findViewById(R.id.ib_address);
        mImageButton_settings = (ImageButton) findViewById(R.id.ib_settings);
    }


    @Override public void onClick(View v) {

        resetImageButton();

        int id = v.getId();
        switch (id) {
            case R.id.ll_weixin:
                mViewPager.setCurrentItem(0);
                mImageButton_weixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;

            case R.id.ll_friend:
                mViewPager.setCurrentItem(1);
                mImageButton_friend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;

            case R.id.ll_address:
                mViewPager.setCurrentItem(2);
                mImageButton_address.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.ll_settings:
                mViewPager.setCurrentItem(3);
                mImageButton_settings.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }


    private void resetImageButton() {

        mImageButton_weixin.setImageResource(R.drawable.tab_weixin_normal);
        mImageButton_friend.setImageResource(R.drawable.tab_find_frd_normal);
        mImageButton_address.setImageResource(R.drawable.tab_address_normal);
        mImageButton_settings.setImageResource(R.drawable.tab_settings_normal);
    }
}
