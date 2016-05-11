package th.ac.sut.spinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import th.ac.sut.spinner.R;

/**
 * Created by developer on 11/5/2559.
 */
public class CustomSpinnerAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> data;
    private LayoutInflater inflater;

    public CustomSpinnerAdapter(Context context, ArrayList<String> data) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.spinner_custom_dropdown_item, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.text_view_name);
            holder.logo = (ImageView) convertView.findViewById(R.id.image_view_logo);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int imgResourceId;

        if (position % 2 == 0) {
            imgResourceId = R.drawable.ic_tag_faces_black_24dp;
        } else {
            imgResourceId = R.drawable.ic_android_black_24dp;
        }


        holder.name.setText(data.get(position));
        holder.logo.setImageResource(imgResourceId);

        convertView.setTag(holder);
        return convertView;
    }

    private class ViewHolder {

        TextView name;
        ImageView logo;
    }
}
