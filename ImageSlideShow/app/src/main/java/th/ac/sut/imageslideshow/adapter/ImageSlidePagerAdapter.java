package th.ac.sut.imageslideshow.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import th.ac.sut.imageslideshow.fragment.ImageSlideFragment;
import th.ac.sut.imageslideshow.model.ImageModel;
import th.ac.sut.imageslideshow.model.ProductModel;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageSlidePagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 0 ;
    ArrayList<ProductModel> productModels;
    FragmentActivity activity;
    ImageSlideFragment fragment;


    public ImageSlidePagerAdapter(FragmentManager fm, ArrayList<ProductModel> productModels, FragmentActivity activity, ImageSlideFragment fragment) {
        super(fm);
        this.productModels = productModels;
        this.activity = activity;
        this.fragment = fragment;
    }

    public ImageSlidePagerAdapter(FragmentManager fm, ArrayList<ProductModel> productModels ) {
        super(fm);
        this.productModels = productModels;
    }

    public ImageSlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return productModels.size();
    }
}
