package xyz.isunxu.imooc_practice_android.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import xyz.isunxu.imooc_practice_android.R;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void open_viewpager(View view) {
        startActivity(new Intent(getApplicationContext(), ViewPagerBringTabActivity.class));
    }


    public void open_fragment(View view) {
        startActivity(new Intent(getApplicationContext(), FragmentBringTabActivity.class));
    }
}
