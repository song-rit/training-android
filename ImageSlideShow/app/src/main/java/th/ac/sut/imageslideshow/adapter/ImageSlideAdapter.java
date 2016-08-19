package th.ac.sut.imageslideshow.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import th.ac.sut.imageslideshow.R;
import th.ac.sut.imageslideshow.fragment.ImageSlideFragment;
import th.ac.sut.imageslideshow.model.ProductModel;

/**
 * Created by Developer on 19/8/2559.
 */
public class ImageSlideAdapter extends PagerAdapter {

    private final int PAGE_NUM = 0;
    ArrayList<ProductModel> productModels;
    FragmentActivity activity;
    ImageSlideFragment fragment;
    DisplayImageOptions options;
    private ImageLoadingListener imageListener;
    ImageLoader imageLoader = ImageLoader.getInstance();

    public ImageSlideAdapter(final ArrayList<ProductModel> productModels, final FragmentActivity activity, ImageSlideFragment fragment) {
        this.productModels = productModels;
        this.activity = activity;
        this.fragment = fragment;
        options = new DisplayImageOptions.Builder()
                .showImageOnFail(R.drawable.ic_error)
                .showStubImage(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.drawable.ic_empty).cacheInMemory()
                .cacheOnDisc().build();
        imageListener = new ImageDisplayListener();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Toast.makeText(activity, gson.toJson(productModels), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.image_slide, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.image_view);
        imageLoader.displayImage((productModels.get(position)).getImageUrl(), image, options, imageListener);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private static class ImageDisplayListener extends
            SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections
                .synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view,
                                      Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 500);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
}
