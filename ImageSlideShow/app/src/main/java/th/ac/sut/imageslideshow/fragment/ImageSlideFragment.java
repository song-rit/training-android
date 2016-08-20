package th.ac.sut.imageslideshow.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import th.ac.sut.imageslideshow.R;
import th.ac.sut.imageslideshow.adapter.ImageSlideAdapter;
import th.ac.sut.imageslideshow.model.ImageModel;
import th.ac.sut.imageslideshow.model.ProductModel;
import th.ac.sut.imageslideshow.utils.CheckNetworkConnection;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageSlideFragment extends Fragment {
    private static final long ANIM_VIEWPAGER_DELAY = 5000;
    private static final long ANIM_VIEWPAGER_DELAY_USER_VIEW = 10000;
    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";

    private ImageModel imageModel;
    private FragmentActivity activity;
    private ViewPager pager;
    private Handler handler;
    private Runnable animateViewPager;
    boolean stopSliding = false;

    TextView textViewImageName;

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
        activity = getActivity();

    }

    private void infixView(View view) {
        pager = (ViewPager) view.findViewById(R.id.view_pager);
    }

    public void runnable(final int size) {
        handler = new Handler();
        animateViewPager = new Runnable() {
            public void run() {
                if (!stopSliding) {
                    if (pager.getCurrentItem() == size - 1) {
                        pager.setCurrentItem(0);
                    } else {
                        pager.setCurrentItem(
                                pager.getCurrentItem() + 1, true);
                    }
                    handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                }
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_image_slide, container, false);
        infixView(view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        textViewImageName = (TextView) view.findViewById(R.id.text_view_image_name);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (imageModel == null) {
            sendRequest();
        } else {

        }
    }

    private void sendRequest() {

        if (CheckNetworkConnection.isConnectionAvailable(activity)) {


            Thread thread = new Thread() {

                @Override
                public void run() {
                    super.run();
                    try {
                        final String responseString = HTTPGetRequest(url);
                        final Gson gson = new Gson();
                        imageModel = gson.fromJson(responseString, ImageModel.class);


                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getContext(), gson.toJson(imageModel.getProducts()), Toast.LENGTH_LONG).show();



                        pager.setAdapter(new ImageSlideAdapter(imageModel.getProducts(), activity, ImageSlideFragment.this));
                        runnable(imageModel.getProducts().size());
                        //Re-run callback
                        handler.postDelayed(animateViewPager, ANIM_VIEWPAGER_DELAY);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();

        } else {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    String HTTPGetRequest(final String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}
