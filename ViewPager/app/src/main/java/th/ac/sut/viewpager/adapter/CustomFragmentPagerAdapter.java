package th.ac.sut.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import th.ac.sut.viewpager.fragment.FragmentOne;
import th.ac.sut.viewpager.fragment.FragmentThree;
import th.ac.sut.viewpager.fragment.FragmentTwo;

/**
 * Created by Developer on 29/7/2559.
 */
public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 3;

    public CustomFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return FragmentOne.newInstance("One Fragment");
//            case 1:
//                return FragmentOne.newInstance("One Fragment");
//            case 2:
//                return FragmentOne.newInstance("One Fragment");
//            default:
//                return null;
//        }

        if (position == 0) {
            return FragmentOne.newInstance("Hello Fragment One");
        } else if (position == 1) {
            return FragmentTwo.newInstance("Hello Fragment Two");
        } else if (position == 2) {
            return FragmentThree.newInstance("Hello Fragment Three");
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
