package xyz.isunxu.imooc_practice_android.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import xyz.isunxu.imooc_practice_android.R;
import xyz.isunxu.imooc_practice_android.fragment.AddressFragment;
import xyz.isunxu.imooc_practice_android.fragment.FriendFragment;
import xyz.isunxu.imooc_practice_android.fragment.SettingFragment;
import xyz.isunxu.imooc_practice_android.fragment.WeixinFragment;

public class FragmentBringTabActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment mFragment_weixin;
    private Fragment mFragment_friend;
    private Fragment mFragment_address;
    private Fragment mFragment_settings;

    private LinearLayout mLinearLayout_weixin;
    private LinearLayout mLinearLayout_friend;
    private LinearLayout mLinearLayout_address;
    private LinearLayout mLinearLayout_settings;

    private ImageButton mImageButton_weixin;
    private ImageButton mImageButton_friend;
    private ImageButton mImageButton_address;
    private ImageButton mImageButton_settings;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_bring_tab);

        initViews();

        initListeners();
        setSelect(0);
    }


    private void initListeners() {

        mLinearLayout_weixin.setOnClickListener(this);
        mLinearLayout_address.setOnClickListener(this);
        mLinearLayout_friend.setOnClickListener(this);
        mLinearLayout_settings.setOnClickListener(this);
    }


    private void initViews() {

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
        switch (v.getId()) {

            case R.id.ll_weixin:
                setSelect(0);
                break;
            case R.id.ll_friend:
                setSelect(1);
                break;
            case R.id.ll_address:
                setSelect(2);
                break;
            case R.id.ll_settings:
                setSelect(3);
                break;
        }
    }


    public void setSelect(int position) {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        hideFragment(fragmentTransaction);

        resetBackground();

        switch (position) {
            case 0:
                if (mFragment_weixin == null) {
                    mFragment_weixin = new WeixinFragment();
                    fragmentTransaction.add(R.id.container, mFragment_weixin);
                }
                else {
                    fragmentTransaction.show(mFragment_weixin);
                }
                mLinearLayout_weixin.setBackgroundResource(R.drawable.tab_bg2);
                mImageButton_weixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                if (mFragment_friend == null) {
                    mFragment_friend = new FriendFragment();
                    fragmentTransaction.add(R.id.container, mFragment_friend);
                }
                else {
                    fragmentTransaction.show(mFragment_friend);
                }
                mLinearLayout_friend.setBackgroundResource(R.drawable.tab_bg2);
                mImageButton_friend.setImageResource(R.drawable.tab_find_frd_pressed);
                break;

            case 2:
                if (mFragment_address == null) {
                    mFragment_address = new AddressFragment();
                    fragmentTransaction.add(R.id.container, mFragment_address);
                }
                else {
                    fragmentTransaction.show(mFragment_address);
                }
                mLinearLayout_address.setBackgroundResource(R.drawable.tab_bg2);
                mImageButton_address.setImageResource(R.drawable.tab_address_pressed);
                break;

            case 3:
                if (mFragment_settings == null) {
                    mFragment_settings = new SettingFragment();
                    fragmentTransaction.add(R.id.container, mFragment_settings);
                }
                else {
                    fragmentTransaction.show(mFragment_settings);
                }
                mLinearLayout_settings.setBackgroundResource(R.drawable.tab_bg2);
                mImageButton_settings.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }

        fragmentTransaction.commit();
    }


    private void resetBackground() {

        mLinearLayout_weixin.setBackground(new ColorDrawable(Color.TRANSPARENT));
        mLinearLayout_address.setBackground(new ColorDrawable(Color.TRANSPARENT));
        mLinearLayout_friend.setBackground(new ColorDrawable(Color.TRANSPARENT));
        mLinearLayout_settings.setBackground(new ColorDrawable(Color.TRANSPARENT));

        mImageButton_weixin.setImageResource(R.drawable.tab_weixin_normal);
        mImageButton_friend.setImageResource(R.drawable.tab_find_frd_normal);
        mImageButton_address.setImageResource(R.drawable.tab_address_normal);
        mImageButton_settings.setImageResource(R.drawable.tab_settings_normal);
    }


    private void hideFragment(FragmentTransaction fragmentTransaction) {

        if (mFragment_weixin != null) {
            fragmentTransaction.hide(mFragment_weixin);
        }

        if (mFragment_address != null) {
            fragmentTransaction.hide(mFragment_address);
        }


        if (mFragment_friend != null) {
            fragmentTransaction.hide(mFragment_friend);
        }

        if (mFragment_settings != null) {
            fragmentTransaction.hide(mFragment_settings);
        }
    }
}
