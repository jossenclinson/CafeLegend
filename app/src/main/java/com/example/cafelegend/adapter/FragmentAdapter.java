package com.example.cafelegend.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cafelegend.FragmentAppetizer;
import com.example.cafelegend.FragmentBeverage;
import com.example.cafelegend.FragmentMainCourse;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new FragmentAppetizer();
            case 1:
                return new FragmentMainCourse();
            case 2:
                return new FragmentBeverage();
        }

        return new FragmentAppetizer();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
