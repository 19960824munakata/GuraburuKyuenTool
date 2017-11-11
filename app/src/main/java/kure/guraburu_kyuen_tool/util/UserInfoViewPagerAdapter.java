package kure.guraburu_kyuen_tool.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import kure.guraburu_kyuen_tool.Config.Config;
import kure.guraburu_kyuen_tool.OfficialPageFragment;
import kure.guraburu_kyuen_tool.OfficialTwitterFragment;
import kure.guraburu_kyuen_tool.ReliefFragment;
import kure.guraburu_kyuen_tool.SettingFragment;
import kure.guraburu_kyuen_tool.WikiFragment;

/**
 * ページを切り替える際のAdapter
 *
 * Created by yuuma on 2017/11/11.
 */

public class UserInfoViewPagerAdapter extends FragmentPagerAdapter{

    public UserInfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new ReliefFragment();
                break;
            case 1:
                fragment = new OfficialTwitterFragment();
                break;
            case 2:
                fragment = new OfficialPageFragment();
                break;
            case 3:
                fragment = new WikiFragment();
                break;
            case 4:
                fragment = new SettingFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return Config.PAGE_NUM;
    }
}
