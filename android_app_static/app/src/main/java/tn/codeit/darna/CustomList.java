package tn.codeit.darna;

/**
 * Created by macbookpro on 05/08/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.effectivenavigation.R;

public class CustomList extends ArrayAdapter<String>{

    private final Context context;
    private final String[] title;
    private final String[] prix;
    private final Integer[] imageId;
    public CustomList(Context context,
                      String[] title,String[] prix, Integer[] imageId) {
        super(context, R.layout.list_single, title);
        this.context = context;
        this.title = title;
        this.prix = prix;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        TextView txtPrix = (TextView) rowView.findViewById(R.id.txt2);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(title[position]);
        txtPrix.setText(prix[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
