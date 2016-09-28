package com.example.grooshbene.todaysfeelingseller;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrooshBene on 2016. 9. 23..
 */
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager mViewPager;
    PagerAdapter mPagerAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
//        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
        mPagerAdapter.addFragment(new MonitorActivity());
        mPagerAdapter.addFragment(new InfoActivity());
        mPagerAdapter.addFragment(new StatisticsActivity());

//        mPagerAdapter.addFragment(new fragment_test(1));
//        mPagerAdapter.addFragment(new fragment_test(2));
//        mPagerAdapter.addFragment(new fragment_test(3));
//        mPagerAdapter.addFragment(new fragment_test(4));

        mViewPager.setAdapter(mPagerAdapter);
//        Toast.makeText(MainActivity.this, "setupAdapter", Toast.LENGTH_SHORT).show();

        mViewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragment = new ArrayList<>();
        private String title = ["1","2","3"];
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public void addFragment(Fragment fragment){
            Log.d("dudco", "add");
            mFragment.add(fragment);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }
        @Override
        public int getCount() {
            return mFragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}
