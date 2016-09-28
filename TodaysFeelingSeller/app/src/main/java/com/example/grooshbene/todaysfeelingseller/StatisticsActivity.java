package com.example.grooshbene.todaysfeelingseller;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrooshBene on 2016. 9. 28..
 */
public class StatisticsActivity extends Fragment {
    PieChart mGenderChart, mAgeChart, mTimeZoneChart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_statistics, container, false);
        List<PieEntry> mGenderEntries = new ArrayList<>();
        List<PieEntry> mAgeEntries = new ArrayList<>();
        List<PieEntry> mTimeZoneEntries = new ArrayList<>();
        mAgeEntries.add(new PieEntry(25.0f));
        mAgeEntries.add(new PieEntry(25.0f));
        mAgeEntries.add(new PieEntry(25.0f));
        mAgeEntries.add(new PieEntry(25.0f));

        mTimeZoneEntries.add(new PieEntry(25.0f));
        mTimeZoneEntries.add(new PieEntry(25.0f));
        mTimeZoneEntries.add(new PieEntry(25.0f));
        mTimeZoneEntries.add(new PieEntry(25.0f));


        mGenderEntries.add(new PieEntry(50.0f));
        mGenderEntries.add(new PieEntry(50.0f));
        mGenderChart = (PieChart) view.findViewById(R.id.mGenderChart);
        mAgeChart = (PieChart) view.findViewById(R.id.mAgeChart);
        mTimeZoneChart = (PieChart)view.findViewById(R.id.mTimeZoneChart);
        mGenderChart.setDescription("");
        mAgeChart.setDescription("");
        mTimeZoneChart.setDescription("");
        mGenderChart.setExtraOffsets(5, 10, 5, 5);
        mAgeChart.setExtraOffsets(5, 10, 5, 5);
        mTimeZoneChart.setExtraOffsets(5, 10, 5, 5);

        mGenderChart.setDrawHoleEnabled(true);
        mAgeChart.setDrawHoleEnabled(true);
        mTimeZoneChart.setDrawHoleEnabled(true);
        mGenderChart.setTouchEnabled(false);
        mAgeChart.setTouchEnabled(false);
        mTimeZoneChart.setTouchEnabled(false);
        mGenderChart.setHoleColor(Color.argb(00,00,00,00));
        mAgeChart.setHoleColor(Color.argb(00,00,00,00));
        mTimeZoneChart.setHoleColor(Color.argb(00,00,00,00));

        mGenderChart.setTransparentCircleColor(Color.WHITE);
        mAgeChart.setTransparentCircleColor(Color.WHITE);
        mTimeZoneChart.setTransparentCircleColor(Color.WHITE);
        mGenderChart.setTransparentCircleAlpha(110);
        mAgeChart.setTransparentCircleAlpha(110);
        mTimeZoneChart.setTransparentCircleAlpha(110);
        mGenderChart.setHoleRadius(58f);
        mAgeChart.setHoleRadius(58f);
        mTimeZoneChart.setHoleRadius(58f);
        mGenderChart.setTransparentCircleRadius(61f);
        mAgeChart.setTransparentCircleRadius(61f);
        mTimeZoneChart.setTransparentCircleRadius(61f);

        mGenderChart.setDrawCenterText(false);
        mAgeChart.setDrawCenterText(true);
        mTimeZoneChart.setDrawCenterText(true);

        mGenderChart.setRotationAngle(0);
        mAgeChart.setRotationAngle(0);
        mTimeZoneChart.setRotationAngle(0);

        PieDataSet mGenderSet = new PieDataSet(mGenderEntries,"");
        PieData mGenderData = new PieData(mGenderSet);
        mGenderChart.setData(mGenderData);
        mGenderChart.invalidate();
        mGenderChart.

        PieDataSet mAgeSet = new PieDataSet(mAgeEntries,"");
        PieData mAgeData = new PieData(mAgeSet);
        mAgeChart.setData(mAgeData);
        mAgeChart.invalidate();

        PieDataSet mTimeZoneSet = new PieDataSet(mTimeZoneEntries, "");
        PieData mTimeZoneData = new PieData(mTimeZoneSet);
        mTimeZoneChart.setData(mTimeZoneData);
        mTimeZoneChart.invalidate();


        mGenderChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mAgeChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        mTimeZoneChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        return view;
    }
}
