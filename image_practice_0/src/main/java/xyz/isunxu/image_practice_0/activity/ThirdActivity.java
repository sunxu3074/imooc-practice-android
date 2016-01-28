package xyz.isunxu.image_practice_0.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import xyz.isunxu.image_practice_0.R;
import xyz.isunxu.image_practice_0.utils.ImageUtils;

/**
 * Created by sunxu on 16/1/28.
 */
public class ThirdActivity extends Activity {

    private Button mBtnChange, mBtnReset;

    private ImageView mImageView;

    private GridLayout mGridLayout;

    private int height;
    private int width;

    private EditText[] mEditTexts = new EditText[20];
    private float[] matrixs = new float[20];

    private Bitmap mBitmap ;



    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        initViews();
    }


    private void initViews() {
        mGridLayout = (GridLayout) findViewById(R.id.activity_third_gridview);
        mImageView = (ImageView) findViewById(R.id.activity_third_imageview);
        mBtnChange = (Button) findViewById(R.id.activity_third_change);
        mBtnReset = (Button) findViewById(R.id.activity_third_reset);

        mBitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();

        mGridLayout.post(new Runnable() {
            @Override public void run() {
                width = mGridLayout.getWidth() / 5;
                height = mGridLayout.getHeight() / 4;
                // add edittext
                addETs();
                // init ETText();
                initETText();
            }
        });
    }


    private void initETText() {

        for (int i=0;i<20;i++) {
            if (i % 6 == 0) {
                mEditTexts[i].setText("1");
            }
            else {
                mEditTexts[i].setText("0");
            }
        }
    }


    private void addETs() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            editText.setGravity(Gravity.CENTER);
            mEditTexts[i] = editText;
            mGridLayout.addView(editText,width,height);
        }
    }

    private void getMatrix() {
        for (int i=0;i<20;i++) {
            matrixs[i] = Float.valueOf(mEditTexts[i].getText().toString());
        }
    }


    public void onChange(View view) {
        getMatrix();
        mImageView.setImageBitmap(ImageUtils.handleColorMatrix(mBitmap, matrixs));
    }


    public void onReset(View view) {
        initETText();
        getMatrix();
        mImageView.setImageBitmap(ImageUtils.handleColorMatrix(mBitmap, matrixs));
    }
}
