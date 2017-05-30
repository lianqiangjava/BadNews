package com.lianqiang.badnews.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import com.lianqiang.badnews.db.bean.TBNewsChannel;

import java.util.List;

/**
 * Describe:
 *
 * @author lianqiang on 2017/5/25.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private List<BaseFragment> fragmentList;
    private List<String> pageTitles;

    public BaseFragmentAdapter(FragmentManager fm,List<BaseFragment> fragmentList,List<String> pageTitles) {
        super(fm);
        this.fm = fm;
        this.fragmentList = fragmentList;
        this.pageTitles = pageTitles;
        notifyDataSetChanged();
    }

    public void updateAdapter(List<BaseFragment> fms,List<String> pageTitles){
        this.pageTitles = pageTitles;
        FragmentTransaction ft = fm.beginTransaction();
        for (int i = 0; i < fragmentList.size(); i++) {
            boolean flag = false;
            for (BaseFragment fragment : fms) {
                if(fragmentList.get(i).equals(fragment)){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                ft.remove(fragmentList.get(i));
                pageTitles.remove(i);
            }
        }

        ft.commit();
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles.get(position);
    }
}
