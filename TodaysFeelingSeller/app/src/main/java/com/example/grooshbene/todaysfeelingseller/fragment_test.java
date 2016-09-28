package com.example.grooshbene.todaysfeelingseller;

//import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by GrooshBene on 2016. 9. 28..
 */
public class fragment_test extends Fragment {
    private int num;
    public fragment_test(int num) {
        this.num = num;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test, container, false);
        TextView text = (TextView) view.findViewById(R.id.text);
        text.setText(String.valueOf(num));
        return view;
    }
}
