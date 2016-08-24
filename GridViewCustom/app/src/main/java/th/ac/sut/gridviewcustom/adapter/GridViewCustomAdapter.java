package th.ac.sut.gridviewcustom.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.zip.Inflater;

import th.ac.sut.gridviewcustom.R;

/**
 * Created by developer on 24/8/2559.
 */
public class GridViewCustomAdapter extends BaseAdapter {

    private Context context;
    LayoutInflater inflater;

    public GridViewCustomAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.custom_image, parent, false);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(R.drawable.smile);
        return view;
    }
}
