package th.ac.sut.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import th.ac.sut.listview.R;
import th.ac.sut.listview.model.Image;

/**
 * Created by Developer on 26/7/2559.
 */
public class ListViewCustomImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<Image>  images = new ArrayList<>();

    public ListViewCustomImageAdapter(Context context, ArrayList<Image> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Image image = (Image) getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_view_custom_image2, parent, false);

        if(view == null) {
            view = inflater.inflate(R.layout.list_view_custom_image2, parent, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.text_view_name);
        textView.setText(image.getName());

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_pic);
        imageView.setBackgroundResource(image.getResourceId());
        return view;
    }
}
