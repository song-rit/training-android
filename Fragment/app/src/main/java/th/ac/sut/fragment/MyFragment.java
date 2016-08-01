package th.ac.sut.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MyFragment extends Fragment {

    public static final String KEY_MESSAGE = "message";

    private String message;

    private TextView textView;

    public static MyFragment newInstance(String message) {

        MyFragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_MESSAGE, message);
        fragment.setArguments(bundle);
        return  fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        if(bundle != null) {
            message = bundle.getString(KEY_MESSAGE);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.text_view_fragment);

        if(message != null) {
            textView.setText(message);
        }
    }
}
