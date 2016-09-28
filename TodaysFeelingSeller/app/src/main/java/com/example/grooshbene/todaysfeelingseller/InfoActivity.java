package com.example.grooshbene.todaysfeelingseller;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by GrooshBene on 2016. 9. 28..
 */
public class InfoActivity extends Fragment implements View.OnClickListener {
    TextView mBrightTv, mNoiseTv, mTempTv;
    ImageView mRefreshBtn1, mRefreshBtn2, mRefreshBtn3;
    String data;
    String[] dataArr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_infomation, container, false);
        mRefreshBtn1 = (ImageView)view.findViewById(R.id.refreshBtn);
        mRefreshBtn2 = (ImageView)view.findViewById(R.id.refreshBtn2);
        mRefreshBtn3 = (ImageView)view.findViewById(R.id.refreshBtn3);
        mRefreshBtn1.setOnClickListener(this);
        mRefreshBtn2.setOnClickListener(this);
        mRefreshBtn3.setOnClickListener(this);
        mBrightTv = (TextView)view.findViewById(R.id.mBrightTv);
        mNoiseTv = (TextView)view.findViewById(R.id.mNoiseTv);
        mTempTv = (TextView)view.findViewById(R.id.mTempTv);
        return view;
    }

    @Override
    public void onClick(View v) {
        SharedPref pref = new SharedPref(getContext(), "bluetooth");
        data = pref.get("bluetooth_data", "");
        dataArr = data.split(",");
        if(!data.equals("")) {
            mNoiseTv.setText(dataArr[1]);
            mBrightTv.setText(dataArr[2]);
            mTempTv.setText(dataArr[3]);
        }
    }
}
