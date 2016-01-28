package xyz.isunxu.image_practice_0.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import xyz.isunxu.image_practice_0.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }


    private void initViews() {

        mTextView = (TextView) findViewById(R.id.main_textview);
        mTextView.setTypeface(Typeface.createFromAsset(this.getAssets(), "fonts/test.ttf"));
    }


    public void onImageMatrix(View view) {
        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
    }

    public void onColorMatrix(View view) {
        startActivity(new Intent(getApplicationContext(),ThirdActivity.class));
    }
}
