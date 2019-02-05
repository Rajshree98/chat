package com.nema.rajshree.chitchatting;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class nameAdapter extends ArrayAdapter {
    ArrayList<Message> list ;
    int resource;
    Context context;
    public nameAdapter(@NonNull Context context, int resource, ArrayList<Message> objects) {
        super(context, resource,objects);
        this.context=context;
        this.resource=resource;
        this.list=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_name, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.nametv);
        Message message = (Message) getItem(position);

        name.setText(message.getName());
        return convertView;
    }
}
