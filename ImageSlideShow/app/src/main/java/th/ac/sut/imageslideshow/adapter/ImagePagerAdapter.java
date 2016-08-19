package th.ac.sut.imageslideshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 0 ;

    public ImagePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
