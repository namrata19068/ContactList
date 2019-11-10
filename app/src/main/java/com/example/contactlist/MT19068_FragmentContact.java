package com.example.contactlist;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import java.util.List;

public class MT19068_FragmentContact extends Fragment {
    View v;
    private RecyclerView recyclerView;
    public MT19068_FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.mt19068_frag_contacts,container,false);
        recyclerView=v.findViewById(R.id.rv_contacts);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager=linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);
        MT19068_ContactsRvAdapter adapter= new MT19068_ContactsRvAdapter(getContext(),getContacts());
        recyclerView.setAdapter(adapter);
        return v;
    }
    private List<MT19068_ModelContacts> getContacts(){

        List<MT19068_ModelContacts> list= new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_CONTACTS},1);
        }
        Cursor cursor=getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,ContactsContract.Contacts.DISPLAY_NAME);
        cursor.moveToFirst();
        while(cursor.moveToNext())
        {
           list.add(new MT19068_ModelContacts(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
           )),cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
        }
        return list;
    }
}
