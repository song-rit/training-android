package th.ac.sut.picasso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import th.ac.sut.picasso.R;

/**
 * Created by developer on 24/8/2559.
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    String[] urls;
    LayoutInflater inflater;

    public GridViewAdapter(Context context, String[] urls) {
        this.context = context;
        this.urls = urls;
        inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object getItem(int position) {
        return urls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        View view = convertView;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.grid_image, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_view);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Picasso.with(context)
                .load(urls[position])
//                .resize(50, 50)
//                .centerCrop()
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .into(viewHolder.imageView);

        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
    }

}
