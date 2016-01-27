package xyz.isunxu.imooc_practice_android.activity;

import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import xyz.isunxu.imooc_practice_android.R;
import xyz.isunxu.imooc_practice_android.fragment.AddressFragment;
import xyz.isunxu.imooc_practice_android.fragment.FriendFragment;
import xyz.isunxu.imooc_practice_android.fragment.SettingFragment;
import xyz.isunxu.imooc_practice_android.fragment.WeixinFragment;

public class TabLayoutBringTabActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private TabLayout mTabLayout;

    private List<Fragment> mFragments;

    private String[] titles = new String[] { "微信", "朋友", "通讯", "设置", };

  //  private int[] imageResId = new int[] { R.drawable.tab_weixin_normal, R.drawable.tab_find_frd_normal,
  //          R.drawable.tab_address_normal, R.drawable.tab_settings_normal };


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_bring_tab);

        initViews();
        initDatas();
    }


    private void initDatas() {
        mFragments = new ArrayList<>();
        mFragments.add(new WeixinFragment());
        mFragments.add(new FriendFragment());
        mFragments.add(new AddressFragment());
        mFragments.add(new SettingFragment());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override public Fragment getItem(int position) {
                return mFragments.get(position);
            }


            @Override public int getCount() {
                return mFragments.size();
            }


            @Override public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });

        mTabLayout.setupWithViewPager(mViewPager);
    }


    private void initViews() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
    }


    @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position", mTabLayout.getSelectedTabPosition());
    }


    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int position = (int) savedInstanceState.get("position");
        //返回原来position的位置
        mTabLayout.getTabAt(position).select();
    }
}
