package xyz.isunxu.image_practice_0.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.ColorMatrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import xyz.isunxu.image_practice_0.R;
import xyz.isunxu.image_practice_0.utils.ImageUtils;

/**
 * Created by sunxu on 16/1/27.
 */
public class SecondActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private ImageView mImageView;

    /**
     * 色调
     */
    private SeekBar mSeekBarTone;

    /**
     * 饱和度
     */
    private SeekBar mSeekBaraturation;

    /**
     * 亮度
     */
    private SeekBar mSeekBarLum;

    private int MAX = 255;

    private int MID = 127;

    private float tone = 0;
    private float saturation = 1;
    private float lum = 1;
    private Bitmap mBitmap;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();

        initListeners();
    }


    private void initListeners() {

        mSeekBarTone.setOnSeekBarChangeListener(this);
        mSeekBaraturation.setOnSeekBarChangeListener(this);
        mSeekBarLum.setOnSeekBarChangeListener(this);
    }


    private void initViews() {

        mImageView = (ImageView) findViewById(R.id.activity_second_imageview);
        mBitmap = ((BitmapDrawable) mImageView.getDrawable()).getBitmap();

        mSeekBarTone = (SeekBar) findViewById(R.id.seekbar_tone);
        mSeekBaraturation = (SeekBar) findViewById(R.id.seekbar_saturation);
        mSeekBarLum = (SeekBar) findViewById(R.id.seekbar_luminance);

        mSeekBarTone.setMax(MAX);
        mSeekBarTone.setProgress(MID);

        mSeekBaraturation.setMax(MAX);
        mSeekBaraturation.setProgress(MID);

        mSeekBarLum.setMax(MAX);
        mSeekBarLum.setProgress(MID);
    }


    @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_tone:
                // tone [-180,180]
                tone = (progress - MID) * 1.0f / MID * 180;
                break;
                // saturation [0,2]
            case R.id.seekbar_saturation:
                saturation = progress * 1.0f / MID;
                break;
                // lum [0,2]
            case R.id.seekbar_luminance:
                lum = progress * 1.0f / MID;
                break;
        }
        mImageView.setImageBitmap(ImageUtils.handleImageMatrix(mBitmap, tone, saturation, lum));
    }


    @Override public void onStartTrackingTouch(SeekBar seekBar) {

    }


    @Override public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

