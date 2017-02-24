package com.jiaojing.mymaoyanmovie.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.home.fragment.FindFilmFragment;
import com.jiaojing.mymaoyanmovie.home.fragment.HotPlayFragment;
import com.jiaojing.mymaoyanmovie.home.fragment.WaitPlayFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaojing on 2016/11/30.
 * 作用：xxx
 */
public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragmentList = new ArrayList<>();

    public HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    private void initFragment() {
        HotPlayFragment hotPlayFragment = new HotPlayFragment();
        WaitPlayFragment waitPlayFragment = new WaitPlayFragment();
        FindFilmFragment findFilmFragment = new FindFilmFragment();

        fragmentList.add(hotPlayFragment);
        fragmentList.add(waitPlayFragment);
        fragmentList.add(findFilmFragment);

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }
}
