package th.ac.sut.viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import th.ac.sut.viewpager.R;

/**
 * Created by Developer on 29/7/2559.
 */
public class FragmentOne extends Fragment {

    private static final String KEY_STRING = "key_string";

    public static FragmentOne newInstance(String str) {
        FragmentOne fragment = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_STRING, str);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //        return super.onCreateView(inflater, container, savedInstanceState);
        Log.i("Check", "OnCreateView");

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        return rootView;
    }

    public void onDestroyView() {
        Log.i("Check", "OnDestroyView");
    }
}
