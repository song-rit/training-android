package th.ac.sut.listview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import th.ac.sut.listview.ListViewCustomExample;
import th.ac.sut.listview.R;

/**
 * Created by developer on 11/5/2559.
 */
public class ListViewCustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<String> family = new ArrayList<>();

    public ListViewCustomAdapter(Activity activity, List<String> family) {
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.family = family;
    }


    @Override
    public int getCount() {
        return family.size();
    }

    @Override
    public Object getItem(int position) {
        return family.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_listview, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.text_view_title);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(family.get(position));
        return convertView;
    }

    private class ViewHolder {
        TextView name;
    }
}
