package com.example.contactlist;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MT19068_FragmentCall extends Fragment
{
    private RecyclerView recyclerView;
    View v;
    public MT19068_FragmentCall() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.mt19068_frag_calls,container,false);
        recyclerView =v.findViewById(R.id.rv_calls);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager=linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        MT19068_RecyclerViewAdapter adapter= new MT19068_RecyclerViewAdapter(getContext(), getCallLogs());
        recyclerView.setAdapter(adapter);
        return v;
    }
    private List<MT19068_ModelCalls> getCallLogs(){

        List<MT19068_ModelCalls> list= new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CALL_LOG},1);
        }
        Cursor cursor= getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI,null,null,null,CallLog.Calls.DATE);
        int number=cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int duration=cursor.getColumnIndex(CallLog.Calls.DURATION);
        int date=cursor.getColumnIndex(CallLog.Calls.DATE);

        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
            Date date1= new Date(Long.valueOf(cursor.getString(date)));
            String mnth_date, week_day, month;
            mnth_date= (String)DateFormat.format("dd",date);
            week_day= (String)DateFormat.format("EEEE",date);
            month= (String)DateFormat.format("MMMM",date);
            list.add(new MT19068_ModelCalls(cursor.getString(number),cursor.getString(duration),week_day+" "+mnth_date+" "+month));
        }
        return list;
    }


}
