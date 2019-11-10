package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MT19068_FragArgument extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt19068_fragmentlayout);
        getIncomingIntent();
    }
    private void getIncomingIntent()
    {
        Log.d("TAG","getIncomingIntent: checking for incoming intents.");


        if (getIntent().hasExtra("name") && getIntent().hasExtra("number")) {
            Log.d("TAG","getIncomingIntent: found intent extras.");


            String passName = getIntent().getStringExtra("name");
            String passNumber = getIntent().getStringExtra("number");
            MT19068_ArgumentsFragmentFrag fra = MT19068_ArgumentsFragmentFrag.newInstance(passName,passNumber);
            FragmentTransaction txn=getSupportFragmentManager().beginTransaction();
            txn.replace(R.id.f_container,fra);
            txn.commit();
            //setData(passName, passNumber);
        }
    }
}
