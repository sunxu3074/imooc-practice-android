package xyz.isunxu.image_practice_0.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import xyz.isunxu.image_practice_0.R;
import xyz.isunxu.image_practice_0.utils.ImageUtils;

/**
 * Created by sunxu on 16/1/28.
 */
public class FourActivity extends Activity {

    private ImageView yuantu,huise,fanzhuan,huaijiu,quse,gaobaohe;

    private Bitmap mBitmap;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        initViews();

        initData();
    }


    private void initData() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.war3);
        yuantu.setImageBitmap(mBitmap);
        huise.setImageBitmap(ImageUtils.generateGrayImage(mBitmap));
        fanzhuan.setImageBitmap(ImageUtils.revertImage(mBitmap));
        huaijiu.setImageBitmap(ImageUtils.memoriesImage(mBitmap));
        quse.setImageBitmap(ImageUtils.desaturateImage(mBitmap));
        gaobaohe.setImageBitmap(ImageUtils.highSaturationImage(mBitmap));
    }


    private void initViews() {
        yuantu = (ImageView) findViewById(R.id.yuantu);
        huise = (ImageView) findViewById(R.id.huise);
        fanzhuan = (ImageView) findViewById(R.id.fanzhuan);
        huaijiu = (ImageView) findViewById(R.id.huaijiu);
        quse = (ImageView) findViewById(R.id.quse);
        gaobaohe = (ImageView) findViewById(R.id.gaobaohe);
    }
}

