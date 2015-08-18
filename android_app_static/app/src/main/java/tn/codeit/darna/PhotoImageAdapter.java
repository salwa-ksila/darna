package tn.codeit.darna;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.effectivenavigation.R;

/**
 * Created by macbookpro on 03/08/2015.
 */
public class PhotoImageAdapter extends BaseAdapter {
    private Context mContext;
    private  int color;
    private  Paint paint;
    private  Rect rect;
    private  RectF rectF;
    private  Bitmap imageOut;
    private  Canvas canvas;
    private  float roundPx;

    ImageView image;


    public PhotoImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RoundImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new RoundImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(250,175));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);

        } else {
            imageView = (RoundImageView) convertView;
        }
        Bitmap bmp=BitmapFactory.decodeResource(mContext.getResources(), mThumbIds[position]);
        imageView.setImageBitmap(getRoundedRectBitmap(bmp,12));

        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6
    };

    public  Bitmap getRoundedRectBitmap(Bitmap bitmap, int pixels)
    {
        imageOut = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),               Bitmap.Config.ARGB_8888);
        canvas = new Canvas(imageOut);

        color = 0xff424242;
        paint = new Paint();
        rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        rectF = new RectF(rect);
        roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);


        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

       /* paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);*/


        return imageOut;
    }

}

