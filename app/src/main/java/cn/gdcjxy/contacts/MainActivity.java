package cn.gdcjxy.contacts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.gdcjxy.contacts.fragment.ContactsFragment;
import cn.gdcjxy.contacts.fragment.SearchFragment;
import cn.gdcjxy.contacts.ui.AddActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;
    private List<Fragment> mFragment;
    private FloatingActionButton fab_add;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);

        initData();
        initView();
    }

    /**
     * add menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    /**
     * select Menu
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem){
        //get MenuId
        switch (menuItem.getItemId()){
            case R.id.HomeFriend:
                Toast.makeText(this,"FindOne",Toast.LENGTH_SHORT).show();
                initView();
                break;
            case R.id.AddFriends:
                Toast.makeText(this,"AddFriends...",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
            case R.id.Exit:
                Toast.makeText(this,"Exit....",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void initData() {
        mTitle = new ArrayList<>();
        mTitle.add("FindOne");
        mTitle.add("Search");
        mFragment = new ArrayList<>();
        ContactsFragment contactsFragment = new ContactsFragment();
        mFragment.add(contactsFragment);
        SearchFragment searchFragment = new SearchFragment();
        mFragment.add(searchFragment);
    }

    @SuppressLint("RestrictedApi")
    private void initView() {
        fab_add = (FloatingActionButton) findViewById(R.id.fab_add);
        fab_add.setOnClickListener(this);
        //fab_add
        fab_add.setVisibility(View.VISIBLE);
        mTabLayout = (TabLayout) findViewById(R.id.mTabLayout);
        mViewPager = (ViewPager) findViewById(R.id.mViewPage);

        //setOffscreenPageLimit
        mViewPager.setOffscreenPageLimit(mFragment.size());


        //addOnPageChangeListener
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @SuppressLint("RestrictedApi")
            @Override
            public void onPageSelected(int position) {
                if(position==0){
                    fab_add.setVisibility(View.VISIBLE);
                }else {
                    fab_add.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        //setAdapter
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //getItem
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //getCount
            @Override
            public int getCount() {
                return mFragment.size();
            }

            //getPageTitle

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //mViewPager
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab_add:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
        }
    }

}