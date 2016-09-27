package com.example.grooshbene.todaysfeelingseller;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

/**
 * Created by GrooshBene on 2016. 9. 23..
 */
public class MainActivity extends TabActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        TabHost tabhost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent;
        intent = new Intent().setClass(this, MonitorActivity.class);
        spec = tabhost.newTabSpec("1");
        spec.setIndicator("1");
        spec.setContent(intent);
        tabhost.addTab(spec);
        intent = new Intent().setClass(this,InfoActivity.class);
        spec = tabhost.newTabSpec("2");
        spec.setIndicator("2");
        spec.setContent(intent);
        tabhost.addTab(spec);
        intent = new Intent().setClass(this,StatisticsActivity.class);
        spec = tabhost.newTabSpec("3");
        spec.setIndicator("3");
        spec.setContent(intent);
        tabhost.addTab(spec);
        intent = new Intent().setClass(this, PlaceInfoActivity.class);
        spec = tabhost.newTabSpec("4");
        spec.setIndicator("4");
        spec.setContent(intent);
        tabhost.addTab(spec);
        tabhost.setCurrentTab(0);
    }
}
