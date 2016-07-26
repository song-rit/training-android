package th.ac.sut.listview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import th.ac.sut.listview.R;

/**
 * Created by Developer on 26/7/2559.
 */
public class ListViewCustomImageAdapter extends BaseAdapter {

    Context context;
    String[] strName;
    int[] resourceId;

    public ListViewCustomImageAdapter(Context context, String[] strName, int[] resId) {
        this.context = context;
        this.strName = strName;
        this.resourceId = resId;
    }

    @Override
    public int getCount() {
        return strName.length;
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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_view_custom_image, parent, false);

        if(view == null) {
            view = inflater.inflate(R.layout.list_view_custom_image, parent, false);
        }

        TextView textView = (TextView) view.findViewById(R.id.text_view_name);
        textView.setText(strName[position]);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_pic);
        imageView.setBackgroundResource(resourceId[position]);
        return view;
    }
}
