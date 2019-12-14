package com.photoncat.pointtracker;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class PlayerListAdapter extends ArrayAdapter<Player> {
    private List<Player> items;
    private int layoutResourceId;
    private Context context;

    public PlayerListAdapter(Context context, int layoutResourceId, List<Player> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
            holder = new PlayerHolder();
            holder.player = items.get(position);
            holder.checkOrCallButton = convertView.findViewById(R.id.check_or_call);
            holder.checkOrCallButton.setTag(position);
            holder.raiseButton = convertView.findViewById(R.id.raise);
            holder.raiseButton.setTag(position);
            holder.foldButton = convertView.findViewById(R.id.fold);
            holder.foldButton.setTag(position);
            holder.name = convertView.findViewById(R.id.player_name);
            holder.value = convertView.findViewById(R.id.current_point);
            convertView.setTag(holder);
        } else {
            holder = (PlayerHolder) convertView.getTag();
        }

        setupItem(holder);
        return convertView;
    }

    private void setupItem(PlayerHolder holder) {
        holder.name.setText(holder.player.name);
        holder.value.setText(String.valueOf(holder.player.currentPoint));
    }

    public static class PlayerHolder {
        Player player;
        TextView name;
        TextView value;
        Button checkOrCallButton;
        Button raiseButton;
        Button foldButton;
    }
}
