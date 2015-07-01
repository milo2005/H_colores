package unicauca.movil.holamundo.coleccionesii.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import unicauca.movil.holamundo.coleccionesii.R;
import unicauca.movil.holamundo.coleccionesii.models.ColorItem;

/**
 * Created by DarioFernando on 01/07/2015.
 */
public class ColorAdapter extends BaseAdapter {

    Context context;
    List<ColorItem> data;

    public ColorAdapter(Context context, List<ColorItem> data) {
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
        View v;
        if(convertView == null)
            v = View.inflate(context, R.layout.template_color, null);
        else
            v = convertView;

        ColorItem colorItem = (ColorItem) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.txt);
        txt.setText(colorItem.getNombre());

        txt = (TextView) v.findViewById(R.id.txt_hex);
        txt.setText(colorItem.getNombreHex());

        ImageView img = (ImageView) v.findViewById(R.id.img);

        Uri uri = Uri.parse(colorItem.getUrl());
        Picasso.with(context).load(uri).into(img);

        return v;
    }
}
