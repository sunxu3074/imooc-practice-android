package xyz.isunxu.imooc_practice_android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import xyz.isunxu.imooc_practice_android.R;
public class AddressFragment extends Fragment implements View.OnTouchListener{
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tab03, container, false);
    }


    @Override public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
