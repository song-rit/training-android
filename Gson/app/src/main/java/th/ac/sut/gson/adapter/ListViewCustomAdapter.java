package th.ac.sut.gson.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import th.ac.sut.gson.R;
import th.ac.sut.gson.model.Post;

/**
 * Created by developer on 14/5/2559.
 */
public class ListViewCustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Post> posts;
    private Bitmap bitmap;

    public ListViewCustomAdapter(Activity activity, List<Post> posts) {
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_custom, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.text_view_post_title);
            viewHolder.author = (TextView) convertView.findViewById(R.id.text_view_post_author);
            viewHolder.date = (TextView) convertView.findViewById(R.id.text_view_post_date);
            viewHolder.thumbnail = (ImageView) convertView.findViewById(R.id.image_view_post_thumbnail);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Post post = posts.get(position);
        viewHolder.title.setText(post.getTitle());
        viewHolder.author.setText(post.getAuthor());
        viewHolder.date.setText(post.getDate());

        if (post.getThumbnail() != null) {
            new AsyncTask<Void, Void, Void>(){

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        URL url = new URL(post.getThumbnail());
                        bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }


            }.execute();
        }
        viewHolder.thumbnail.setImageBitmap(bitmap);

        return convertView;
    }

    private class ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView author;
        TextView date;
    }
}
