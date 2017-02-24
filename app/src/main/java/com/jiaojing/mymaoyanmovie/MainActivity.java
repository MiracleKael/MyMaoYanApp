package com.jiaojing.mymaoyanmovie;

import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.jiaojing.mymaoyanmovie.base.BaseActivity;
import com.jiaojing.mymaoyanmovie.base.BaseFragment;
import com.jiaojing.mymaoyanmovie.cinema.fragment.CinemaFragment;
import com.jiaojing.mymaoyanmovie.find.fragment.FindFragment;
import com.jiaojing.mymaoyanmovie.home.fragment.HomeFragment;
import com.jiaojing.mymaoyanmovie.mine.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    private List<BaseFragment> fragments;
    private HomeFragment homeFragment;
    private CinemaFragment cinemaFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;

    private BaseFragment tempFragment;
    private int position;

    @Override
    protected void listener() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_cinema:
                        position = 1;
                        break;
                    case R.id.rb_find:
                        position = 2;
                        break;
                    case R.id.rb_mine:
                        position = 3;
                        break;

                }
                BaseFragment baseFragment = getFragment(position);
                switchFragment(tempFragment, baseFragment);
            }
        });
        //默认是主页面
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(BaseFragment thisFragment, BaseFragment nextFragment) {
        if(thisFragment != nextFragment){//才去跳转
            if(nextFragment != null){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if(nextFragment.isAdded()){//如果要跳转的页面已经添加
                    //
                    if(thisFragment != null){
                        transaction.hide(thisFragment);
                    }
                    //
                    transaction.show(nextFragment).commit();
                }else{
                    if(thisFragment != null){
                        transaction.hide(thisFragment);
                    }
                    transaction.add(R.id.fl_container, nextFragment).commit();
                }
                tempFragment = nextFragment;
            }
        }
    }


    private BaseFragment getFragment(int position) {
        return fragments.get(position);
    }

    @Override
    protected void initData() {
        //添加四个fragemet
        initFragment();

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        cinemaFragment = new CinemaFragment();
        findFragment = new FindFragment();
        mineFragment = new MineFragment();

        fragments.add(homeFragment);
        fragments.add(cinemaFragment);
        fragments.add(findFragment);
        fragments.add(mineFragment);

    }


    @Override
    protected int getLayoutById() {
        return R.layout.activity_main;
    }

}
