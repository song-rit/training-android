package th.ac.sut.viewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import th.ac.sut.viewpager.R;

/**
 * Created by Developer on 29/7/2559.
 */

public class FragmentTwo extends Fragment {
    private TextView textView;
    private static final String ARG_PARMAM1 = "message";
    private String msg;

    public static FragmentTwo newInstance(String message) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARMAM1, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            msg = getArguments().getString(ARG_PARMAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_two, container, false);
        textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(msg);
        return view;
    }
}
