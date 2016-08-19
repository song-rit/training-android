package th.ac.sut.imageslideshow.fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import th.ac.sut.imageslideshow.model.ImageModel;
import th.ac.sut.imageslideshow.model.ProductModel;
import th.ac.sut.imageslideshow.utils.CheckNetworkConnection;

/**
 * Created by Developer on 1/8/2559.
 */
public class ImageSlideFragment extends Fragment {

    String url = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWMEV4X044Tm5OQkk&export=download";

    private ImageModel imageModel;
    TextView textViewImageName;
    FragmentActivity activity;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_slide, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewImageName = (TextView) view.findViewById(R.id.text_view_image_name);
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
                        final ImageModel imageModel = gson.fromJson(responseString, ImageModel.class);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(getContext(), imageModel.getStatus(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(getContext(), gson.toJson(imageModel.getProducts()), Toast.LENGTH_LONG).show();

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
