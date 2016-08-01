package th.ac.sut.viewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import th.ac.sut.viewpager.fragment.FragmentOne;
import th.ac.sut.viewpager.fragment.FragmentThree;
import th.ac.sut.viewpager.fragment.FragmentTwo;

/**
 * Created by Developer on 29/7/2559.
 */
public class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private final int PAGE_NUM = 9;

    public CustomFragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragmentOne.newInstance("One Fragment");
            case 1:
                return FragmentTwo.newInstance("Two Fragment");
            case 2:
                return FragmentThree.newInstance("Three Fragment");
            case 3:
                return FragmentOne.newInstance("One Fragment");
            case 4:
                return FragmentTwo.newInstance("Two Fragment");
            case 5:
                return FragmentThree.newInstance("Three Fragment");
            case 6:
                return FragmentOne.newInstance("One Fragment");
            case 7:
                return FragmentOne.newInstance("Two Fragment");
            case 8:
                return FragmentThree.newInstance("Three Fragment");

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
