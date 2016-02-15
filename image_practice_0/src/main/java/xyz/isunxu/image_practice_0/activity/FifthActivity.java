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
public class FifthActivity extends Activity {

    private ImageView yuantu,dipian,laozhaopian,fudiao;

    private Bitmap mBitmap;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        initViews();

        initDatas();
    }


    private void initDatas() {

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.miaowa);
        yuantu.setImageBitmap(mBitmap);
        dipian.setImageBitmap(ImageUtils.backsheetImage(mBitmap));
        laozhaopian.setImageBitmap(ImageUtils.olderImage(mBitmap));
        fudiao.setImageBitmap(ImageUtils.reliefImage(mBitmap));
    }


    private void initViews() {

        yuantu = (ImageView) findViewById(R.id.yuantu);
        dipian = (ImageView) findViewById(R.id.dipian);
        laozhaopian = (ImageView) findViewById(R.id.laozhaopian);
        fudiao = (ImageView) findViewById(R.id.fudiao);

    }
}

