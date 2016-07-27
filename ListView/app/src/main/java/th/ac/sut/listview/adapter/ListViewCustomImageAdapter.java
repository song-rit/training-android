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
import th.ac.sut.listview.Task.DecodeTask;
import th.ac.sut.listview.model.Image;

/**
 * Created by Developer on 26/7/2559.
 */
public class ListViewCustomImageAdapter extends BaseAdapter {

    Context context;
    ArrayList<Image> images = new ArrayList<>();
    LayoutInflater inflater;

    public ListViewCustomImageAdapter(Context context, ArrayList<Image> images) {
        this.context = context;
        this.images = images;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
//        View view = inflater.inflate(R.layout.list_view_custom_image2, parent, false);
        ImageView imageView = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_custom_image2, parent, false);
            imageView = (ImageView) convertView.findViewById(R.id.image_view_pic);
        } else {
            imageView = (ImageView) convertView.findViewById(R.id.image_view_pic);
            DecodeTask dt1 = (DecodeTask) imageView.getTag(R.id.image_view_pic);

            if (dt1 != null) {
                dt1.cancel(true);
            }
        }

        imageView.setImageBitmap(null);
        DecodeTask dt2 = new DecodeTask(context, imageView, image.getResourceId());
        dt2.execute();
        imageView.setTag(R.id.image_view_pic, dt2);

        TextView textView = (TextView) convertView.findViewById(R.id.text_view_name);
        textView.setText(image.getName());

        return convertView;
    }
}
