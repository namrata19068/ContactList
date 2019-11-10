package com.example.contactlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MT19068_ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment=new ArrayList<>();
    private List<String> listTitles= new ArrayList<>();

    public MT19068_ViewPagerAdapter(@NonNull FragmentManager fm) {

        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return listFragment.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }
    public void AddFragment(Fragment fragment, String title)
    {
        listFragment.add(fragment);
        listTitles.add(title);
    }
}
