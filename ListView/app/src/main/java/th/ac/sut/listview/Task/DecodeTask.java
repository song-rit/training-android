package th.ac.sut.listview.Task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by Developer on 27/7/2559.
 */
public class DecodeTask extends AsyncTask<String, Void, Bitmap> {
    Context context;
    ImageView imageView;
    int resourceId;


    public DecodeTask(Context context, ImageView imageView, int resourceId) {
        this.context = context;
        this.imageView = imageView;
        this.resourceId = resourceId;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        return decodeBitmapFromResource(resourceId, 300, 300);
    }

    @Override
    protected void onPostExecute(Bitmap result) {
       imageView.setImageBitmap(result);
    }

    private Bitmap decodeBitmapFromResource(int resourceId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), resourceId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId, options);
        return bitmap;
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if(height > reqHeight || width > reqWidth) {
            if(width > height)
                inSampleSize = Math.round((float) height / (float) reqHeight);
            else
                inSampleSize = Math.round((float) width / (float) reqWidth);
        }
        return inSampleSize;
    }
}
