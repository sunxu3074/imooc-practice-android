package xyz.isunxu.image_practice_0.activity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import xyz.isunxu.image_practice_0.R;
import xyz.isunxu.image_practice_0.utils.ImageUtils;

/**
 * Created by sunxu on 16/1/29.
 */
public class SixthActivity extends Activity {

    private ImageView mImageView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setImageBitmap(
                ImageUtils.getGauss2Bitmap(BitmapFactory.decodeResource(getResources(), R.drawable.miaowa)));
    }
}

