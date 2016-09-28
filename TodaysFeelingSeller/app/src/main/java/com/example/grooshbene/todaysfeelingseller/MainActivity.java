package com.example.grooshbene.todaysfeelingseller;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

/**
 * Created by GrooshBene on 2016. 9. 23..
 */
public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager mViewPager;
    PagerAdapter mPagerAdapter;
    BluetoothSPP bt;
    String receive;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = new BluetoothSPP(this);
        if(!bt.isBluetoothAvailable()){
            Toast.makeText(getApplicationContext(), "블루투스르 켜주세요!", Toast.LENGTH_SHORT).show();
            finish();
        }

        bt.setBluetoothConnectionListener(new BluetoothSPP.BluetoothConnectionListener(){
            @Override
            public void onDeviceConnected(String name, String address) {
                Toast.makeText(getApplicationContext(), "오늘의 분위기 박스와 연결되었습니다.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeviceDisconnected() {
                Toast.makeText(getApplicationContext(), "오늘의 분위기 박스와의 연결이 끊겼습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeviceConnectionFailed() {

            }
        });
        bt.setAutoConnectionListener(new BluetoothSPP.AutoConnectionListener() {
            @Override
            public void onAutoConnectionStarted() {

            }

            @Override
            public void onNewConnection(String name, String address) {

            }
        });

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                receive = message;
                Log.e("Bluetooth Message", receive);
            }
        });
        mViewPager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
//        Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
        mPagerAdapter.addFragment(new MonitorActivity());
        mPagerAdapter.addFragment(new InfoActivity());
        mPagerAdapter.addFragment(new StatisticsActivity());
        mPagerAdapter.addFragment(new PlaceInfoActivity());

        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public class PagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragment = new ArrayList<>();
        String[] tabTitles = new String[] {"연결 관리", "모니터링 정보", "통계", "업소 정보"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
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
            return tabTitles[position];
        }
    }
}
