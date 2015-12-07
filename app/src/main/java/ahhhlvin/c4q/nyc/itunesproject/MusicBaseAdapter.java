package ahhhlvin.c4q.nyc.itunesproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by alvin2 on 12/6/15.
 */
public class MusicBaseAdapter extends android.widget.BaseAdapter {

    Context context;
    List<Music> rowItems;

    public MusicBaseAdapter(Context context, List<Music> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView dateView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {


            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.result_text);
            holder.dateView = (TextView) convertView.findViewById(R.id.date_text);
            holder.imageView = (ImageView) convertView.findViewById(R.id.result_image);

            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Music musicItem = (Music) getItem(position);


        Picasso.with(context).load(musicItem.getMusicPictureURL()).into(holder.imageView);
        holder.textView.setText(musicItem.getSongArtistName() + ", " + musicItem.getSongName() + " (" + musicItem.getSongGenreName() + ")");
        holder.dateView.setText(musicItem.getSongReleaseDate());


        return convertView;
    }
}
