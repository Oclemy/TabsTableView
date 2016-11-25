package com.tutorials.hp.tabstableview;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tutorials.hp.tabstableview.mFragments.InterGalactic;
import com.tutorials.hp.tabstableview.mFragments.InterPlanetary;
import com.tutorials.hp.tabstableview.mFragments.InterStellar;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tab;
    private ViewPager vp;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //VIEWPAGER AND TABS
        vp = (ViewPager) findViewById(R.id.viewpager);
        addPages();

        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
        tab.addOnTabSelectedListener(this);
    }
    private void addPages()
    {
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.addPage(InterPlanetary.newInstance());
        myPagerAdapter.addPage(InterStellar.newInstance());
        myPagerAdapter.addPage(InterGalactic.newInstance());

        vp.setAdapter(myPagerAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}


