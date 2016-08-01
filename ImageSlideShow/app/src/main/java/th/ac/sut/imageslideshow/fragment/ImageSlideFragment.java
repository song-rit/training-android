package th.ac.sut.imageslideshow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.ac.sut.imageslideshow.R;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageSlideFragment extends Fragment {

    private final static String ARG_PARAM1 = "param1";

    public static ImageSlideFragment newInstance() {
        ImageSlideFragment fragment = new ImageSlideFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_slide, container, false);
    }
}
