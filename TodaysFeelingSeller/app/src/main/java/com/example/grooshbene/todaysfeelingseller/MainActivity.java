package com.example.grooshbene.todaysfeelingseller;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by GrooshBene on 2016. 9. 23..
 */
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("a"));
        tabLayout.addTab(tabLayout.newTab().setText("b"));
        tabLayout.addTab(tabLayout.newTab().setText("c"));
        tabLayout.addTab(tabLayout.newTab().setText("d"));
    }
}
