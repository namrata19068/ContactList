package com.example.contactlist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MT19068_MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MT19068_ViewPagerAdapter adapter;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt19068_activity_main);

        tabLayout= (TabLayout) findViewById(R.id.tablayout_id);
        viewPager= (ViewPager) findViewById(R.id.viewpager_id);
        adapter= new MT19068_ViewPagerAdapter(getSupportFragmentManager());

        //Add fragment here

        adapter.AddFragment(new MT19068_FragmentCall(),"");
        adapter.AddFragment(new MT19068_FragmentContact(),"");
        adapter.AddFragment(new MT19068_FragmentFav(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_group);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_star_black_24dp);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setElevation(0);


        addButton=(Button)findViewById(R.id.addContactButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MT19068_MainActivity.this, MT19068_Form.class);
                startActivity(i);
            }
        });
    }
    private void askPermissions(){
       if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED){
           ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},1);
           ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CALL_LOG},1);
           ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_NUMBERS},1);
       }
    }

}
