package com.android.tourguide;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.tourguide.R;
import com.android.tourguide.home_fragment;

public class SimpleFragmentAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new home_fragment();
        } else if (position == 1) {
            return new schedule_fragment();
        }
        else {
            return new Attendence_fragment();
        }

    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        if (position == 0)
        {
            return mContext.getString(R.string.Student_Home);
        } else if (position == 1)
        {
            return mContext.getString(R.string.Student_schedule);
        }  else
        {
            return mContext.getString(R.string.Student_Attendence);
        }
    }
}

