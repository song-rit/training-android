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

    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";

    private final static String ARG_PARAM1 = "param1";

    public static ImageSlideFragment newInstance(String param) {
        ImageSlideFragment fragment = new ImageSlideFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param);
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
