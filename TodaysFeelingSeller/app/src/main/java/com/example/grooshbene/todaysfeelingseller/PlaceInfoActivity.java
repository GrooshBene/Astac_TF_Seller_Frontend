package com.example.grooshbene.todaysfeelingseller;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by GrooshBene on 2016. 9. 28..
 */
public class PlaceInfoActivity extends Fragment implements View.OnClickListener {

    FrameLayout mReviewFrame;
    LinearLayout mReviewLinear, mReportLinear, mReview, mReportLists;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_placeinfo, container, false);
        mReportLinear = (LinearLayout)view.findViewById(R.id.mReportLinear);
        mReviewLinear = (LinearLayout)view.findViewById(R.id.mReviewLinear);
        mReviewFrame = (FrameLayout)view.findViewById(R.id.mReviewFrame);
        mReview = (LinearLayout)view.findViewById(R.id.mReview);
        mReportLists = (LinearLayout)view.findViewById(R.id.mReportLists);

        mReview.setOnClickListener(this);
        mReportLists.setOnClickListener(this);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mReview:
                mReportLinear.setVisibility(View.GONE);
                mReviewLinear.setVisibility(View.VISIBLE);
                mReview.setBackground(getResources().getDrawable(R.drawable.review_btn_background));
                mReportLists.setBackground(getResources().getDrawable(R.drawable.report_list_btn_background));
                break;
            case R.id.mReportLists:
                mReportLinear.setVisibility(View.VISIBLE);
                mReviewLinear.setVisibility(View.GONE);
                mReview.setBackground(getResources().getDrawable(R.drawable.report_list_btn_background));
                mReportLists.setBackground(getResources().getDrawable(R.drawable.review_btn_background));
                break;
        }
    }
}
