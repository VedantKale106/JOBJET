package com.example.booker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    String []  names;
    int []  rate;
    int [] images ;

    LayoutInflater inflater;
    public CustomBaseAdapter(Context ctx , String[] names , int [] images ,int[] rate){
        this.context = ctx ;
        this.names = names ;
        this.images = images;
        this.rate = rate;
        inflater = LayoutInflater.from(ctx);

    }
    @Override
    public int getCount() {
        return names.length;
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
        convertView = inflater.inflate(R.layout.activity_custom_list,null);
        TextView textView1 = (TextView) convertView.findViewById(R.id.profileName);
        TextView textView2 = (TextView) convertView.findViewById(R.id.profileRate);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.profilePic);
        textView1.setText(names[position]);
        textView2.setText("Rate: "+rate[position]+" Rs/Hr");
        imageView.setImageResource(images[position]);
        return convertView;
    }
}
