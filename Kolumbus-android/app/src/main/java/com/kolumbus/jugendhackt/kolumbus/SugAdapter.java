package com.kolumbus.jugendhackt.kolumbus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rico on 13.09.2014.
 */
public class SugAdapter extends ArrayAdapter<Sug>{

    Context context;
    int layoutResourceId;

    List<Sug> list = new ArrayList<Sug>();

    public SugAdapter(Context context, int layoutResourceId, List<Sug> data){
        super(context, layoutResourceId);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.list = data;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        SugHolder holder = null;

        if (row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder  = new SugHolder();

            holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            holder.txttext = (TextView)row.findViewById(R.id.btn_inputlos);

            row.setTag(holder);
        }
        else{
            holder = (SugHolder)row.getTag();
        }


        holder.txtTitle.setText(list.get(position).getTitle());
        holder.imgIcon.setImageResource(list.get(position).getIcon());
        holder.txttext.setText(list.get(position).getText());

        return row;
    }

    static class  SugHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
        TextView txttext;
    }
}
