package com.example.contactlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MT19068_ArgumentsFragmentFrag extends Fragment {

    String name,number;
    public static MT19068_ArgumentsFragmentFrag newInstance(String passName, String passNumber) {
        MT19068_ArgumentsFragmentFrag f = new MT19068_ArgumentsFragmentFrag();
        Bundle arg = new Bundle();
        arg.putString("name",passName);
        arg.putString("number",passNumber);
        f.setArguments(arg);
        return f;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.mt19068_fragmentlayout, container, false);
        TextView textView1 = view.findViewById(R.id.name);
        TextView textView2 = view.findViewById(R.id.number);
        if(getArguments() != null){
            name = getArguments().getString("name");
            number = getArguments().getString("number");

        }
        textView1.setText(name);
        textView2.setText(number);
        return view;
    }
}

